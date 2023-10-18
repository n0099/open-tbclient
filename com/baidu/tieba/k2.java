package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h2;
import com.baidu.tieba.r2;
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
public abstract class k2<T extends h2> implements v2 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, r2<k2>> i;
    public static int j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public r2<T> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public c<? extends k2<T>> h;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
    }

    /* loaded from: classes6.dex */
    public static abstract class c<U extends k2<? extends h2>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public r2<b> c;
        public a d;
        public a e;
        public a f;
        public boolean g;
        public boolean h;
        public boolean i;
    }

    public abstract void c(T t);

    public abstract T g(b bVar);

    public abstract void h(T t);

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307558, "Lcom/baidu/tieba/k2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307558, "Lcom/baidu/tieba/k2;");
                return;
            }
        }
        i = new HashMap();
        k = false;
    }

    public k2() {
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
        this.a = new r2<>();
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            j(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void b(Application application, k2 k2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, k2Var) == null) {
            r2<k2> r2Var = i.get(application);
            if (r2Var == null) {
                r2Var = new r2<>();
            }
            r2Var.a(k2Var);
            i.put(application, r2Var);
        }
    }

    public static void f(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            i.remove(application);
        }
    }

    public static StringBuilder j(StringBuilder sb) {
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

    public static void k(Application application) {
        r2<k2> r2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, application) != null) || y0.d == null || (r2Var = i.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < r2Var.b; i2++) {
            r2Var.get(i2).d();
        }
    }

    public void d() {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f2 f2Var = y0.d;
            e();
            if (!k) {
                k = true;
                if (y0.a.getType() == Application.ApplicationType.iOS) {
                    IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                    f2Var.w(36006, asIntBuffer);
                    j = asIntBuffer.get(0);
                } else {
                    j = 0;
                }
            }
            int I = f2Var.I();
            this.b = I;
            f2Var.f(36160, I);
            c<? extends k2<T>> cVar = this.h;
            int i3 = cVar.a;
            int i4 = cVar.b;
            if (cVar.h) {
                int H = f2Var.H();
                this.c = H;
                f2Var.l(36161, H);
                f2Var.e(36161, this.h.e.a, i3, i4);
            }
            if (this.h.g) {
                int H2 = f2Var.H();
                this.d = H2;
                f2Var.l(36161, H2);
                f2Var.e(36161, this.h.d.a, i3, i4);
            }
            if (this.h.i) {
                int H3 = f2Var.H();
                this.e = H3;
                f2Var.l(36161, H3);
                f2Var.e(36161, this.h.f.a, i3, i4);
            }
            if (this.h.c.b > 1) {
                z = true;
            } else {
                z = false;
            }
            this.g = z;
            if (z) {
                r2.b<b> it = this.h.c.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    T g = g(next);
                    this.a.a(g);
                    if (next.a()) {
                        f2Var.v(36160, i5 + 36064, 3553, g.e(), 0);
                        i5++;
                    } else if (next.b) {
                        f2Var.v(36160, 36096, 3553, g.e(), 0);
                    } else if (next.c) {
                        f2Var.v(36160, 36128, 3553, g.e(), 0);
                    }
                }
                i2 = i5;
            } else {
                T g2 = g(this.h.c.first());
                this.a.a(g2);
                f2Var.F(g2.a, g2.e());
                i2 = 0;
            }
            if (this.g) {
                IntBuffer b2 = BufferUtils.b(i2);
                for (int i6 = 0; i6 < i2; i6++) {
                    b2.put(i6 + 36064);
                }
                b2.position(0);
                y0.e.c(i2, b2);
            } else {
                c(this.a.first());
            }
            if (this.h.h) {
                f2Var.j(36160, 36096, 36161, this.c);
            }
            if (this.h.g) {
                f2Var.j(36160, 36128, 36161, this.d);
            }
            if (this.h.i) {
                f2Var.j(36160, 33306, 36161, this.e);
            }
            f2Var.l(36161, 0);
            r2.b<T> it2 = this.a.iterator();
            while (it2.hasNext()) {
                f2Var.F(it2.next().a, 0);
            }
            int r = f2Var.r(36160);
            if (r == 36061) {
                c<? extends k2<T>> cVar2 = this.h;
                if (cVar2.h && cVar2.g && (y0.b.a("GL_OES_packed_depth_stencil") || y0.b.a("GL_EXT_packed_depth_stencil"))) {
                    if (this.h.h) {
                        f2Var.n(this.c);
                        this.c = 0;
                    }
                    if (this.h.g) {
                        f2Var.n(this.d);
                        this.d = 0;
                    }
                    if (this.h.i) {
                        f2Var.n(this.e);
                        this.e = 0;
                    }
                    int H4 = f2Var.H();
                    this.e = H4;
                    this.f = true;
                    f2Var.l(36161, H4);
                    f2Var.e(36161, 35056, i3, i4);
                    f2Var.l(36161, 0);
                    f2Var.j(36160, 36096, 36161, this.e);
                    f2Var.j(36160, 36128, 36161, this.e);
                    r = f2Var.r(36160);
                }
            }
            f2Var.f(36160, j);
            if (r != 36053) {
                r2.b<T> it3 = this.a.iterator();
                while (it3.hasNext()) {
                    h(it3.next());
                }
                if (this.f) {
                    f2Var.b(this.e);
                } else {
                    if (this.h.h) {
                        f2Var.n(this.c);
                    }
                    if (this.h.g) {
                        f2Var.n(this.d);
                    }
                }
                f2Var.p(this.b);
                if (r != 36054) {
                    if (r != 36057) {
                        if (r != 36055) {
                            if (r == 36061) {
                                throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
                            }
                            throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + r);
                        }
                        throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
                    }
                    throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
                }
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
            }
            b(y0.a, this);
        }
    }

    @Override // com.baidu.tieba.v2
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f2 f2Var = y0.d;
            r2.b<T> it = this.a.iterator();
            while (it.hasNext()) {
                h(it.next());
            }
            if (this.f) {
                f2Var.n(this.e);
            } else {
                if (this.h.h) {
                    f2Var.n(this.c);
                }
                if (this.h.g) {
                    f2Var.n(this.d);
                }
            }
            f2Var.p(this.b);
            if (i.get(y0.a) != null) {
                i.get(y0.a).g(this, true);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !y0.b.b()) {
            c<? extends k2<T>> cVar = this.h;
            if (!cVar.i) {
                r2<b> r2Var = cVar.c;
                if (r2Var.b <= 1) {
                    r2.b<b> it = r2Var.iterator();
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
