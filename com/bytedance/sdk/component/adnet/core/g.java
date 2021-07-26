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
/* loaded from: classes5.dex */
public class g implements com.bytedance.sdk.component.adnet.face.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f28099a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f28100b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.adnet.c.c f28101c;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Request f28104a;

        /* renamed from: b  reason: collision with root package name */
        public final m f28105b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f28106c;

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
            this.f28104a = request;
            this.f28105b = mVar;
            this.f28106c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28104a.isCanceled()) {
                    this.f28104a.a("canceled-at-delivery");
                    return;
                }
                this.f28105b.f28135g = this.f28104a.getExtra();
                this.f28105b.a(SystemClock.elapsedRealtime() - this.f28104a.getStartTime());
                this.f28105b.b(this.f28104a.getNetDuration());
                try {
                    if (this.f28105b.a()) {
                        this.f28104a.a(this.f28105b);
                    } else {
                        this.f28104a.deliverError(this.f28105b);
                    }
                } catch (Throwable unused) {
                }
                if (this.f28105b.f28132d) {
                    this.f28104a.addMarker("intermediate-response");
                } else {
                    this.f28104a.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
                }
                Runnable runnable = this.f28106c;
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
        this.f28099a = new Executor(this, handler) { // from class: com.bytedance.sdk.component.adnet.core.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Handler f28102a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f28103b;

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
                this.f28103b = this;
                this.f28102a = handler;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                    this.f28102a.post(runnable);
                }
            }
        };
        this.f28100b = Executors.newCachedThreadPool();
        this.f28101c = com.bytedance.sdk.component.adnet.c.f.a();
    }

    private Executor a(Request<?> request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, request)) == null) ? (request == null || request.isResponseOnMain()) ? this.f28099a : this.f28100b : (Executor) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.face.c
    public void a(Request<?> request, m<?> mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, request, mVar) == null) {
            a(request, mVar, null);
            com.bytedance.sdk.component.adnet.c.c cVar = this.f28101c;
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
            com.bytedance.sdk.component.adnet.c.c cVar = this.f28101c;
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
            com.bytedance.sdk.component.adnet.c.c cVar = this.f28101c;
            if (cVar != null) {
                cVar.a(request, vAdError);
            }
        }
    }
}
