package com.baidu.wallet.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class ActLifecycleCbs implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f60691a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f60692b = "#invoke_config_impact_js_result";

    /* renamed from: c  reason: collision with root package name */
    public static int f60693c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60694d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<b> f60695e;

    /* renamed from: f  reason: collision with root package name */
    public HandlerThread f60696f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f60697g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f60698h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class FROM {
        public static final /* synthetic */ FROM[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FROM POLL;
        public static final FROM RESUME;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(282086657, "Lcom/baidu/wallet/core/ActLifecycleCbs$FROM;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(282086657, "Lcom/baidu/wallet/core/ActLifecycleCbs$FROM;");
                    return;
                }
            }
            RESUME = new FROM("RESUME", 0);
            FROM from = new FROM("POLL", 1);
            POLL = from;
            $VALUES = new FROM[]{RESUME, from};
        }

        public FROM(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FROM valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FROM) Enum.valueOf(FROM.class, str) : (FROM) invokeL.objValue;
        }

        public static FROM[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FROM[]) $VALUES.clone() : (FROM[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface a {
        boolean onInvoke(Context context, FROM from);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f60702a;

        /* renamed from: b  reason: collision with root package name */
        public long f60703b;

        /* renamed from: c  reason: collision with root package name */
        public long f60704c;

        public b(a aVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60702a = aVar;
            this.f60703b = j2;
            this.f60704c = System.currentTimeMillis();
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final ActLifecycleCbs f60705a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(315454216, "Lcom/baidu/wallet/core/ActLifecycleCbs$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(315454216, "Lcom/baidu/wallet/core/ActLifecycleCbs$c;");
                    return;
                }
            }
            f60705a = new ActLifecycleCbs();
        }

        public c() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(362339047, "Lcom/baidu/wallet/core/ActLifecycleCbs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(362339047, "Lcom/baidu/wallet/core/ActLifecycleCbs;");
                return;
            }
        }
        f60691a = ActLifecycleCbs.class.getName();
        f60693c = 30000;
    }

    public ActLifecycleCbs() {
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
        this.f60694d = false;
        this.f60695e = new ArrayList<>();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            Handler handler = this.f60697g;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f60698h = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            LogUtil.d("poll", "onActivityPaused activity = " + activity.getLocalClassName());
            b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            LogUtil.d("poll", "onActivityResumed activity = " + activity.getLocalClassName());
            a(activity, FROM.RESUME);
            a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            LogUtil.d("poll", "onActivityStopped activity = " + activity.getLocalClassName());
            com.baidu.wallet.core.a.a();
        }
    }

    public static ActLifecycleCbs a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f60705a : (ActLifecycleCbs) invokeV.objValue;
    }

    public void a(Application application) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, application) == null) || this.f60694d || application == null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("poll");
        this.f60696f = handlerThread;
        handlerThread.start();
        try {
            this.f60697g = new Handler(this.f60696f.getLooper());
            com.baidu.wallet.core.a.a(application);
            LocalRouter.getInstance(application).route(application, new RouterRequest().provider("langbrige").action("langbrige_getToImapctJsFiles").data("configs", new String[]{"config.json"}).data(SavedStateHandle.KEYS, new String[]{"common", "multi-webview"}), new RouterCallback(this) { // from class: com.baidu.wallet.core.ActLifecycleCbs.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ActLifecycleCbs f60699a;

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
                    this.f60699a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        LogUtil.d("jsHook", "routercb resultCode = " + i2);
                    }
                }
            });
            application.registerActivityLifecycleCallbacks(this);
            this.f60694d = true;
        } catch (Exception e2) {
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.POLL_INIT_EXCEPTION, Arrays.asList(e2.getMessage()));
        }
    }

    public void a(a aVar, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, j2) == null) && this.f60694d && aVar != null) {
            for (int i2 = 0; i2 < this.f60695e.size(); i2++) {
                b bVar = this.f60695e.get(i2);
                if (bVar != null && aVar == bVar.f60702a) {
                    bVar.f60703b = j2;
                    return;
                }
            }
            this.f60695e.add(new b(aVar, j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, FROM from) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, from) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f60695e != null) {
                for (int i2 = 0; i2 < this.f60695e.size(); i2++) {
                    b bVar = this.f60695e.get(i2);
                    if (bVar != null && currentTimeMillis - bVar.f60704c >= bVar.f60703b && bVar.f60702a.onInvoke(context, from)) {
                        bVar.f60704c = currentTimeMillis;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, activity) == null) {
            WeakReference weakReference = new WeakReference(activity);
            if (this.f60698h == null) {
                this.f60698h = new Runnable(this, weakReference) { // from class: com.baidu.wallet.core.ActLifecycleCbs.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ WeakReference f60700a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ActLifecycleCbs f60701b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, weakReference};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60701b = this;
                        this.f60700a = weakReference;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Activity activity2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (activity2 = (Activity) this.f60700a.get()) == null) {
                            return;
                        }
                        LogUtil.d("poll", "任务轮询30s一次");
                        this.f60701b.a(activity2, FROM.POLL);
                        this.f60701b.a(activity2);
                    }
                };
            }
            Handler handler = this.f60697g;
            if (handler != null) {
                handler.postDelayed(this.f60698h, f60693c);
            }
        }
    }
}
