package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.plugin.PluginProvider;
import com.yy.hiidostatis.inner.FlushManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final ExecutorService f38088e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile g f38089f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long a;

    /* renamed from: b  reason: collision with root package name */
    public List<PluginDownloadBean> f38090b;

    /* renamed from: c  reason: collision with root package name */
    public List<PluginDownloadBean> f38091c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38092d;

    /* renamed from: g  reason: collision with root package name */
    public List<PluginDownloadBean> f38093g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Long> f38094h;
    public Handler i;
    public Runnable j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1012230931, "Lcom/bytedance/pangle/download/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1012230931, "Lcom/bytedance/pangle/download/g;");
                return;
            }
        }
        f38088e = Executors.newSingleThreadExecutor();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38093g = new CopyOnWriteArrayList();
        this.f38090b = new CopyOnWriteArrayList();
        this.f38094h = new ConcurrentHashMap();
        this.f38091c = new CopyOnWriteArrayList();
        this.i = new Handler(Looper.getMainLooper());
        this.j = null;
        this.f38092d = false;
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f38089f == null) {
                synchronized (g.class) {
                    if (f38089f == null) {
                        f38089f = new g();
                    }
                }
            }
            return f38089f;
        }
        return (g) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "asyncFetchPlugins start");
            f38088e.execute(new c(this));
        }
    }

    public static boolean b(PluginDownloadBean pluginDownloadBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pluginDownloadBean)) == null) {
            Plugin plugin2 = Zeus.getPlugin(pluginDownloadBean.mPackageName);
            if ((plugin2 != null && plugin2.isVersionInstalled(pluginDownloadBean.mVersionCode)) && PluginDirHelper.isPackageVersionDirExists(pluginDownloadBean.mPackageName, pluginDownloadBean.mVersionCode)) {
                ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "interceptPluginDownload, packageName:" + pluginDownloadBean.mPackageName + " downloadVersionCode:" + pluginDownloadBean.mVersionCode);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void a(List<PluginDownloadBean> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, list) == null) {
            for (PluginDownloadBean pluginDownloadBean : list) {
                if (pluginDownloadBean.mDownloadType == 0) {
                    a(pluginDownloadBean, null);
                }
            }
        }
    }

    public static void a(PluginDownloadBean pluginDownloadBean, ZeusPluginListener zeusPluginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pluginDownloadBean, zeusPluginListener) == null) {
            try {
                Plugin plugin2 = Zeus.getPlugin(pluginDownloadBean.mPackageName);
                if (b(pluginDownloadBean)) {
                    if (zeusPluginListener != null) {
                        zeusPluginListener.onEvent(13, "already download");
                        return;
                    }
                    return;
                }
                if (plugin2 != null) {
                    plugin2.setHostCompatVersion(pluginDownloadBean.mVersionCode, pluginDownloadBean.mClientVersionMin, pluginDownloadBean.mClientVersionMax);
                    plugin2.setApiCompatVersion(pluginDownloadBean.mVersionCode, pluginDownloadBean.mApiVersionMin, pluginDownloadBean.mApiVersionMax);
                }
                PluginProvider pluginProvider = com.bytedance.pangle.g.a().f38133b.getPluginProvider();
                if (pluginProvider != null && pluginProvider.useLocalPlugin()) {
                    PluginManager.getInstance().installFromDownloadDir();
                } else {
                    e.a().a(pluginDownloadBean.mUrl, pluginDownloadBean.mPackageName, pluginDownloadBean.mVersionCode, pluginDownloadBean.mMd5, pluginDownloadBean.isWifiOnly, pluginDownloadBean.mBackupUrlList, pluginDownloadBean.mDownloadType, zeusPluginListener);
                }
            } catch (Exception e2) {
                if (zeusPluginListener != null) {
                    zeusPluginListener.onEvent(13, e2.getMessage());
                }
            }
        }
    }

    public static void a(PluginDownloadBean pluginDownloadBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, pluginDownloadBean) == null) {
            Zeus.unInstallPlugin(pluginDownloadBean.mPackageName);
        }
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                Plugin plugin2 = Zeus.getPlugin(str);
                if (plugin2 != null && !plugin2.isLoaded() && (l = this.f38094h.get(str)) != null) {
                    if (System.currentTimeMillis() - l.longValue() < 5000) {
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static /* synthetic */ void a(g gVar) {
        Runnable runnable = gVar.j;
        if (runnable != null) {
            gVar.i.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable(gVar) { // from class: com.bytedance.pangle.download.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f38095b;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38095b = gVar;
                this.a = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!b.a().a) {
                        this.f38095b.b();
                    }
                    this.f38095b.i.postDelayed(this, this.a * 1000);
                }
            }
        };
        gVar.j = runnable2;
        gVar.i.postDelayed(runnable2, FlushManager.ReportTimer.DEFAULT_INTERVAL);
    }
}
