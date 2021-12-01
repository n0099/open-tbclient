package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTInitializer;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import dalvik.system.DexClassLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class g implements TTInitializer {
    public static /* synthetic */ Interceptable $ic;
    public static ScheduledExecutorService a;

    /* renamed from: c  reason: collision with root package name */
    public static final Bundle f54764c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile TTInitializer f54765b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1462304230, "Lcom/bytedance/sdk/openadsdk/api/plugin/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1462304230, "Lcom/bytedance/sdk/openadsdk/api/plugin/g;");
                return;
            }
        }
        f54764c = new Bundle();
        a = Executors.newSingleThreadScheduledExecutor(new a());
    }

    public g() {
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

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager getAdManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.bytedance.sdk.openadsdk.api.plugin.a.a : (TTAdManager) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, adConfig, initCallback) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                initCallback.fail(4201, "Only support >= 5.0");
                return;
            }
            f.a(context);
            if (this.f54765b != null) {
                this.f54765b.init(context, adConfig, initCallback);
            } else {
                a(context, adConfig, initCallback);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public boolean isInitSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f54765b != null) {
                return this.f54765b.isInitSuccess();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void a(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, bundle) == null) || TextUtils.isEmpty(str) || bundle == null) {
            return;
        }
        f54764c.putBundle(str, bundle);
    }

    /* loaded from: classes12.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ThreadGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f54769b;

        /* renamed from: c  reason: collision with root package name */
        public final String f54770c;

        public a() {
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
            this.f54769b = new AtomicInteger(1);
            this.a = new ThreadGroup("tt_pangle_group_pl_init");
            this.f54770c = "tt_pangle_thread_pl_init";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                ThreadGroup threadGroup = this.a;
                Thread thread = new Thread(threadGroup, runnable, this.f54770c + this.f54769b.getAndIncrement(), 0L);
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                if (thread.getPriority() != 10) {
                    thread.setPriority(10);
                }
                return thread;
            }
            return (Thread) invokeL.objValue;
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f54769b = new AtomicInteger(1);
            this.a = new ThreadGroup("tt_pangle_group_pl_init");
            this.f54770c = str;
        }
    }

    public void a(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, adConfig, initCallback) == null) {
            a.execute(new Runnable(this, context, adConfig, initCallback) { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdConfig f54766b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ TTAdSdk.InitCallback f54767c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ g f54768d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, adConfig, initCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54768d = this;
                    this.a = context;
                    this.f54766b = adConfig;
                    this.f54767c = initCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TTInitializer a2 = this.f54768d.a(this.a, this.f54766b);
                        if (a2 != null) {
                            a2.init(this.a, this.f54766b, this.f54767c);
                            com.bytedance.sdk.openadsdk.api.plugin.a.a.a(this.f54768d.f54765b.getAdManager());
                            e.a();
                            return;
                        }
                        this.f54767c.fail(4201, "No initializer");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTInitializer a(Context context, AdConfig adConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, adConfig)) == null) {
            if (this.f54765b == null) {
                synchronized (this) {
                    if (this.f54765b == null) {
                        e.a(adConfig);
                        com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Create initializer");
                        long currentTimeMillis = System.currentTimeMillis();
                        this.f54765b = a(context);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("duration", Long.valueOf(currentTimeMillis2));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        adConfig.setExtra("plugin", jSONObject);
                    }
                }
            }
            return this.f54765b;
        }
        return (TTInitializer) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager init(Context context, AdConfig adConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, adConfig)) == null) {
            throw new RuntimeException("Please use init(Context context, AdConfig config, TTAdSdk.InitCallback callback)!");
        }
        return (TTAdManager) invokeLL.objValue;
    }

    public static TTInitializer a(Context context) {
        InterceptResult invokeL;
        DexClassLoader a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                a2 = f.a(context).a();
            } catch (Throwable th) {
                e.a(6, th.getMessage(), 0L);
                com.bytedance.sdk.openadsdk.api.b.d.d("TTPluginManager", "Create initializer failed: " + th);
            }
            if (a2 == null) {
                e.a(6, "Load plugin failed", 0L);
                com.bytedance.sdk.openadsdk.api.b.d.d("TTPluginManager", "Load plugin failed");
                return null;
            }
            Class<?> loadClass = a2.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_LISTENER, new f.b());
            bundle.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, f54764c);
            TTInitializer tTInitializer = (TTInitializer) loadClass.getDeclaredMethod("getInstance", Bundle.class).invoke(null, bundle);
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Create initializer success");
            return tTInitializer;
        }
        return (TTInitializer) invokeL.objValue;
    }
}
