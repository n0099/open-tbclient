package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public b h;
    public Runnable i;

    /* loaded from: classes8.dex */
    public interface b {
        void onCountDown(long j, long j2);

        void onCountDownFinish(long j);
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw5 a;

        public a(uw5 uw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uw5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.a.g > this.a.f) {
                    uw5 uw5Var = this.a;
                    uw5Var.f = currentTimeMillis - uw5Var.d;
                    uw5 uw5Var2 = this.a;
                    uw5Var2.g = uw5Var2.f;
                }
                long j = currentTimeMillis - this.a.f;
                uw5 uw5Var3 = this.a;
                uw5.h(uw5Var3, uw5Var3.d);
                if (this.a.c >= this.a.b) {
                    uw5 uw5Var4 = this.a;
                    uw5Var4.c = uw5Var4.b;
                    this.a.n();
                } else {
                    this.a.a.postDelayed(this.a.i, (this.a.d * 2) - j);
                    if (this.a.h != null) {
                        this.a.h.onCountDown(this.a.b, this.a.b - this.a.c);
                    }
                }
                this.a.f = currentTimeMillis;
            }
        }
    }

    public uw5(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.i = new a(this);
        this.b = j;
        this.d = j2;
    }

    public void o(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.h = bVar;
        }
    }

    public static /* synthetic */ long h(uw5 uw5Var, long j) {
        long j2 = uw5Var.c + j;
        uw5Var.c = j2;
        return j2;
    }

    public final void n() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = this.h) != null) {
            bVar.onCountDownFinish(this.b);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e = currentTimeMillis;
            this.f = currentTimeMillis;
            b bVar = this.h;
            if (bVar != null) {
                long j = this.b;
                bVar.onCountDown(j, j - this.c);
            }
            this.a.postDelayed(this.i, this.d);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long j = this.e;
            this.f = j;
            this.g = j;
            this.a.removeCallbacks(this.i);
        }
    }
}
