package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class PluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PluginManager";
    public static volatile PluginManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean hasInstallFromDownloadDir;
    public ExecutorService mInstallThreadPool;
    public volatile boolean mIsParsePluginConfig;
    public volatile Map<String, Plugin> mPlugins;
    public final c pluginLoader;

    public PluginManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlugins = new ConcurrentHashMap();
        this.pluginLoader = new c();
    }

    private void ensurePluginFileExist(Plugin plugin) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, plugin) == null) || plugin == null || !plugin.isInstalled() || new File(com.bytedance.pangle.c.c.b(plugin.mPkgName, plugin.getVersion())).exists()) {
            return;
        }
        unInstallPackage(plugin.mPkgName);
    }

    public static PluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (PluginManager.class) {
                    if (sInstance == null) {
                        sInstance = new PluginManager();
                    }
                }
            }
            return sInstance;
        }
        return (PluginManager) invokeV.objValue;
    }

    private synchronized void parsePluginConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            synchronized (this) {
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
        }
    }

    public void asyncInstall(String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, file) == null) {
            if (file != null) {
                getInstallThreadPool().execute(new a(str, file));
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
                return;
            }
            ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        }
    }

    public boolean checkPluginInstalled(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Plugin plugin = getPlugin(str);
            ensurePluginFileExist(plugin);
            boolean z = plugin != null && plugin.isInstalled();
            ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public ExecutorService getInstallThreadPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mInstallThreadPool == null) {
                this.mInstallThreadPool = e.a(GlobalParam.getInstance().getInstallThreads());
            }
            return this.mInstallThreadPool;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public Plugin getPlugin(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
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
        return (Plugin) invokeLZ.objValue;
    }

    public synchronized void installFromDownloadDir() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.hasInstallFromDownloadDir) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
                    return;
                }
                if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
                    e.a.execute(new d());
                }
                this.hasInstallFromDownloadDir = true;
            }
        }
    }

    public boolean isLoaded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Plugin plugin = getPlugin(str);
            return plugin != null && plugin.isLoaded();
        }
        return invokeL.booleanValue;
    }

    public boolean loadPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.pluginLoader.a(str) : invokeL.booleanValue;
    }

    public void setAllowDownloadPlugin(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + str + " " + i + " " + z);
            if (getPlugin(str) != null) {
                SharedPreferences.Editor edit = l.a().a.edit();
                edit.putBoolean("ALLOW_DOWNLOAD__" + str + "_" + i, z);
                edit.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i + " allow=" + z);
            }
        }
    }

    public boolean syncInstall(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, file)) == null) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
            return new a(str, file).a();
        }
        return invokeLL.booleanValue;
    }

    public void tryOfflineInternalPlugin(String str, int i) {
        Plugin plugin;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048586, this, str, i) == null) && (plugin = getPlugin(str)) != null && plugin.getInternalVersionCode() == i) {
            ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i + " apiVer:" + plugin.getApiVersionCode());
            l a = l.a();
            int apiVersionCode = plugin.getApiVersionCode();
            SharedPreferences.Editor edit = a.a.edit();
            edit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), apiVersionCode);
            edit.apply();
        }
    }

    public void unInstallPackage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
            if (getPlugin(str) != null) {
                SharedPreferences.Editor edit = l.a().a.edit();
                edit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
                edit.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
            }
        }
    }

    public Plugin getPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? getPlugin(str, true) : (Plugin) invokeL.objValue;
    }
}
