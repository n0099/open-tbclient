package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.nps.utils.Constant;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusConstants;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.b;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.f;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.j;
import com.bytedance.pangle.util.l;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
@Keep
/* loaded from: classes8.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    public static final String TAG = "Plugin";
    public int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    public volatile boolean mInitialized;
    public String mInternalPath;
    public int mInternalVersionCode;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    public String mPackageDir;
    public String mPkgName;
    public Resources mResources;
    public String mSignature;
    public int mVersionCode;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    public volatile int mLifeCycle = 1;
    public final Object installLock = new Object();
    public final Object initializeLock = new Object();

    public Plugin(JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        this.mSignature = jSONObject.optString(SocialOperation.GAME_SIGNATURE, "");
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString("appKey", "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        setupInternalPlugin();
    }

    private void updateToInstalled(int i) {
        this.mVersionCode = i;
        this.mLifeCycle = 2;
    }

    public boolean isVersionInstalled(int i) {
        return l.a().a(this.mPkgName, i);
    }

    public void setLifeCycle(int i) {
        this.mLifeCycle = i;
    }

    private boolean checkValid(File file, String str, int i) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        } else if (i >= this.mMinVersionCode && i <= this.mMaxVersionCode) {
            if (i < this.mVersionCode && isInstalled()) {
                String format = String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i), Integer.valueOf(this.mVersionCode));
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + format);
                return false;
            } else if (file != null && file.exists()) {
                if (i == this.mVersionCode && l.a().a.getString("MD5_".concat(String.valueOf(str)), "").equals(e.a(file))) {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same md5 has already installed.");
                    return false;
                }
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i + " true");
                return true;
            } else {
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
                return false;
            }
        } else {
            String format2 = String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode));
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + format2);
            return false;
        }
    }

    private boolean checkVersionValid(int i, int i2, boolean z) {
        boolean z2;
        int a = l.a().a(this.mPkgName);
        boolean z3 = false;
        if (a > i2) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(a), Integer.valueOf(i2)))));
            return false;
        }
        if (i >= 0 && i >= this.mMinVersionCode && i <= this.mMaxVersionCode) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && i2 != -1) {
            l a2 = l.a();
            String str = this.mPkgName;
            SharedPreferences sharedPreferences = a2.a;
            int i3 = sharedPreferences.getInt("API_MIN_" + str + "_" + i, 0);
            l a3 = l.a();
            String str2 = this.mPkgName;
            SharedPreferences sharedPreferences2 = a3.a;
            int i4 = Integer.MAX_VALUE;
            int i5 = sharedPreferences2.getInt("API_MAX_" + str2 + "_" + i, Integer.MAX_VALUE);
            if (i5 != 0) {
                i4 = i5;
            }
            if (i2 < i3 || i2 > i4) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)))));
                z2 = false;
            }
        }
        if (z2 && z && com.bytedance.pangle.c.b.b(new File(com.bytedance.pangle.c.c.b(this.mPkgName, i)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i)))));
        } else {
            z3 = z2;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z3);
        return z3;
    }

    private void deleteIfNeeded() {
        if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
            if (l.a().a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
                l a = l.a();
                String str = this.mPkgName;
                SharedPreferences.Editor edit = a.a.edit();
                edit.remove("UNINSTALL__".concat(String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.c.c.a(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        f.a(this.mPackageDir);
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication()) && getVersion() < this.mInternalVersionCode && !TextUtils.isEmpty(this.mInternalPath)) {
            com.bytedance.pangle.c.e.a.execute(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        String b = com.bytedance.pangle.c.c.b();
                        File file = new File(b, Plugin.this.mPkgName + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        g.a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                            return;
                        }
                        ZeusLogger.e(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                    } catch (Throwable th) {
                        ZeusLogger.e(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. ", th);
                    }
                }
            });
        }
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i = this.mVersionCode;
        if (i > 0) {
            return com.bytedance.pangle.c.c.d(this.mPkgName, i);
        }
        return com.bytedance.pangle.c.c.a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        if (this.mLifeCycle >= 2) {
            return true;
        }
        return false;
    }

    public boolean isLoaded() {
        if (this.mLifeCycle == 3) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }

    private void deleteOtherExpiredVer(int i) {
        if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.c.c.a(this.mPkgName);
            }
            final String concat = "version-".concat(String.valueOf(i));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    if (file != null && !concat.equals(file.getName()) && !"data".equals(file.getName())) {
                        f.a(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void modifyResIfNeed(int i) {
        if (!TextUtils.equals(l.a().b(this.mPkgName), com.bytedance.pangle.util.b.b(Zeus.getAppApplication()))) {
            ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
            try {
                b.a(com.bytedance.pangle.c.c.b(this.mPkgName, i), this.mPkgName, i);
            } catch (b.a e) {
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, "modify res failed.", e);
            }
        }
    }

    private void setupInternalPlugin() {
        boolean z;
        String[] list;
        int a;
        if (l.a().a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        if (!TextUtils.isEmpty(this.mInternalPath) && this.mInternalVersionCode != -1) {
            return;
        }
        try {
            for (String str : Zeus.getAppApplication().getAssets().list(ZeusConstants.d)) {
                if (str.startsWith(this.mPkgName + "_") && (a = j.a(str.split("_")[1])) != -1) {
                    this.mInternalPath = ZeusConstants.d + "/" + str;
                    this.mInternalVersionCode = a;
                    return;
                }
            }
        } catch (IOException e) {
            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
        }
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.c.c.a(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file != null && file.getName().matches("^version-(\\d+)$")) {
                    return true;
                }
                return false;
            }
        });
        int i = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                if (parseInt > i && l.a().a(this.mPkgName, parseInt) && new File(com.bytedance.pangle.c.c.b(this.mPkgName, parseInt)).exists()) {
                    i = parseInt;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i);
        return i;
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c a;
        try {
            if (!com.bytedance.pangle.c.d.a(Zeus.getAppApplication()) && this.mLifeCycle < 2 && (a = com.bytedance.pangle.servermanager.b.a()) != null && a.a(this.mPkgName)) {
                updateToInstalled(a.b(this.mPkgName));
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
            Zeus.getAppApplication();
            sb.append(com.bytedance.pangle.c.d.a());
            ZeusLogger.e(ZeusLogger.TAG_PPM, sb.toString(), this.mPkgName, th);
        }
    }

    public void init() {
        boolean z;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
                int i = 0;
                if (!TextUtils.isEmpty(l.a().a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    l a = l.a();
                    String str = this.mPkgName;
                    if (!TextUtils.equals(a.a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi())) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a.a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + StringUtil.ARRAY_ELEMENT_SEPARATOR + Zeus.getHostAbi() + ", result=" + z);
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z)) {
                    modifyResIfNeed(installedMaxVer);
                    updateToInstalled(installedMaxVer);
                    i = installedMaxVer;
                }
                deleteOtherExpiredVer(i);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                l a2 = l.a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor edit = a2.a.edit();
                edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                edit.apply();
                l a3 = l.a();
                String str3 = this.mPkgName;
                String string = a3.a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor edit2 = a3.a.edit();
                edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                edit2.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                l a4 = l.a();
                String str4 = this.mPkgName;
                String b = com.bytedance.pangle.util.b.b(Zeus.getAppApplication());
                String b2 = a4.b(str4);
                if (!TextUtils.equals(b2, b)) {
                    SharedPreferences.Editor edit3 = a4.a.edit();
                    edit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), b);
                    edit3.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + b2 + " --> " + b);
                l a5 = l.a();
                String str5 = this.mPkgName;
                int i2 = this.mApiVersionCode;
                int a6 = a5.a(str5);
                if (a6 != i2) {
                    SharedPreferences.Editor edit4 = a5.a.edit();
                    edit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i2);
                    edit4.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + a6 + " --> " + i2);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x015b -> B:29:0x015c). Please submit an issue!!! */
    public boolean install(File file, com.bytedance.pangle.e.a.e eVar) {
        boolean z;
        boolean z2 = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + StringUtil.ARRAY_ELEMENT_SEPARATOR + Thread.currentThread().getName());
            String str = eVar.a;
            int i = eVar.b;
            synchronized (this.installLock) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                    boolean checkValid = checkValid(file, str, i);
                    if (checkValid) {
                        z = b.a(file, str, i);
                        if (z) {
                            try {
                                String b = e.b(com.bytedance.pangle.c.c.b(this.mPkgName, i));
                                l a = l.a();
                                String str2 = this.mPkgName;
                                SharedPreferences.Editor edit = a.a.edit();
                                edit.putString("MD5_".concat(String.valueOf(str2)), b);
                                edit.apply();
                                l.a().a(this.mPkgName, i, true);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i + " md5=" + b);
                                f.a(file);
                            } catch (Throwable th) {
                                th = th;
                                z2 = z;
                            }
                        }
                    } else {
                        z = false;
                    }
                    synchronized (this) {
                        if (checkValid) {
                            if (this.mLifeCycle != 3) {
                                if (z) {
                                    updateToInstalled(i);
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i);
                                    ZeusPluginStateListener.postStateChange(this.mPkgName, 6, new Object[0]);
                                } else {
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i);
                                    ZeusPluginStateListener.postStateChange(this.mPkgName, 7, "Internal error.");
                                    f.a(file);
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i);
                                }
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i);
                            }
                        } else {
                            f.a(file);
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i);
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            throw th;
        } catch (Throwable th3) {
            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th3);
            return z2;
        }
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        l a = l.a();
        String str = this.mPkgName;
        SharedPreferences.Editor edit = a.a.edit();
        edit.putInt("API_MIN_" + str + "_" + i, i2);
        edit.putInt("API_MAX_" + str + "_" + i, i3);
        edit.apply();
    }
}
