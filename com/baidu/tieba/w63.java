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
/* loaded from: classes8.dex */
public class w63 implements y63, gx2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;
    public CopyOnWriteArrayList<c> d;
    public CountDownTimer e;

    @Override // com.baidu.tieba.y63
    public void c(@NonNull Runnable runnable, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
        }
    }

    @Override // com.baidu.tieba.y63
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanLaunchTriggerMgr" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w63 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w63 w63Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w63Var, Long.valueOf(j), Long.valueOf(j2)};
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
            this.a = w63Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (gx2.a) {
                    Log.d("SwanPerformance", "count down onFinish");
                }
                this.a.d(true);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Iterator it = this.a.d.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (5000 - cVar.e() >= j) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!cVar.g() && z) {
                        cVar.h(true);
                        y63 f = cVar.f();
                        if (gx2.a) {
                            Log.e("SwanPerformance", "triggerFmp, timeout = " + cVar.e() + ", trigger = " + f.getName());
                        }
                        f.d(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final w63 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-363951977, "Lcom/baidu/tieba/w63$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-363951977, "Lcom/baidu/tieba/w63$b;");
                    return;
                }
            }
            a = new w63(null);
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public y63 a;
        public int b;
        public boolean c;

        public c(@NonNull w63 w63Var, y63 y63Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w63Var, y63Var, Integer.valueOf(i)};
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
            this.a = y63Var;
            this.b = i;
        }

        public /* synthetic */ c(w63 w63Var, y63 y63Var, int i, a aVar) {
            this(w63Var, y63Var, i);
        }

        public final void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.c = z;
            }
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        @NonNull
        public final y63 f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (y63) invokeV.objValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.booleanValue;
        }
    }

    public w63() {
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

    @Override // com.baidu.tieba.y63
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.d.isEmpty()) {
            return;
        }
        if (gx2.a) {
            Log.e("SwanPerformance", "triggerDestroy");
        }
        k();
        Iterator<c> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().f().b();
        }
        this.c = false;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.e.start();
            } catch (Throwable th) {
                if (gx2.a) {
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
                if (gx2.a) {
                    Log.d("SwanPerformance", "stop timer exception = " + th.getMessage());
                }
            }
        }
    }

    public /* synthetic */ w63(a aVar) {
        this();
    }

    public static w63 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (w63) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y63
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (gx2.a) {
                Log.e("SwanPerformance", "triggerFcp, url = " + str);
            }
            Iterator<c> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().f().a(str);
            }
        }
    }

    public boolean h(y63 y63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, y63Var)) == null) {
            if (y63Var == null) {
                return false;
            }
            Iterator<c> it = this.d.iterator();
            while (it.hasNext()) {
                if (y63Var.equals(it.next().f())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.y63
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048579, this, z) != null) || this.c) {
            return;
        }
        this.c = true;
        k();
        if (this.d.isEmpty()) {
            return;
        }
        if (gx2.a) {
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
        vi3.p();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_timeout", z);
        bundle.putString("app_id", bc3.K().getAppId());
        s83 e = s83.e();
        u83 u83Var = new u83(23, bundle);
        u83Var.f(true);
        e.h(u83Var);
    }

    @Override // com.baidu.tieba.y63
    @UiThread
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (d63.k()) {
                vi3.a0(d63.j());
            }
            this.c = false;
            if (this.d.isEmpty()) {
                return;
            }
            if (gx2.a) {
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

    public void i(y63 y63Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048583, this, y63Var, i) != null) || this.c || y63Var == null) {
            return;
        }
        if (i > 5000) {
            i = 5000;
        }
        if (!h(y63Var)) {
            this.d.add(new c(this, y63Var, i, null));
            if (gx2.a) {
                Log.e("SwanPerformance", "register, task name = " + y63Var.getName() + " ; timeout = " + i);
            }
        }
    }
}
