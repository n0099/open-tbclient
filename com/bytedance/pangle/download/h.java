package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.plugin.PluginProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final ExecutorService f55125e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile h f55126f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long a;

    /* renamed from: b  reason: collision with root package name */
    public List<PluginDownloadBean> f55127b;

    /* renamed from: c  reason: collision with root package name */
    public List<PluginDownloadBean> f55128c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55129d;

    /* renamed from: g  reason: collision with root package name */
    public List<PluginDownloadBean> f55130g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Long> f55131h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f55132i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f55133j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1012230900, "Lcom/bytedance/pangle/download/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1012230900, "Lcom/bytedance/pangle/download/h;");
                return;
            }
        }
        f55125e = Executors.newSingleThreadExecutor();
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55130g = new CopyOnWriteArrayList();
        this.f55127b = new CopyOnWriteArrayList();
        this.f55131h = new ConcurrentHashMap();
        this.f55128c = new CopyOnWriteArrayList();
        this.f55132i = new Handler(Looper.getMainLooper());
        this.f55133j = null;
        this.f55129d = false;
    }

    public static void c(PluginDownloadBean pluginDownloadBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, pluginDownloadBean) == null) {
            Zeus.unInstallPlugin(pluginDownloadBean.mPackageName);
        }
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f55126f == null) {
                synchronized (h.class) {
                    if (f55126f == null) {
                        f55126f = new h();
                    }
                }
            }
            return f55126f;
        }
        return (h) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "asyncFetchPlugins start");
            f55125e.execute(new c(this));
        }
    }

    public static boolean b(PluginDownloadBean pluginDownloadBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, pluginDownloadBean)) == null) {
            Plugin plugin2 = Zeus.getPlugin(pluginDownloadBean.mPackageName);
            if ((plugin2 != null && plugin2.isVersionInstalled(pluginDownloadBean.mVersionCode)) && PluginDirHelper.isPackageVersionDirExists(pluginDownloadBean.mPackageName, pluginDownloadBean.mVersionCode)) {
                ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "interceptPluginDownload, packageName:" + pluginDownloadBean.mPackageName + " downloadVersionCode:" + pluginDownloadBean.mVersionCode);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private synchronized List<PluginDownloadBean> b(List<PluginDownloadBean> list) {
        InterceptResult invokeL;
        List<PluginDownloadBean> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, list)) == null) {
            synchronized (this) {
                this.f55130g.clear();
                this.f55127b.clear();
                this.f55128c.clear();
                for (PluginDownloadBean pluginDownloadBean : list) {
                    if (pluginDownloadBean.mDownloadType == 0) {
                        this.f55127b.add(pluginDownloadBean);
                    } else if (pluginDownloadBean.mDownloadType == 1) {
                        this.f55128c.add(pluginDownloadBean);
                    }
                }
                this.f55129d = true;
                list2 = this.f55127b;
            }
            return list2;
        }
        return (List) invokeL.objValue;
    }

    public final List<PluginDownloadBean> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        PluginDownloadBean a = e.a(jSONObject);
                        if (a(a)) {
                            arrayList.add(a);
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return b(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static boolean a(PluginDownloadBean pluginDownloadBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, pluginDownloadBean)) == null) {
            if (pluginDownloadBean == null) {
                return false;
            }
            if (pluginDownloadBean.isOffline) {
                c(pluginDownloadBean);
                Zeus.markOfflineFlag(pluginDownloadBean.mPackageName);
                return false;
            }
            if (Zeus.hasOfflineFlag(pluginDownloadBean.mPackageName)) {
                Zeus.clearOfflineFlag(pluginDownloadBean.mPackageName);
            }
            if (pluginDownloadBean.isRevert) {
                if (pluginDownloadBean.mVersionCode < Zeus.getInstalledPluginVersion(pluginDownloadBean.mPackageName)) {
                    Zeus.unInstallPlugin(pluginDownloadBean.mPackageName);
                }
                return pluginDownloadBean.mVersionCode != 0;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void a(List<PluginDownloadBean> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, list) == null) {
            for (PluginDownloadBean pluginDownloadBean : list) {
                if (pluginDownloadBean.mDownloadType == 0) {
                    a(pluginDownloadBean, null);
                }
            }
        }
    }

    public static void a(PluginDownloadBean pluginDownloadBean, ZeusPluginListener zeusPluginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, pluginDownloadBean, zeusPluginListener) == null) {
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
                PluginProvider pluginProvider = com.bytedance.pangle.i.a().f55184b.getPluginProvider();
                if (pluginProvider != null && pluginProvider.useLocalPlugin()) {
                    PluginManager.getInstance().installFromDownloadDir();
                } else {
                    f.a().a(pluginDownloadBean.mUrl, pluginDownloadBean.mPackageName, pluginDownloadBean.mVersionCode, pluginDownloadBean.mMd5, pluginDownloadBean.isWifiOnly, pluginDownloadBean.mBackupUrlList, pluginDownloadBean.mDownloadType, zeusPluginListener);
                }
            } catch (Exception e2) {
                if (zeusPluginListener != null) {
                    zeusPluginListener.onEvent(13, e2.getMessage());
                }
            }
        }
    }

    public final void a(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || j2 < 300) {
            return;
        }
        Runnable runnable = this.f55133j;
        if (runnable != null) {
            this.f55132i.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable(this, j2) { // from class: com.bytedance.pangle.download.h.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f55134b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55134b = this;
                this.a = j2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!b.a().a) {
                        this.f55134b.b();
                    }
                    this.f55134b.f55132i.postDelayed(this, this.a * 1000);
                }
            }
        };
        this.f55133j = runnable2;
        this.f55132i.postDelayed(runnable2, j2 * 1000);
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Plugin plugin2;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                plugin2 = Zeus.getPlugin(str);
            } catch (Exception unused) {
            }
            if (plugin2 == null || plugin2.isLoaded() || (((l = this.f55131h.get(str)) != null && System.currentTimeMillis() - l.longValue() < 5000) || !com.bytedance.pangle.a.a.booleanValue())) {
                return false;
            }
            d a = d.a();
            String a2 = e.a();
            String str2 = null;
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Plugin plugin3 = PluginManager.getInstance().getPlugin(str);
                if (plugin3 != null) {
                    jSONArray.put(e.a(plugin3));
                    jSONObject.put("plugin", jSONArray);
                    jSONObject.put("auto_request", false);
                    str2 = jSONObject.toString();
                }
            }
            String a3 = a.a(a2, str2, AbstractBceClient.DEFAULT_CONTENT_TYPE);
            if (TextUtils.isEmpty(a3)) {
                return false;
            }
            JSONArray optJSONArray = new JSONObject(a3).getJSONObject("data").optJSONArray("plugin");
            this.f55131h.put(str, Long.valueOf(System.currentTimeMillis()));
            if (optJSONArray.length() <= 0) {
                return false;
            }
            PluginDownloadBean a4 = e.a(optJSONArray.getJSONObject(0));
            if (!a4.isOffline && !a4.isRevert) {
                synchronized (this) {
                    if (!a(a4, this.f55127b, false)) {
                        a(a4, this.f55128c, true);
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(PluginDownloadBean pluginDownloadBean, List<PluginDownloadBean> list, boolean z) {
        InterceptResult invokeLLZ;
        PluginDownloadBean pluginDownloadBean2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, pluginDownloadBean, list, z)) == null) {
            Iterator<PluginDownloadBean> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    pluginDownloadBean2 = null;
                    break;
                }
                pluginDownloadBean2 = it.next();
                if (TextUtils.equals(pluginDownloadBean2.mPackageName, pluginDownloadBean.mPackageName)) {
                    break;
                }
            }
            if (pluginDownloadBean2 != null) {
                list.remove(pluginDownloadBean2);
                list.add(pluginDownloadBean);
                return true;
            } else if (z) {
                list.add(pluginDownloadBean);
                return true;
            } else {
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
