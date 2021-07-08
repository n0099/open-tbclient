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
    public final Executor f28001a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f28002b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.adnet.c.c f28003c;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Request f28006a;

        /* renamed from: b  reason: collision with root package name */
        public final m f28007b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f28008c;

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
            this.f28006a = request;
            this.f28007b = mVar;
            this.f28008c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28006a.isCanceled()) {
                    this.f28006a.a("canceled-at-delivery");
                    return;
                }
                this.f28007b.f28037g = this.f28006a.getExtra();
                this.f28007b.a(SystemClock.elapsedRealtime() - this.f28006a.getStartTime());
                this.f28007b.b(this.f28006a.getNetDuration());
                try {
                    if (this.f28007b.a()) {
                        this.f28006a.a(this.f28007b);
                    } else {
                        this.f28006a.deliverError(this.f28007b);
                    }
                } catch (Throwable unused) {
                }
                if (this.f28007b.f28034d) {
                    this.f28006a.addMarker("intermediate-response");
                } else {
                    this.f28006a.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
                }
                Runnable runnable = this.f28008c;
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
        this.f28001a = new Executor(this, handler) { // from class: com.bytedance.sdk.component.adnet.core.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Handler f28004a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f28005b;

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
                this.f28005b = this;
                this.f28004a = handler;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                    this.f28004a.post(runnable);
                }
            }
        };
        this.f28002b = Executors.newCachedThreadPool();
        this.f28003c = com.bytedance.sdk.component.adnet.c.f.a();
    }

    private Executor a(Request<?> request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, request)) == null) ? (request == null || request.isResponseOnMain()) ? this.f28001a : this.f28002b : (Executor) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.face.c
    public void a(Request<?> request, m<?> mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, request, mVar) == null) {
            a(request, mVar, null);
            com.bytedance.sdk.component.adnet.c.c cVar = this.f28003c;
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
            com.bytedance.sdk.component.adnet.c.c cVar = this.f28003c;
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
            com.bytedance.sdk.component.adnet.c.c cVar = this.f28003c;
            if (cVar != null) {
                cVar.a(request, vAdError);
            }
        }
    }
}
