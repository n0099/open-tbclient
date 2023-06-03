package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes9.dex */
public class PluginManager {
    public static final String TAG = "PluginManager";
    public static volatile PluginManager sInstance;
    public volatile boolean hasInstallFromDownloadDir;
    public ExecutorService mInstallThreadPool;
    public volatile boolean mIsParsePluginConfig;
    public volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    public final c pluginLoader = new c();

    public static PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new PluginManager();
                }
            }
        }
        return sInstance;
    }

    public ExecutorService getInstallThreadPool() {
        if (this.mInstallThreadPool == null) {
            this.mInstallThreadPool = e.a(GlobalParam.getInstance().getInstallThreads());
        }
        return this.mInstallThreadPool;
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
            e.a.execute(new d());
        }
        this.hasInstallFromDownloadDir = true;
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin != null && plugin.isInstalled() && !new File(com.bytedance.pangle.c.c.b(plugin.mPkgName, plugin.getVersion())).exists()) {
            unInstallPackage(plugin.mPkgName);
        }
    }

    public boolean checkPluginInstalled(String str) {
        boolean z;
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        if (plugin != null && plugin.isInstalled()) {
            z = true;
        } else {
            z = false;
        }
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
        return z;
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        if (plugin != null && plugin.isLoaded()) {
            return true;
        }
        return false;
    }

    public boolean loadPlugin(String str) {
        return this.pluginLoader.a(str);
    }

    private synchronized void parsePluginConfig() {
        if (this.mIsParsePluginConfig) {
            return;
        }
        ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
        ArrayList<String> arrayList = new ArrayList();
        try {
            Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
            for (String str : bundle.keySet()) {
                if (str.startsWith("ZEUS_PLUGIN_")) {
                    arrayList.add(bundle.getString(str));
                }
            }
            try {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (String str2 : arrayList) {
                    try {
                        Plugin plugin = new Plugin(new JSONObject(str2));
                        concurrentHashMap.put(plugin.mPkgName, plugin);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManagerparsePluginsJson. find " + plugin.mPkgName);
                    } catch (JSONException e) {
                        ZeusLogger.e(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str2.trim(), e);
                    }
                }
                this.mPlugins = concurrentHashMap;
                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
            } catch (Exception e2) {
                ZeusLogger.e(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e2);
            }
            this.mIsParsePluginConfig = true;
        } catch (Exception e3) {
            ZeusLogger.e(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e3);
        }
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            getInstallThreadPool().execute(new a(str, file));
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
            return;
        }
        ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
    }

    public Plugin getPlugin(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (z && plugin != null) {
            plugin.init();
        }
        return plugin;
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new a(str, file).a();
    }

    public void setAllowDownloadPlugin(String str, int i, boolean z) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + str + " " + i + " " + z);
        if (getPlugin(str) != null) {
            SharedPreferences.Editor edit = l.a().a.edit();
            edit.putBoolean("ALLOW_DOWNLOAD__" + str + "_" + i, z);
            edit.apply();
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i + " allow=" + z);
        }
    }

    public void tryOfflineInternalPlugin(String str, int i) {
        Plugin plugin = getPlugin(str);
        if (plugin != null && plugin.getInternalVersionCode() == i) {
            ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i + " apiVer:" + plugin.getApiVersionCode());
            l a = l.a();
            int apiVersionCode = plugin.getApiVersionCode();
            SharedPreferences.Editor edit = a.a.edit();
            edit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), apiVersionCode);
            edit.apply();
        }
    }

    public void unInstallPackage(String str) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            SharedPreferences.Editor edit = l.a().a.edit();
            edit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
            edit.apply();
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
        }
    }
}
