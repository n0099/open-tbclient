package com.bytedance.pangle.plugin;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.download.ZeusPluginListener;
import com.bytedance.pangle.g;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.helper.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes7.dex */
public class PluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PluginManager";
    public static volatile PluginManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Plugin> loadedPlugin;
    public Handler mHandler;
    public ExecutorService mInstallThreadPool;
    public volatile boolean mIsParsePluginConfig;
    public volatile Map<String, Plugin> mPlugins;
    public b pluginInstaller;
    public c pluginLoader;

    public PluginManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.loadedPlugin = new HashMap<>();
        this.mPlugins = new ConcurrentHashMap();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.pluginLoader = new c();
        this.pluginInstaller = new b();
    }

    private void ensurePluginFileExist(Plugin plugin2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, plugin2) == null) || plugin2 == null || !plugin2.isInstalled() || new File(PluginDirHelper.getSourceFile(plugin2.mPkgName, plugin2.getVersion())).exists()) {
            return;
        }
        deletePackage(plugin2.mPkgName);
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
                                Plugin plugin2 = new Plugin(new JSONObject(str2), this.mHandler);
                                concurrentHashMap.put(plugin2.mPkgName, plugin2);
                                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManagerparsePluginsJson. find " + plugin2.mPkgName);
                            } catch (JSONException e2) {
                                ZeusLogger.e(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str2.trim(), e2);
                            }
                        }
                        this.mPlugins = concurrentHashMap;
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
                    } catch (Exception e3) {
                        ZeusLogger.e(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e3);
                    }
                    this.mIsParsePluginConfig = true;
                } catch (PackageManager.NameNotFoundException e4) {
                    ZeusLogger.e(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e4);
                }
            }
        }
    }

    public void asyncInstall(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
            asyncInstall(file, null);
        }
    }

    public boolean checkPluginInstalled(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Plugin plugin2 = getPlugin(str);
            ensurePluginFileExist(plugin2);
            boolean z = plugin2 != null && plugin2.isInstalled();
            ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || getPlugin(str) == null) {
            return;
        }
        j.a().e(str);
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager mark deleted : ".concat(String.valueOf(str)));
    }

    public int deletePackage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager deletePackage, ".concat(String.valueOf(str)));
            if (getPlugin(str) != null) {
                j.a().e(str);
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager mark deleted : ".concat(String.valueOf(str)));
                return 0;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public Plugin getPlugin(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            if (str == null) {
                return null;
            }
            if (!this.mIsParsePluginConfig) {
                parsePluginConfig();
            }
            Plugin plugin2 = this.mPlugins.get(str);
            if (!z || plugin2 == null) {
                return null;
            }
            plugin2.init();
            return plugin2;
        }
        return (Plugin) invokeLZ.objValue;
    }

    public List<Plugin> getPlugins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.mIsParsePluginConfig) {
                parsePluginConfig();
            }
            for (Plugin plugin2 : this.mPlugins.values()) {
                plugin2.init();
            }
            return new ArrayList(this.mPlugins.values());
        }
        return (List) invokeV.objValue;
    }

    public void installFromDownloadDir() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && com.bytedance.pangle.helper.c.b(Zeus.getAppApplication())) {
            if (this.mInstallThreadPool == null) {
                this.mInstallThreadPool = e.a(g.a().f51712b.getInstallThreads());
            }
            e.a.execute(new d());
        }
    }

    public boolean isLoaded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            Plugin plugin2 = getPlugin(str);
            return plugin2 != null && plugin2.isLoaded();
        }
        return invokeL.booleanValue;
    }

    public boolean loadPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.pluginLoader.a(str) : invokeL.booleanValue;
    }

    public boolean syncInstall(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, file)) == null) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
            return new a(file, null).a();
        }
        return invokeL.booleanValue;
    }

    public void asyncInstall(File file, ZeusPluginListener zeusPluginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, zeusPluginListener) == null) {
            if (file != null) {
                ExecutorService executorService = this.mInstallThreadPool;
                if (executorService != null) {
                    executorService.execute(new a(file, zeusPluginListener));
                }
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
                return;
            }
            if (zeusPluginListener != null) {
                zeusPluginListener.onEvent(22, "asyncInstall apk is null !");
            }
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        }
    }

    public Plugin getPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? getPlugin(str, true) : (Plugin) invokeL.objValue;
    }
}
