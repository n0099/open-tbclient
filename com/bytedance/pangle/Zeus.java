package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.android.server.SystemConfig;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.bytedance.pangle.util.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes11.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void clearOfflineFlag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            k.a().c(str);
        }
    }

    public static void downloadAndInstall(String str, ZeusPluginListener zeusPluginListener) {
        PluginDownloadBean pluginDownloadBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, zeusPluginListener) == null) {
            com.bytedance.pangle.download.h a2 = com.bytedance.pangle.download.h.a();
            synchronized (a2) {
                Iterator<PluginDownloadBean> it = a2.f62248c.iterator();
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
                    Iterator<PluginDownloadBean> it2 = a2.f62247b.iterator();
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
                com.bytedance.pangle.download.h.a(pluginDownloadBean, zeusPluginListener);
                return;
            }
            zeusPluginListener.onEvent(13, "The plugin was not found in the cache.");
            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "The plugin was not found in the cache.");
        }
    }

    public static Application getAppApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sApplication : (Application) invokeV.objValue;
    }

    public static String getHostAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? com.bytedance.pangle.helper.b.a() : (String) invokeV.objValue;
    }

    public static int getHostAbiBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? com.bytedance.pangle.helper.b.b() : invokeV.intValue;
    }

    public static int getInstalledPluginVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            Plugin plugin2 = PluginManager.getInstance().getPlugin(str);
            if (plugin2 == null) {
                return -1;
            }
            int version = plugin2.getVersion();
            ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
            return version;
        }
        return invokeL.intValue;
    }

    public static Plugin getPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? PluginManager.getInstance().getPlugin(str) : (Plugin) invokeL.objValue;
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? serverManagerHashMap : (HashMap) invokeV.objValue;
    }

    public static boolean hasInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? i.a().f62336a : invokeV.booleanValue;
    }

    public static boolean hasNewPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? com.bytedance.pangle.download.h.a().a(str) : invokeL.booleanValue;
    }

    public static boolean hasOfflineFlag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? k.a().d(str) : invokeL.booleanValue;
    }

    public static void init(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, application) == null) {
            init(application, new ZeusParam.Builder().build());
        }
    }

    public static boolean isPluginInstalled(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            Plugin plugin2 = PluginManager.getInstance().getPlugin(str);
            return plugin2 != null && plugin2.isInstalled();
        }
        return invokeL.booleanValue;
    }

    public static boolean isPluginLoaded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? PluginManager.getInstance().isLoaded(str) : invokeL.booleanValue;
    }

    public static boolean loadPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? PluginManager.getInstance().loadPlugin(str) : invokeL.booleanValue;
    }

    public static void markOfflineFlag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            k.a().b(str);
        }
    }

    public static void preInit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, null) == null) && com.bytedance.pangle.util.h.e()) {
            com.bytedance.pangle.helper.e.f62332a.execute(new Runnable() { // from class: com.bytedance.pangle.Zeus.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.a();
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
        if (interceptable == null || interceptable.invokeL(65556, null, zeusPluginStateListener) == null) {
            i a2 = i.a();
            if (a2.f62338c.isEmpty()) {
                a2.f62338c = new CopyOnWriteArrayList();
            }
            a2.f62338c.add(zeusPluginStateListener);
        }
    }

    public static void setAppContext(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, application) == null) {
            sApplication = application;
        }
    }

    public static boolean syncInstallPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            d a2 = com.bytedance.pangle.servermanager.b.a();
            if (a2 != null) {
                try {
                    return a2.c(str);
                } catch (RemoteException e2) {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e2);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            ZeusLogger.d("unInstallPlugin");
            return PluginManager.getInstance().deletePackage(str) == 0;
        }
        return invokeL.booleanValue;
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        i a2;
        List<ZeusPluginStateListener> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65560, null, zeusPluginStateListener) == null) && (list = (a2 = i.a()).f62338c) != null && list.contains(zeusPluginStateListener)) {
            a2.f62338c.remove(zeusPluginStateListener);
        }
    }

    public static void init(Application application, ZeusParam zeusParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, application, zeusParam) == null) {
            setAppContext(application);
            i.a().a(application, zeusParam);
        }
    }
}
