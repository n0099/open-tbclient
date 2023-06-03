package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g3;
import com.baidu.tieba.s6;
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
public abstract class j5<T extends g3> implements z6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, s6<j5>> i;
    public static int j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public s6<T> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public c<? extends j5<T>> h;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
    }

    /* loaded from: classes6.dex */
    public static abstract class c<U extends j5<? extends g3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public s6<b> c;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306690, "Lcom/baidu/tieba/j5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306690, "Lcom/baidu/tieba/j5;");
                return;
            }
        }
        i = new HashMap();
        k = false;
    }

    public j5() {
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
        this.a = new s6<>();
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

    public static void a(Application application, j5 j5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, j5Var) == null) {
            s6<j5> s6Var = i.get(application);
            if (s6Var == null) {
                s6Var = new s6<>();
            }
            s6Var.a(j5Var);
            i.put(application, s6Var);
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
        s6<j5> s6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, application) != null) || w0.f == null || (s6Var = i.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < s6Var.b; i2++) {
            s6Var.get(i2).g();
        }
    }

    @Override // com.baidu.tieba.z6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e3 e3Var = w0.f;
            s6.b<T> it = this.a.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
            if (this.f) {
                e3Var.p(this.e);
            } else {
                if (this.h.h) {
                    e3Var.p(this.c);
                }
                if (this.h.g) {
                    e3Var.p(this.d);
                }
            }
            e3Var.r(this.b);
            if (i.get(w0.a) != null) {
                i.get(w0.a).i(this, true);
            }
        }
    }

    public void g() {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e3 e3Var = w0.f;
            h();
            if (!k) {
                k = true;
                if (w0.a.getType() == Application.ApplicationType.iOS) {
                    IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                    e3Var.C(36006, asIntBuffer);
                    j = asIntBuffer.get(0);
                } else {
                    j = 0;
                }
            }
            int Q = e3Var.Q();
            this.b = Q;
            e3Var.f(36160, Q);
            c<? extends j5<T>> cVar = this.h;
            int i3 = cVar.a;
            int i4 = cVar.b;
            if (cVar.h) {
                int P = e3Var.P();
                this.c = P;
                e3Var.m(36161, P);
                e3Var.e(36161, this.h.e.a, i3, i4);
            }
            if (this.h.g) {
                int P2 = e3Var.P();
                this.d = P2;
                e3Var.m(36161, P2);
                e3Var.e(36161, this.h.d.a, i3, i4);
            }
            if (this.h.i) {
                int P3 = e3Var.P();
                this.e = P3;
                e3Var.m(36161, P3);
                e3Var.e(36161, this.h.f.a, i3, i4);
            }
            if (this.h.c.b > 1) {
                z = true;
            } else {
                z = false;
            }
            this.g = z;
            if (z) {
                s6.b<b> it = this.h.c.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    T j2 = j(next);
                    this.a.a(j2);
                    if (next.a()) {
                        e3Var.B(36160, i5 + 36064, 3553, j2.i(), 0);
                        i5++;
                    } else if (next.b) {
                        e3Var.B(36160, 36096, 3553, j2.i(), 0);
                    } else if (next.c) {
                        e3Var.B(36160, 36128, 3553, j2.i(), 0);
                    }
                }
                i2 = i5;
            } else {
                T j3 = j(this.h.c.first());
                this.a.a(j3);
                e3Var.N(j3.a, j3.i());
                i2 = 0;
            }
            if (this.g) {
                IntBuffer d = BufferUtils.d(i2);
                for (int i6 = 0; i6 < i2; i6++) {
                    d.put(i6 + 36064);
                }
                d.position(0);
                w0.g.c(i2, d);
            } else {
                f(this.a.first());
            }
            if (this.h.h) {
                e3Var.k(36160, 36096, 36161, this.c);
            }
            if (this.h.g) {
                e3Var.k(36160, 36128, 36161, this.d);
            }
            if (this.h.i) {
                e3Var.k(36160, 33306, 36161, this.e);
            }
            e3Var.m(36161, 0);
            s6.b<T> it2 = this.a.iterator();
            while (it2.hasNext()) {
                e3Var.N(it2.next().a, 0);
            }
            int t = e3Var.t(36160);
            if (t == 36061) {
                c<? extends j5<T>> cVar2 = this.h;
                if (cVar2.h && cVar2.g && (w0.b.a("GL_OES_packed_depth_stencil") || w0.b.a("GL_EXT_packed_depth_stencil"))) {
                    if (this.h.h) {
                        e3Var.p(this.c);
                        this.c = 0;
                    }
                    if (this.h.g) {
                        e3Var.p(this.d);
                        this.d = 0;
                    }
                    if (this.h.i) {
                        e3Var.p(this.e);
                        this.e = 0;
                    }
                    int P4 = e3Var.P();
                    this.e = P4;
                    this.f = true;
                    e3Var.m(36161, P4);
                    e3Var.e(36161, 35056, i3, i4);
                    e3Var.m(36161, 0);
                    e3Var.k(36160, 36096, 36161, this.e);
                    e3Var.k(36160, 36128, 36161, this.e);
                    t = e3Var.t(36160);
                }
            }
            e3Var.f(36160, j);
            if (t != 36053) {
                s6.b<T> it3 = this.a.iterator();
                while (it3.hasNext()) {
                    k(it3.next());
                }
                if (this.f) {
                    e3Var.b(this.e);
                } else {
                    if (this.h.h) {
                        e3Var.p(this.c);
                    }
                    if (this.h.g) {
                        e3Var.p(this.d);
                    }
                }
                e3Var.r(this.b);
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
            a(w0.a, this);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !w0.b.b()) {
            c<? extends j5<T>> cVar = this.h;
            if (!cVar.i) {
                s6<b> s6Var = cVar.c;
                if (s6Var.b <= 1) {
                    s6.b<b> it = s6Var.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (!next.b) {
                            if (!next.c) {
                                if (next.a && !w0.b.a("OES_texture_float")) {
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
