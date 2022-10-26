package com.baidu.tieba;

import android.os.CountDownTimer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class vl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CountDownTimer a;
    public long b;
    public long c;
    public WeakReference d;

    /* loaded from: classes6.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vl0 vl0Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl0Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference(vl0Var);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            vl0 vl0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (vl0Var = (vl0) this.a.get()) != null) {
                vl0Var.f(vl0Var.j());
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            vl0 vl0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && (vl0Var = (vl0) this.a.get()) != null) {
                vl0Var.c = vl0Var.b - j;
                vl0Var.g(vl0Var.e(), vl0Var.j());
            }
        }
    }

    public vl0(xl0 xl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xl0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new WeakReference(xl0Var);
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            i();
            this.b = j;
            this.c = 0L;
            a aVar = new a(this, this.b, 1000L);
            this.a = aVar;
            aVar.start();
            xl0 k = k();
            if (k != null) {
                long j2 = this.b;
                k.b(j2, j2);
            }
        }
    }

    public final void g(long j, long j2) {
        xl0 k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && (k = k()) != null) {
            k.onProgress(j, j2);
        }
    }

    public final void f(long j) {
        xl0 k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && (k = k()) != null) {
            k.a(j);
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public void i() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (countDownTimer = this.a) == null) {
            return;
        }
        countDownTimer.cancel();
        xl0 k = k();
        if (k != null) {
            k.c(this.c, this.b);
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public final xl0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (xl0) this.d.get();
        }
        return (xl0) invokeV.objValue;
    }
}
