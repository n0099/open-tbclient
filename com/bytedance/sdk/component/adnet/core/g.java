package com.bytedance.sdk.component.adnet.core;

import android.os.Handler;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class g implements com.bytedance.sdk.component.adnet.face.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f64141a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f64142b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.adnet.c.c f64143c;

    /* loaded from: classes9.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Request f64146a;

        /* renamed from: b  reason: collision with root package name */
        public final m f64147b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f64148c;

        public a(Request request, m mVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {request, mVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64146a = request;
            this.f64147b = mVar;
            this.f64148c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f64146a.isCanceled()) {
                    this.f64146a.a("canceled-at-delivery");
                    return;
                }
                this.f64147b.f64178g = this.f64146a.getExtra();
                this.f64147b.a(SystemClock.elapsedRealtime() - this.f64146a.getStartTime());
                this.f64147b.b(this.f64146a.getNetDuration());
                try {
                    if (this.f64147b.a()) {
                        this.f64146a.a(this.f64147b);
                    } else {
                        this.f64146a.deliverError(this.f64147b);
                    }
                } catch (Throwable unused) {
                }
                if (this.f64147b.f64175d) {
                    this.f64146a.addMarker("intermediate-response");
                } else {
                    this.f64146a.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
                }
                Runnable runnable = this.f64148c;
                if (runnable != null) {
                    try {
                        runnable.run();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public g(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64141a = new Executor(this, handler) { // from class: com.bytedance.sdk.component.adnet.core.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Handler f64144a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f64145b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, handler};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f64145b = this;
                this.f64144a = handler;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                    this.f64144a.post(runnable);
                }
            }
        };
        this.f64142b = Executors.newCachedThreadPool();
        this.f64143c = com.bytedance.sdk.component.adnet.c.f.a();
    }

    private Executor a(Request<?> request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, request)) == null) ? (request == null || request.isResponseOnMain()) ? this.f64141a : this.f64142b : (Executor) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.face.c
    public void a(Request<?> request, m<?> mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, request, mVar) == null) {
            a(request, mVar, null);
            com.bytedance.sdk.component.adnet.c.c cVar = this.f64143c;
            if (cVar != null) {
                cVar.a(request, mVar);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.face.c
    public void a(Request<?> request, m<?> mVar, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, mVar, runnable) == null) {
            request.markDelivered();
            request.addMarker("post-response");
            a(request).execute(new a(request, mVar, runnable));
            com.bytedance.sdk.component.adnet.c.c cVar = this.f64143c;
            if (cVar != null) {
                cVar.a(request, mVar);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.face.c
    public void a(Request<?> request, VAdError vAdError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, request, vAdError) == null) {
            request.addMarker("post-error");
            a(request).execute(new a(request, m.a(vAdError), null));
            com.bytedance.sdk.component.adnet.c.c cVar = this.f64143c;
            if (cVar != null) {
                cVar.a(request, vAdError);
            }
        }
    }
}
