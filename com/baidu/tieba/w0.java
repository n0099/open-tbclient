package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.g7;
import com.baidu.tieba.k6;
import com.baidu.tieba.u0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes6.dex */
public class w0 implements r6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g7<Class, g7<String, a>> a;
    public final g7<String, Class> b;
    public final g7<String, k6<String>> c;
    public final h7<String> d;
    public final g7<Class, g7<String, x0>> e;
    public final k6<s0> f;
    public final y7 g;
    public final k6<v0> h;
    public t0 i;
    public int j;
    public int k;
    public int l;
    public b7 m;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
        public int b;

        public a() {
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
            this.b = 1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w0() {
        this(new n1());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((b1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.r6
    public synchronized void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.m.a("Disposing.");
                g();
                this.g.dispose();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.a("Waiting for loading to complete...");
            while (!update()) {
                b8.a();
            }
            this.m.a("Loading complete.");
        }
    }

    public b7 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.m;
        }
        return (b7) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w0(b1 b1Var) {
        this(b1Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b1) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public w0(b1 b1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new g7<>();
        this.b = new g7<>();
        this.c = new g7<>();
        this.d = new h7<>();
        this.e = new g7<>();
        this.f = new k6<>();
        this.h = new k6<>();
        this.m = new b7("AssetManager", 0);
        if (z) {
            y(e3.class, new z0(b1Var));
            y(o1.class, new e1(b1Var));
            y(Pixmap.class, new g1(b1Var));
            y(p1.class, new j1(b1Var));
            y(l3.class, new l1(b1Var));
            y(Texture.class, new m1(b1Var));
            y(v5.class, new i1(b1Var));
            y(h3.class, new f1(b1Var));
            y(p4.class, new q4(b1Var));
            y(i3.class, new j3(b1Var));
            y(u6.class, new c1(b1Var));
            z(q3.class, ".g3dj", new v3(new z6(), b1Var));
            z(q3.class, ".g3db", new v3(new x7(), b1Var));
            z(q3.class, ".obj", new x3(b1Var));
            y(h5.class, new h1(b1Var));
            y(Cubemap.class, new a1(b1Var));
        }
        this.g = new y7(1, "AssetManager");
    }

    public synchronized void A(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            synchronized (this) {
                Class c = this.b.c(str);
                if (c != null) {
                    this.a.c(c).c(str).b = i;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
        }
    }

    public synchronized void t(String str, k6<s0> k6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, k6Var) == null) {
            synchronized (this) {
                h7<String> h7Var = this.d;
                k6.b<s0> it = k6Var.iterator();
                while (it.hasNext()) {
                    s0 next = it.next();
                    if (!h7Var.contains(next.a)) {
                        h7Var.add(next.a);
                        u(str, next);
                    }
                }
                h7Var.b(32);
            }
        }
    }

    public void B(s0 s0Var, RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s0Var, runtimeException) == null) {
            throw runtimeException;
        }
    }

    public synchronized <T> T j(String str, Class<T> cls) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, cls)) == null) {
            synchronized (this) {
                t = (T) k(str, cls, true);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public synchronized <T, P extends u0<T>> void y(Class<T> cls, x0<T, P> x0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, cls, x0Var) == null) {
            synchronized (this) {
                z(cls, null, x0Var);
            }
        }
    }

    public synchronized void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                String replace = str.replace('\\', WebvttCueParser.CHAR_SLASH);
                if (this.h.b > 0) {
                    v0 first = this.h.first();
                    if (first.b.a.equals(replace)) {
                        this.m.e("Unload (from tasks): " + replace);
                        first.l = true;
                        first.e();
                        return;
                    }
                }
                Class c = this.b.c(replace);
                int i = 0;
                while (true) {
                    if (i < this.f.b) {
                        if (this.f.get(i).a.equals(replace)) {
                            break;
                        }
                        i++;
                    } else {
                        i = -1;
                        break;
                    }
                }
                if (i != -1) {
                    this.k--;
                    s0 h = this.f.h(i);
                    this.m.e("Unload (from queue): " + replace);
                    if (c != null && h.c != null && h.c.a != null) {
                        h.c.a.a(this, h.a, h.b);
                    }
                } else if (c != null) {
                    a c2 = this.a.c(c).c(replace);
                    int i2 = c2.b - 1;
                    c2.b = i2;
                    if (i2 <= 0) {
                        this.m.e("Unload (dispose): " + replace);
                        if (c2.a instanceof r6) {
                            ((r6) c2.a).dispose();
                        }
                        this.b.k(replace);
                        this.a.c(c).k(replace);
                    } else {
                        this.m.e("Unload (decrement): " + replace);
                    }
                    k6<String> c3 = this.c.c(replace);
                    if (c3 != null) {
                        k6.b<String> it = c3.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (v(next)) {
                                C(next);
                            }
                        }
                    }
                    if (c2.b <= 0) {
                        this.c.k(replace);
                    }
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + replace);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean D() {
        InterceptResult invokeV;
        boolean z;
        u0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            v0 peek = this.h.peek();
            try {
                if (!peek.l) {
                    if (!peek.update()) {
                        z = false;
                        if (z) {
                            return false;
                        }
                        if (this.h.b == 1) {
                            this.j++;
                            this.l = 0;
                        }
                        this.h.pop();
                        if (peek.l) {
                            return true;
                        }
                        s0 s0Var = peek.b;
                        a(s0Var.a, s0Var.b, peek.k);
                        s0 s0Var2 = peek.b;
                        u0 u0Var = s0Var2.c;
                        if (u0Var != null && (aVar = u0Var.a) != null) {
                            aVar.a(this, s0Var2.a, s0Var2.b);
                        }
                        long b = w7.b();
                        this.m.a("Loaded: " + (((float) (b - peek.e)) / 1000000.0f) + "ms " + peek.b);
                        return true;
                    }
                }
                z = true;
                if (z) {
                }
            } catch (RuntimeException e) {
                peek.l = true;
                B(peek.b, e);
                throw null;
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    public final void x() {
        u0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            s0 h = this.f.h(0);
            if (v(h.a)) {
                this.m.a("Already loaded: " + h);
                a c = this.a.c(this.b.c(h.a)).c(h.a);
                c.b = c.b + 1;
                s(h.a);
                u0 u0Var = h.c;
                if (u0Var != null && (aVar = u0Var.a) != null) {
                    aVar.a(this, h.a, h.b);
                }
                this.j++;
                return;
            }
            this.m.e("Loading: " + h);
            f(h);
        }
    }

    public <T> void a(String str, Class<T> cls, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, cls, t) == null) {
            this.b.i(str, cls);
            g7<String, a> c = this.a.c(cls);
            if (c == null) {
                c = new g7<>();
                this.a.i(cls, c);
            }
            a aVar = new a();
            aVar.a = t;
            c.i(str, aVar);
        }
    }

    public final void f(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, s0Var) == null) {
            x0 o = o(s0Var.b, s0Var.a);
            if (o != null) {
                this.h.a(new v0(this, s0Var, o, this.g));
                this.l++;
                return;
            }
            throw new GdxRuntimeException("No loader for type: " + d8.e(s0Var.b));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000e, B:8:0x0014, B:9:0x0026, B:11:0x002c, B:13:0x003a, B:15:0x0040), top: B:28:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> String m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, t)) == null) {
            synchronized (this) {
                g7.c<Class> f = this.a.f();
                f.c();
                while (f.hasNext()) {
                    g7.a<String, a> it = this.a.c(f.next()).iterator();
                    while (it.hasNext()) {
                        g7.b next = it.next();
                        Object obj = ((a) next.b).a;
                        if (obj == t || t.equals(obj)) {
                            return (String) next.a;
                        }
                        while (it.hasNext()) {
                        }
                    }
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public synchronized int q(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            synchronized (this) {
                Class c = this.b.c(str);
                if (c != null) {
                    i = this.a.c(c).c(str).b;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final void r(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, th) == null) {
            this.m.c("Error loading asset.", th);
            if (!this.h.isEmpty()) {
                v0 pop = this.h.pop();
                s0 s0Var = pop.b;
                if (pop.g && pop.h != null) {
                    k6.b<s0> it = pop.h.iterator();
                    while (it.hasNext()) {
                        C(it.next().a);
                    }
                }
                this.h.clear();
                t0 t0Var = this.i;
                if (t0Var != null) {
                    t0Var.a(s0Var, th);
                    return;
                }
                throw new GdxRuntimeException(th);
            }
            throw new GdxRuntimeException(th);
        }
    }

    public final void s(String str) {
        k6<String> c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, str) != null) || (c = this.c.c(str)) == null) {
            return;
        }
        k6.b<String> it = c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.a.c(this.b.c(next)).c(next).b++;
            s(next);
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f.clear();
                while (!update()) {
                }
                f7 f7Var = new f7();
                while (this.b.a > 0) {
                    f7Var.clear();
                    k6<String> d = this.b.f().d();
                    k6.b<String> it = d.iterator();
                    while (it.hasNext()) {
                        k6<String> c = this.c.c(it.next());
                        if (c != null) {
                            k6.b<String> it2 = c.iterator();
                            while (it2.hasNext()) {
                                f7Var.d(it2.next(), 0, 1);
                            }
                        }
                    }
                    k6.b<String> it3 = d.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        if (f7Var.c(next, 0) == 0) {
                            C(next);
                        }
                    }
                }
                this.a.clear();
                this.b.clear();
                this.c.clear();
                this.j = 0;
                this.k = 0;
                this.l = 0;
                this.f.clear();
                this.h.clear();
            }
        }
    }

    public synchronized <T> T i(String str) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                t = (T) l(str, true);
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public synchronized k6<String> n(String str) {
        InterceptResult invokeL;
        k6<String> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                c = this.c.c(str);
            }
            return c;
        }
        return (k6) invokeL.objValue;
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        boolean update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            long a2 = w7.a() + i;
            while (true) {
                update = update();
                if (update || w7.a() > a2) {
                    break;
                }
                b8.a();
            }
            return update;
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            synchronized (this) {
                if (str == null) {
                    return false;
                }
                return this.b.a(str);
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized <T> T k(String str, Class<T> cls, boolean z) {
        InterceptResult invokeLLZ;
        a c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, cls, z)) == null) {
            synchronized (this) {
                g7<String, a> c2 = this.a.c(cls);
                if (c2 != null && (c = c2.c(str)) != null) {
                    return (T) c.a;
                }
                if (!z) {
                    return null;
                }
                throw new GdxRuntimeException("Asset not loaded: " + str);
            }
        }
        return (T) invokeLLZ.objValue;
    }

    public synchronized <T> T l(String str, boolean z) {
        InterceptResult invokeLZ;
        g7<String, a> c;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            synchronized (this) {
                Class c3 = this.b.c(str);
                if (c3 != null && (c = this.a.c(c3)) != null && (c2 = c.c(str)) != null) {
                    return (T) c2.a;
                }
                if (!z) {
                    return null;
                }
                throw new GdxRuntimeException("Asset not loaded: " + str);
            }
        }
        return (T) invokeLZ.objValue;
    }

    public <T> x0 o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            g7<String, x0> c = this.e.c(cls);
            x0 x0Var = null;
            if (c != null && c.a >= 1) {
                if (str == null) {
                    return c.c("");
                }
                int i = -1;
                g7.a<String, x0> b = c.b();
                b.c();
                while (b.hasNext()) {
                    g7.b next = b.next();
                    if (((String) next.a).length() > i && str.endsWith((String) next.a)) {
                        x0Var = (x0) next.b;
                        i = ((String) next.a).length();
                    }
                }
            }
            return x0Var;
        }
        return (x0) invokeLL.objValue;
    }

    public final synchronized void u(String str, s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, s0Var) == null) {
            synchronized (this) {
                k6<String> c = this.c.c(str);
                if (c == null) {
                    c = new k6<>();
                    this.c.i(str, c);
                }
                c.a(s0Var.a);
                if (v(s0Var.a)) {
                    b7 b7Var = this.m;
                    b7Var.a("Dependency already loaded: " + s0Var);
                    a c2 = this.a.c(this.b.c(s0Var.a)).c(s0Var.a);
                    c2.b = c2.b + 1;
                    s(s0Var.a);
                } else {
                    b7 b7Var2 = this.m;
                    b7Var2.e("Loading dependency: " + s0Var);
                    f(s0Var);
                }
            }
        }
    }

    public synchronized boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                boolean z = false;
                try {
                    if (this.h.b == 0) {
                        while (this.f.b != 0 && this.h.b == 0) {
                            x();
                        }
                        if (this.h.b == 0) {
                            return true;
                        }
                    }
                    if (D() && this.f.b == 0) {
                        if (this.h.b == 0) {
                            z = true;
                        }
                    }
                    return z;
                } catch (Throwable th) {
                    r(th);
                    if (this.f.b != 0) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized <T> void w(String str, Class<T> cls, u0<T> u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, cls, u0Var) == null) {
            synchronized (this) {
                if (o(cls, str) != null) {
                    if (this.f.b == 0) {
                        this.j = 0;
                        this.k = 0;
                        this.l = 0;
                    }
                    for (int i = 0; i < this.f.b; i++) {
                        s0 s0Var = this.f.get(i);
                        if (s0Var.a.equals(str) && !s0Var.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + d8.e(cls) + ", found: " + d8.e(s0Var.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i2 = 0; i2 < this.h.b; i2++) {
                        s0 s0Var2 = this.h.get(i2).b;
                        if (s0Var2.a.equals(str) && !s0Var2.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + d8.e(cls) + ", found: " + d8.e(s0Var2.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class c = this.b.c(str);
                    if (c != null && !c.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + d8.e(cls) + ", found: " + d8.e(c) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.k++;
                    s0 s0Var3 = new s0(str, cls, u0Var);
                    this.f.a(s0Var3);
                    this.m.a("Queued: " + s0Var3);
                } else {
                    throw new GdxRuntimeException("No loader for type: " + d8.e(cls));
                }
            }
        }
    }

    public synchronized <T, P extends u0<T>> void z(Class<T> cls, String str, x0<T, P> x0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, cls, str, x0Var) == null) {
            synchronized (this) {
                if (cls != null) {
                    if (x0Var != null) {
                        b7 b7Var = this.m;
                        b7Var.a("Loader set: " + d8.e(cls) + LoadErrorCode.TOKEN_NEXT + d8.e(x0Var.getClass()));
                        g7<String, x0> c = this.e.c(cls);
                        if (c == null) {
                            g7<Class, g7<String, x0>> g7Var = this.e;
                            g7<String, x0> g7Var2 = new g7<>();
                            g7Var.i(cls, g7Var2);
                            c = g7Var2;
                        }
                        if (str == null) {
                            str = "";
                        }
                        c.i(str, x0Var);
                    } else {
                        throw new IllegalArgumentException("loader cannot be null.");
                    }
                } else {
                    throw new IllegalArgumentException("type cannot be null.");
                }
            }
        }
    }
}
