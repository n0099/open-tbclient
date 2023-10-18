package com.baidu.tieba;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
/* loaded from: classes7.dex */
public class o2 implements v2 {
    public static /* synthetic */ Interceptable $ic;
    public static final a3<Application, r2<o2>> h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public int d;
    public final String e;
    public final String f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448311402, "Lcom/baidu/tieba/o2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448311402, "Lcom/baidu/tieba/o2;");
                return;
            }
        }
        h = new a3<>();
        BufferUtils.b(1);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.g) {
            d(this.e, this.f);
            this.g = false;
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int E = y0.d.E();
            if (E == 0) {
                return -1;
            }
            return E;
        }
        return invokeV.intValue;
    }

    public static void c(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            h.j(application);
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed shaders/app: { ");
            a3.c<Application> e = h.e();
            e.c();
            while (e.hasNext()) {
                sb.append(h.b(e.next()).b);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void g(Application application) {
        r2<o2> b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, application) != null) || y0.d == null || (b = h.b(application)) == null) {
            return;
        }
        for (int i = 0; i < b.b; i++) {
            b.get(i).g = true;
            b.get(i).b();
        }
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.c = i(35633, str);
            int i = i(35632, str2);
            this.d = i;
            if (this.c != -1 && i != -1) {
                int h2 = h(e());
                this.b = h2;
                if (h2 == -1) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.v2
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f2 f2Var = y0.d;
            f2Var.d(0);
            f2Var.C(this.c);
            f2Var.C(this.d);
            f2Var.z(this.b);
            if (h.b(y0.a) != null) {
                h.b(y0.a).g(this, true);
            }
        }
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            f2 f2Var = y0.d;
            if (i == -1) {
                return -1;
            }
            f2Var.D(i, this.c);
            f2Var.D(i, this.d);
            f2Var.y(i);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
            allocateDirect.order(ByteOrder.nativeOrder());
            IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
            f2Var.k(i, 35714, asIntBuffer);
            if (asIntBuffer.get(0) == 0) {
                this.a = y0.d.B(i);
                return -1;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public final int i(int i, String str) {
        InterceptResult invokeIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, str)) == null) {
            f2 f2Var = y0.d;
            IntBuffer b = BufferUtils.b(1);
            int K = f2Var.K(i);
            if (K == 0) {
                return -1;
            }
            f2Var.u(K, str);
            f2Var.q(K);
            f2Var.A(K, 35713, b);
            if (b.get(0) == 0) {
                String t = f2Var.t(K);
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                if (i == 35633) {
                    str2 = "Vertex shader\n";
                } else {
                    str2 = "Fragment shader:\n";
                }
                sb.append(str2);
                this.a = sb.toString();
                this.a += t;
                return -1;
            }
            return K;
        }
        return invokeIL.intValue;
    }
}
