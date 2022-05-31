package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.android.server.SystemConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.download.ZeusPluginListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes4.dex */
public class Zeus {
    public static /* synthetic */ Interceptable $ic;
    public static Application sApplication;
    public static final HashMap<String, ProviderInfo> serverManagerHashMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-537877244, "Lcom/bytedance/pangle/Zeus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-537877244, "Lcom/bytedance/pangle/Zeus;");
                return;
            }
        }
        serverManagerHashMap = new HashMap<>();
    }

    public Zeus() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void clearOfflineFlag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            j.a().c(str);
        }
    }

    public static void downloadAndInstall(String str, ZeusPluginListener zeusPluginListener) {
        PluginDownloadBean pluginDownloadBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, zeusPluginListener) == null) {
            com.bytedance.pangle.download.g a = com.bytedance.pangle.download.g.a();
            synchronized (a) {
                Iterator<PluginDownloadBean> it = a.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        pluginDownloadBean = null;
                        break;
                    }
                    pluginDownloadBean = it.next();
                    if (TextUtils.equals(pluginDownloadBean.mPackageName, str)) {
                        break;
                    }
                }
                if (pluginDownloadBean == null) {
                    Iterator<PluginDownloadBean> it2 = a.b.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        PluginDownloadBean next = it2.next();
                        if (TextUtils.equals(next.mPackageName, str)) {
                            pluginDownloadBean = next;
                            break;
                        }
                    }
                }
            }
            if (pluginDownloadBean != null) {
                pluginDownloadBean.isWifiOnly = false;
                com.bytedance.pangle.download.g.a(pluginDownloadBean, zeusPluginListener);
                return;
            }
            zeusPluginListener.onEvent(13, "The plugin was not found in the cache.");
            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "The plugin was not found in the cache.");
        }
    }

    public static Application getAppApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sApplication == null) {
                b.a();
                try {
                    sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.helper.a.a(), "getApplication", new Object[0]);
                } catch (Throwable unused) {
                }
            }
            return sApplication;
        }
        return (Application) invokeV.objValue;
    }

    public static String getHostAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? com.bytedance.pangle.helper.b.a() : (String) invokeV.objValue;
    }

    public static int getHostAbiBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? com.bytedance.pangle.helper.b.b() : invokeV.intValue;
    }

    public static int getInstalledPluginVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            Plugin plugin = PluginManager.getInstance().getPlugin(str);
            if (plugin == null) {
                return -1;
            }
            int version = plugin.getVersion();
            ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
            return version;
        }
        return invokeL.intValue;
    }

    public static Plugin getPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? getPlugin(str, true) : (Plugin) invokeL.objValue;
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? serverManagerHashMap : (HashMap) invokeV.objValue;
    }

    public static boolean hasInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? g.a().a : invokeV.booleanValue;
    }

    public static boolean hasNewPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? com.bytedance.pangle.download.g.a().a(str) : invokeL.booleanValue;
    }

    public static boolean hasOfflineFlag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? j.a().d(str) : invokeL.booleanValue;
    }

    public static void init(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, application) == null) {
            init(application, new ZeusParam.Builder().build());
        }
    }

    public static boolean isPluginInstalled(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            Plugin plugin = PluginManager.getInstance().getPlugin(str);
            return plugin != null && plugin.isInstalled();
        }
        return invokeL.booleanValue;
    }

    public static boolean isPluginLoaded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? PluginManager.getInstance().isLoaded(str) : invokeL.booleanValue;
    }

    public static boolean loadPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) ? PluginManager.getInstance().loadPlugin(str) : invokeL.booleanValue;
    }

    public static void markOfflineFlag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            j.a().b(str);
        }
    }

    public static void preInit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, null) == null) && com.bytedance.pangle.util.g.e()) {
            com.bytedance.pangle.helper.e.a.execute(new Runnable() { // from class: com.bytedance.pangle.Zeus.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        b.a();
                        try {
                            SystemConfig.getInstance();
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, zeusPluginStateListener) == null) {
            g a = g.a();
            if (a.c.isEmpty()) {
                a.c = new CopyOnWriteArrayList();
            }
            a.c.add(zeusPluginStateListener);
        }
    }

    public static void setAppContext(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, application) == null) {
            sApplication = application;
        }
    }

    public static boolean syncInstallPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            c a = com.bytedance.pangle.servermanager.b.a();
            if (a != null) {
                try {
                    return a.c(str);
                } catch (RemoteException e) {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean unInstallPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            ZeusLogger.d("unInstallPlugin");
            return PluginManager.getInstance().deletePackage(str) == 0;
        }
        return invokeL.booleanValue;
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        g a;
        List<ZeusPluginStateListener> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65561, null, zeusPluginStateListener) == null) && (list = (a = g.a()).c) != null && list.contains(zeusPluginStateListener)) {
            a.c.remove(zeusPluginStateListener);
        }
    }

    public static Plugin getPlugin(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, str, z)) == null) ? PluginManager.getInstance().getPlugin(str, z) : (Plugin) invokeLZ.objValue;
    }

    public static void init(Application application, ZeusParam zeusParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, application, zeusParam) == null) {
            setAppContext(application);
            g.a().a(application, zeusParam);
        }
    }
}
