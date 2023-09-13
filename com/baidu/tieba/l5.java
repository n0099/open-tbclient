package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i3;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class l5<T extends i3> implements b7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, u6<l5>> i;
    public static int j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public u6<T> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public c<? extends l5<T>> h;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
    }

    /* loaded from: classes6.dex */
    public static abstract class c<U extends l5<? extends i3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public u6<b> c;
        public a d;
        public a e;
        public a f;
        public boolean g;
        public boolean h;
        public boolean i;
    }

    public abstract void f(T t);

    public abstract T j(b bVar);

    public abstract void k(T t);

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public boolean c;

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.b && !this.c) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448308612, "Lcom/baidu/tieba/l5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448308612, "Lcom/baidu/tieba/l5;");
                return;
            }
        }
        i = new HashMap();
        k = false;
    }

    public l5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new u6<>();
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            m(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void a(Application application, l5 l5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, l5Var) == null) {
            u6<l5> u6Var = i.get(application);
            if (u6Var == null) {
                u6Var = new u6<>();
            }
            u6Var.a(l5Var);
            i.put(application, u6Var);
        }
    }

    public static void i(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            i.remove(application);
        }
    }

    public static StringBuilder m(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, sb)) == null) {
            sb.append("Managed buffers/app: { ");
            for (Application application : i.keySet()) {
                sb.append(i.get(application).b);
                sb.append(" ");
            }
            sb.append("}");
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    public static void n(Application application) {
        u6<l5> u6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, application) != null) || y0.f == null || (u6Var = i.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < u6Var.b; i2++) {
            u6Var.get(i2).g();
        }
    }

    @Override // com.baidu.tieba.b7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g3 g3Var = y0.f;
            u6.b<T> it = this.a.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
            if (this.f) {
                g3Var.p(this.e);
            } else {
                if (this.h.h) {
                    g3Var.p(this.c);
                }
                if (this.h.g) {
                    g3Var.p(this.d);
                }
            }
            g3Var.r(this.b);
            if (i.get(y0.a) != null) {
                i.get(y0.a).i(this, true);
            }
        }
    }

    public void g() {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g3 g3Var = y0.f;
            h();
            if (!k) {
                k = true;
                if (y0.a.getType() == Application.ApplicationType.iOS) {
                    IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                    g3Var.C(36006, asIntBuffer);
                    j = asIntBuffer.get(0);
                } else {
                    j = 0;
                }
            }
            int Q = g3Var.Q();
            this.b = Q;
            g3Var.f(36160, Q);
            c<? extends l5<T>> cVar = this.h;
            int i3 = cVar.a;
            int i4 = cVar.b;
            if (cVar.h) {
                int P = g3Var.P();
                this.c = P;
                g3Var.m(36161, P);
                g3Var.e(36161, this.h.e.a, i3, i4);
            }
            if (this.h.g) {
                int P2 = g3Var.P();
                this.d = P2;
                g3Var.m(36161, P2);
                g3Var.e(36161, this.h.d.a, i3, i4);
            }
            if (this.h.i) {
                int P3 = g3Var.P();
                this.e = P3;
                g3Var.m(36161, P3);
                g3Var.e(36161, this.h.f.a, i3, i4);
            }
            if (this.h.c.b > 1) {
                z = true;
            } else {
                z = false;
            }
            this.g = z;
            if (z) {
                u6.b<b> it = this.h.c.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    T j2 = j(next);
                    this.a.a(j2);
                    if (next.a()) {
                        g3Var.B(36160, i5 + 36064, 3553, j2.i(), 0);
                        i5++;
                    } else if (next.b) {
                        g3Var.B(36160, 36096, 3553, j2.i(), 0);
                    } else if (next.c) {
                        g3Var.B(36160, 36128, 3553, j2.i(), 0);
                    }
                }
                i2 = i5;
            } else {
                T j3 = j(this.h.c.first());
                this.a.a(j3);
                g3Var.N(j3.a, j3.i());
                i2 = 0;
            }
            if (this.g) {
                IntBuffer d = BufferUtils.d(i2);
                for (int i6 = 0; i6 < i2; i6++) {
                    d.put(i6 + 36064);
                }
                d.position(0);
                y0.g.c(i2, d);
            } else {
                f(this.a.first());
            }
            if (this.h.h) {
                g3Var.k(36160, 36096, 36161, this.c);
            }
            if (this.h.g) {
                g3Var.k(36160, 36128, 36161, this.d);
            }
            if (this.h.i) {
                g3Var.k(36160, 33306, 36161, this.e);
            }
            g3Var.m(36161, 0);
            u6.b<T> it2 = this.a.iterator();
            while (it2.hasNext()) {
                g3Var.N(it2.next().a, 0);
            }
            int t = g3Var.t(36160);
            if (t == 36061) {
                c<? extends l5<T>> cVar2 = this.h;
                if (cVar2.h && cVar2.g && (y0.b.a("GL_OES_packed_depth_stencil") || y0.b.a("GL_EXT_packed_depth_stencil"))) {
                    if (this.h.h) {
                        g3Var.p(this.c);
                        this.c = 0;
                    }
                    if (this.h.g) {
                        g3Var.p(this.d);
                        this.d = 0;
                    }
                    if (this.h.i) {
                        g3Var.p(this.e);
                        this.e = 0;
                    }
                    int P4 = g3Var.P();
                    this.e = P4;
                    this.f = true;
                    g3Var.m(36161, P4);
                    g3Var.e(36161, 35056, i3, i4);
                    g3Var.m(36161, 0);
                    g3Var.k(36160, 36096, 36161, this.e);
                    g3Var.k(36160, 36128, 36161, this.e);
                    t = g3Var.t(36160);
                }
            }
            g3Var.f(36160, j);
            if (t != 36053) {
                u6.b<T> it3 = this.a.iterator();
                while (it3.hasNext()) {
                    k(it3.next());
                }
                if (this.f) {
                    g3Var.b(this.e);
                } else {
                    if (this.h.h) {
                        g3Var.p(this.c);
                    }
                    if (this.h.g) {
                        g3Var.p(this.d);
                    }
                }
                g3Var.r(this.b);
                if (t != 36054) {
                    if (t != 36057) {
                        if (t != 36055) {
                            if (t == 36061) {
                                throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
                            }
                            throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + t);
                        }
                        throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
                    }
                    throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
                }
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
            }
            a(y0.a, this);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !y0.b.b()) {
            c<? extends l5<T>> cVar = this.h;
            if (!cVar.i) {
                u6<b> u6Var = cVar.c;
                if (u6Var.b <= 1) {
                    u6.b<b> it = u6Var.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (!next.b) {
                            if (!next.c) {
                                if (next.a && !y0.b.a("OES_texture_float")) {
                                    throw new GdxRuntimeException("Float texture FrameBuffer Attachment not available on GLES 2.0");
                                }
                            } else {
                                throw new GdxRuntimeException("Stencil texture FrameBuffer Attachment not available on GLES 2.0");
                            }
                        } else {
                            throw new GdxRuntimeException("Depth texture FrameBuffer Attachment not available on GLES 2.0");
                        }
                    }
                    return;
                }
                throw new GdxRuntimeException("Multiple render targets not available on GLES 2.0");
            }
            throw new GdxRuntimeException("Packed Stencil/Render render buffers are not available on GLES 2.0");
        }
    }
}
