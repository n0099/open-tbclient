package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.cpu.booster.utils.CpuType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public class rv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rv3 d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<sv3> a;
    public boolean b;
    public Timer c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948135034, "Lcom/baidu/tieba/rv3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948135034, "Lcom/baidu/tieba/rv3;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv3 a;

        public a(rv3 rv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rv3Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-447992388, "Lcom/baidu/tieba/rv3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-447992388, "Lcom/baidu/tieba/rv3$b;");
                    return;
                }
            }
            int[] iArr = new int[CpuType.values().length];
            a = iArr;
            try {
                iArr[CpuType.Mtk.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CpuType.QualComm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CpuType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public rv3(Context context) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        if (e) {
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        a(context.getApplicationContext());
        if (e) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("CPU-Booster", "collect booster cost - " + (currentTimeMillis - j) + "ms");
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            e = z;
        }
    }

    public static rv3 d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (d == null) {
                synchronized (rv3.class) {
                    if (d == null) {
                        d = new rv3(context);
                    }
                }
            }
            return d;
        }
        return (rv3) invokeL.objValue;
    }

    public static void e(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (e) {
                Log.d("CPU-Booster", "cpu-booster preInit");
            }
            d(context);
        }
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0) {
                return 200;
            }
            return Math.min(i, 5000);
        }
        return invokeI.intValue;
    }

    public final void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (gw3.a()) {
                this.a.add(new tv3(context));
                this.a.add(new vv3(context));
            } else if (gw3.b()) {
                this.a.add(new bw3(context));
            }
            int i = b.a[fw3.h().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.a.add(new dw3(context));
                    return;
                }
                return;
            }
            this.a.add(new zv3(context));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !e) {
            return;
        }
        int e2 = fw3.e();
        StringBuilder sb = new StringBuilder(" \n\n");
        sb.append("CPU Support Freq Info:\n");
        for (int i = 0; i < e2; i++) {
            xv3 a2 = fw3.a(i);
            sb.append("CPU");
            sb.append(a2.a);
            sb.append(":");
            sb.append("min-");
            sb.append(a2.b / 1000);
            sb.append("mHz, max-");
            sb.append(a2.c / 1000);
            sb.append("mHz\n");
        }
        sb.append("\n\n");
        sb.append("CPU Current Freq:\n");
        for (int i2 = 0; i2 < e2; i2++) {
            sb.append("CPU");
            sb.append(i2);
            sb.append(":");
            sb.append(fw3.j(i2) / 1000);
            sb.append("mHz");
            sb.append("\n");
        }
        if (e) {
            Log.d("CPU-Booster", sb.toString());
        }
    }

    public synchronized void i() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!this.b) {
                    return;
                }
                if (e) {
                    Log.d("CPU-Booster", "stopBooster");
                }
                if (e) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                for (sv3 sv3Var : this.a) {
                    sv3Var.a();
                }
                this.b = false;
                if (this.c != null) {
                    this.c.cancel();
                    this.c = null;
                }
                if (e) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("CPU-Booster", "stop booster cost - " + (currentTimeMillis - j) + "ms");
                }
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                h(3000);
            }
        }
    }

    public synchronized void h(int i) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            synchronized (this) {
                if (this.b) {
                    if (e) {
                        Log.d("CPU-Booster", "start fail -> isEnabled - true, already start - " + this.b);
                    }
                    return;
                }
                if (e) {
                    Log.d("CPU-Booster", "startBooster");
                }
                this.b = true;
                int c = c(i);
                if (e) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                for (sv3 sv3Var : this.a) {
                    sv3Var.b(c);
                }
                if (this.c == null) {
                    Timer timer = new Timer();
                    this.c = timer;
                    timer.schedule(new a(this), c);
                }
                if (e) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("CPU-Booster", "start booster cost - " + (currentTimeMillis - j) + "ms");
                    f();
                }
            }
        }
    }
}
