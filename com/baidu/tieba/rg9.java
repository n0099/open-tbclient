package com.baidu.tieba;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class rg9 implements lg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Executor a;

    /* loaded from: classes5.dex */
    public class a implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Handler a;

        public a(rg9 rg9Var, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg9Var, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.a.post(runnable);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final kg9 a;
        public final ig9 b;

        public b(kg9 kg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg9Var;
            this.b = kg9Var.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.a.h()) {
                    case 102:
                        xi9.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                        this.b.c();
                        return;
                    case 103:
                        xi9.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.a.e() + " acceptRanges: " + this.a.i());
                        this.b.b(this.a.e(), this.a.i());
                        return;
                    case 104:
                        xi9.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.a.d() + " length: " + this.a.e() + " percent: " + this.a.f());
                        this.b.g(this.a.d(), this.a.e(), this.a.f());
                        return;
                    case 105:
                        xi9.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.a.g());
                        if (!this.a.b()) {
                            this.a.l(true);
                            this.b.a(this.a.g());
                            return;
                        }
                        return;
                    case 106:
                        xi9.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                        this.b.e();
                        return;
                    case 107:
                        xi9.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                        this.b.d();
                        return;
                    case 108:
                        xi9.c(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.a.c().getCause());
                        this.b.f((DownloadException) this.a.c());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public rg9(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this, handler);
    }

    @Override // com.baidu.tieba.lg9
    public void a(kg9 kg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kg9Var) == null) {
            this.a.execute(new b(kg9Var));
        }
    }
}
