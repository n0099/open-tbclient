package com.baidu.tieba;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class sx2 implements ux2, co2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;
    public CopyOnWriteArrayList<c> d;
    public CountDownTimer e;

    /* loaded from: classes5.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sx2 sx2Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx2Var, Long.valueOf(j), Long.valueOf(j2)};
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
            this.a = sx2Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (co2.a) {
                    Log.d("SwanPerformance", "count down onFinish");
                }
                this.a.d(true);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Iterator it = this.a.d.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    boolean z = ((long) (5000 - cVar.e())) >= j;
                    if (!cVar.g() && z) {
                        cVar.h(true);
                        ux2 f = cVar.f();
                        if (co2.a) {
                            Log.e("SwanPerformance", "triggerFmp, timeout = " + cVar.e() + ", trigger = " + f.getName());
                        }
                        f.d(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final sx2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-417545986, "Lcom/baidu/tieba/sx2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-417545986, "Lcom/baidu/tieba/sx2$b;");
                    return;
                }
            }
            a = new sx2(null);
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ux2 a;
        public int b;
        public boolean c;

        public /* synthetic */ c(sx2 sx2Var, ux2 ux2Var, int i, a aVar) {
            this(sx2Var, ux2Var, i);
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
        }

        @NonNull
        public final ux2 f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ux2) invokeV.objValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : invokeV.booleanValue;
        }

        public final void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.c = z;
            }
        }

        public c(@NonNull sx2 sx2Var, ux2 ux2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx2Var, ux2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = false;
            this.a = ux2Var;
            this.b = i;
        }
    }

    public /* synthetic */ sx2(a aVar) {
        this();
    }

    public static sx2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (sx2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ux2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (co2.a) {
                Log.e("SwanPerformance", "triggerFcp, url = " + str);
            }
            Iterator<c> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().f().a(str);
            }
        }
    }

    @Override // com.baidu.tieba.ux2
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.d.isEmpty()) {
            return;
        }
        if (co2.a) {
            Log.e("SwanPerformance", "triggerDestroy");
        }
        k();
        Iterator<c> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().f().b();
        }
        this.c = false;
    }

    @Override // com.baidu.tieba.ux2
    public void c(@NonNull Runnable runnable, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ux2
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.c) {
            return;
        }
        this.c = true;
        k();
        if (this.d.isEmpty()) {
            return;
        }
        if (co2.a) {
            Log.e("SwanPerformance", "triggerFmp, timeout = " + z);
        }
        Iterator<c> it = this.d.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!next.g()) {
                next.h(true);
                next.f().d(z);
            }
        }
        r93.p();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_timeout", z);
        bundle.putString("app_id", x23.K().getAppId());
        oz2 e = oz2.e();
        qz2 qz2Var = new qz2(23, bundle);
        qz2Var.f(true);
        e.h(qz2Var);
    }

    @Override // com.baidu.tieba.ux2
    @UiThread
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (zw2.k()) {
                r93.a0(zw2.j());
            }
            this.c = false;
            if (this.d.isEmpty()) {
                return;
            }
            if (co2.a) {
                Log.e("SwanPerformance", "triggerLaunch, source = " + str);
            }
            Iterator<c> it = this.d.iterator();
            while (it.hasNext()) {
                c next = it.next();
                next.h(false);
                next.f().e(str);
            }
            k();
            j();
        }
    }

    @Override // com.baidu.tieba.ux2
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanLaunchTriggerMgr" : (String) invokeV.objValue;
    }

    public boolean h(ux2 ux2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ux2Var)) == null) {
            if (ux2Var == null) {
                return false;
            }
            Iterator<c> it = this.d.iterator();
            while (it.hasNext()) {
                if (ux2Var.equals(it.next().f())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(ux2 ux2Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, ux2Var, i) == null) || this.c || ux2Var == null) {
            return;
        }
        if (i > 5000) {
            i = 5000;
        }
        if (h(ux2Var)) {
            return;
        }
        this.d.add(new c(this, ux2Var, i, null));
        if (co2.a) {
            Log.e("SwanPerformance", "register, task name = " + ux2Var.getName() + " ; timeout = " + i);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.e.start();
            } catch (Throwable th) {
                if (co2.a) {
                    Log.d("SwanPerformance", "start timer exception = " + th.getMessage());
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.e.cancel();
            } catch (Throwable th) {
                if (co2.a) {
                    Log.d("SwanPerformance", "stop timer exception = " + th.getMessage());
                }
            }
        }
    }

    public sx2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = new CopyOnWriteArrayList<>();
        this.e = new a(this, 5000L, 500L);
    }
}
