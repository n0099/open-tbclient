package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.RemoteException;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.MethodUtils;
import com.yy.hiidostatis.inner.FlushManager;
import java.util.HashMap;
import java.util.List;
@Keep
/* loaded from: classes4.dex */
public class Zeus {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean onPrivacyAgreed;
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
        onPrivacyAgreed = false;
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

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, zeusPluginEventCallback) == null) {
            g a = g.a();
            if (zeusPluginEventCallback != null) {
                synchronized (a.c) {
                    a.c.add(zeusPluginEventCallback);
                }
            }
        }
    }

    public static void fetchPlugin(final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            com.bytedance.pangle.download.b a = com.bytedance.pangle.download.b.a();
            if (com.bytedance.pangle.c.d.a(getAppApplication())) {
                final com.bytedance.pangle.download.c a2 = com.bytedance.pangle.download.c.a();
                Runnable runnable = a2.c.get(str);
                if (runnable != null) {
                    a2.b.removeCallbacks(runnable);
                }
                Runnable runnable2 = new Runnable(a2, str) { // from class: com.bytedance.pangle.download.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;
                    public final /* synthetic */ c b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {a2, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = a2;
                        this.a = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && com.bytedance.pangle.util.b.a(Zeus.getAppApplication())) {
                            this.b.b.postDelayed(this, FlushManager.ReportTimer.DEFAULT_INTERVAL);
                        }
                    }
                };
                a2.c.put(str, runnable2);
                a2.b.postDelayed(runnable2, FlushManager.ReportTimer.DEFAULT_INTERVAL);
                com.bytedance.pangle.download.c.a();
                if (a.a.contains(str)) {
                    return;
                }
                a.a.add(str);
            }
        }
    }

    public static Application getAppApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sApplication == null) {
                b.a();
                try {
                    sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.c.a.a(), "getApplication", new Object[0]);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? com.bytedance.pangle.c.b.a() : (String) invokeV.objValue;
    }

    public static int getHostAbiBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? com.bytedance.pangle.c.b.b() : invokeV.intValue;
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

    public static int getMaxInstallVer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (com.bytedance.pangle.c.d.a(getAppApplication())) {
                return getPlugin(str).getInstalledMaxVer();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static Plugin getPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? getPlugin(str, true) : (Plugin) invokeL.objValue;
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? serverManagerHashMap : (HashMap) invokeV.objValue;
    }

    public static boolean hasInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? g.a().a : invokeV.booleanValue;
    }

    public static void init(Application application, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, application, z) == null) {
            g.a().a(application);
        }
    }

    public static void installFromDownloadDir() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, null) == null) && com.bytedance.pangle.c.d.a(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            Plugin plugin = PluginManager.getInstance().getPlugin(str);
            return plugin != null && plugin.isInstalled();
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

    public static synchronized void onPrivacyAgreed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            synchronized (Zeus.class) {
            }
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, zeusPluginStateListener) == null) {
            g.a().b.add(zeusPluginStateListener);
        }
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, zeusPluginEventCallback) == null) {
            g a = g.a();
            if (zeusPluginEventCallback != null) {
                synchronized (a.c) {
                    a.c.remove(zeusPluginEventCallback);
                }
            }
        }
    }

    public static void setAllowDownloadPlugin(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            PluginManager.getInstance().setAllowDownloadPlugin(str, i, z);
        }
    }

    public static void setAppContext(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, application) == null) {
            sApplication = application;
        }
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, str, str2)) == null) {
            c a = com.bytedance.pangle.servermanager.b.a();
            if (a != null) {
                try {
                    return a.a(str, str2);
                } catch (RemoteException e) {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void unInstallPlugin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, str) == null) {
            PluginManager.getInstance().unInstallPackage(str);
        }
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, zeusPluginStateListener) == null) || (list = g.a().b) == null) {
            return;
        }
        list.remove(zeusPluginStateListener);
    }

    public static Plugin getPlugin(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, str, z)) == null) {
            if (!hasInit() && com.bytedance.pangle.util.b.a()) {
                throw new RuntimeException("Please init Zeus first!");
            }
            return PluginManager.getInstance().getPlugin(str, z);
        }
        return (Plugin) invokeLZ.objValue;
    }
}
