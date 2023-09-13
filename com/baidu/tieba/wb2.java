package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class wb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final sb2 a;
    public boolean b;
    public boolean c;
    public jc2 d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final wb2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-323346844, "Lcom/baidu/tieba/wb2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-323346844, "Lcom/baidu/tieba/wb2$b;");
                    return;
                }
            }
            a = new wb2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948264738, "Lcom/baidu/tieba/wb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948264738, "Lcom/baidu/tieba/wb2;");
                return;
            }
        }
        e = rr1.a;
    }

    public static wb2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (wb2) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = false;
        }
    }

    public wb2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        tb2 tb2Var = new tb2();
        this.a = tb2Var;
        tb2Var.a(new vb2(this.a.getLooper()));
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (e) {
                h82.i("WhitePageMonitor", Log.getStackTraceString(new Throwable(">>> check skeleton_dev, callback = " + this.d)));
            }
            jc2 jc2Var = this.d;
            if (jc2Var != null) {
                jc2Var.a();
                this.d = null;
            }
        }
    }

    public /* synthetic */ wb2(a aVar) {
        this();
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            i(j);
            j(false);
        }
    }

    public void g(jc2 jc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jc2Var) == null) {
            this.d = jc2Var;
        }
    }

    public void h(rb2 rb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rb2Var) == null) {
            this.a.b(rb2Var);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c = z;
        }
    }

    public void i(long j) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            if (e) {
                Log.d("WhitePageMonitor", ">> update first white screen timestamp, delay " + j + " ms");
            }
            if (j < 3000 && j > 0) {
                z = true;
            } else {
                z = false;
            }
            this.b = z;
        }
    }
}
