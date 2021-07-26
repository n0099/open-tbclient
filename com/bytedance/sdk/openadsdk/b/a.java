package com.bytedance.sdk.openadsdk.b;

import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.net.executor.PostExecutor;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.k.c;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.k.d;
import com.bytedance.sdk.openadsdk.q.a;
import com.bytedance.sdk.openadsdk.q.q;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements a.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f29359a = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f29360d = "com.bytedance.sdk.openadsdk.b.a";

    /* renamed from: e  reason: collision with root package name */
    public static final HashSet f29361e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<JSONObject> f29362b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.q.a f29363c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(97662428, "Lcom/bytedance/sdk/openadsdk/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(97662428, "Lcom/bytedance/sdk/openadsdk/b/a;");
                return;
            }
        }
        f29361e = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", f29360d));
    }

    public a() {
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
        this.f29362b = new CopyOnWriteArrayList<>();
        com.bytedance.sdk.openadsdk.q.a c2 = h.d().c();
        this.f29363c = c2;
        if (c2 != null) {
            c2.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void c() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (copyOnWriteArrayList = this.f29362b) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.f29362b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f29362b.clear();
        String l = q.l("/api/ad/union/sdk/callstack/batch/");
        k.b("CallChainStatistic", "params:" + jSONObject);
        JSONObject a2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
        PostExecutor postExecutor = d.b().c().getPostExecutor();
        postExecutor.setUrl(l);
        postExecutor.setJson(a2.toString());
        postExecutor.enqueue(new NetCallback(this) { // from class: com.bytedance.sdk.openadsdk.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f29368a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29368a = this;
            }

            @Override // com.bytedance.sdk.component.net.callback.NetCallback
            public void onFailure(NetExecutor netExecutor, IOException iOException) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                    k.c("CallChainStatistic", iOException.getMessage());
                }
            }

            @Override // com.bytedance.sdk.component.net.callback.NetCallback
            public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                    if (netResponse != null) {
                        k.b("CallChainStatistic", Boolean.valueOf(netResponse.isSuccess()), netResponse.getBody());
                    } else {
                        k.c("CallChainStatistic", "NetResponse is null");
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.q.a.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f29359a == null) {
                synchronized (a.class) {
                    if (f29359a == null) {
                        f29359a = new a();
                    }
                }
            }
            return f29359a;
        }
        return (a) invokeV.objValue;
    }

    public void a(int i2, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, adSlot) == null) || adSlot == null) {
            return;
        }
        a(i2, adSlot.getCodeId());
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adSlot) == null) || adSlot == null) {
            return;
        }
        a(adSlot.getNativeAdType(), adSlot.getCodeId());
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && b.a()) {
            e.a(new g(this, "callChainStatistic", i2, str, Thread.currentThread().getStackTrace()) { // from class: com.bytedance.sdk.openadsdk.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f29364a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f29365b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ StackTraceElement[] f29366c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f29367d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, Integer.valueOf(i2), str, r11};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29367d = this;
                    this.f29364a = i2;
                    this.f29365b = str;
                    this.f29366c = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29367d.f29362b.add(this.f29367d.a(this.f29364a, this.f29365b, this.f29366c));
                        if (this.f29367d.f29362b.size() < 3) {
                            return;
                        }
                        this.f29367d.c();
                    }
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public JSONObject a(int i2, String str, StackTraceElement[] stackTraceElementArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(AdIconUtil.AD_TEXT_ID, this, i2, str, stackTraceElementArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("rit", str);
                jSONObject.put("appid", h.d().h());
                jSONObject.put("app_version", q.f());
                jSONObject.put("ad_sdk_version", "3.7.0.3");
                jSONObject.put("adtype", i2);
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("callstack", a(stackTraceElementArr));
                jSONObject.put("type", "callstack");
                jSONObject.put("device_info", c.e(o.a()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeILL.objValue;
    }

    private JSONArray a(StackTraceElement[] stackTraceElementArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, stackTraceElementArr)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (stackTraceElement != null) {
                    if (!f29361e.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                        String className = stackTraceElement.getClassName();
                        if (className != null && className.startsWith("android.app")) {
                            break;
                        }
                        jSONArray.put(stackTraceElement.toString());
                    } else {
                        continue;
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }
}
