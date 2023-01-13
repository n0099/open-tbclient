package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.c7;
import com.baidu.tieba.m1;
import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes5.dex */
public class o1 implements j7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y7<Class, y7<String, a>> a;
    public final y7<String, Class> b;
    public final y7<String, c7<String>> c;
    public final z7<String> d;
    public final y7<Class, y7<String, p1>> e;
    public final c7<k1> f;
    public final q8 g;
    public final c7<n1> h;
    public l1 i;
    public int j;
    public int k;
    public int l;
    public t7 m;

    /* loaded from: classes5.dex */
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
    public o1() {
        this(new f2());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((t1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.j7
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
                t8.a();
            }
            this.m.a("Loading complete.");
        }
    }

    public t7 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.m;
        }
        return (t7) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o1(t1 t1Var) {
        this(t1Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((t1) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public o1(t1 t1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t1Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new y7<>();
        this.b = new y7<>();
        this.c = new y7<>();
        this.d = new z7<>();
        this.e = new y7<>();
        this.f = new c7<>();
        this.h = new c7<>();
        this.m = new t7("AssetManager", 0);
        if (z) {
            y(w3.class, new r1(t1Var));
            y(g2.class, new w1(t1Var));
            y(Pixmap.class, new y1(t1Var));
            y(h2.class, new b2(t1Var));
            y(d4.class, new d2(t1Var));
            y(Texture.class, new e2(t1Var));
            y(n6.class, new a2(t1Var));
            y(z3.class, new x1(t1Var));
            y(h5.class, new i5(t1Var));
            y(a4.class, new b4(t1Var));
            y(m7.class, new u1(t1Var));
            z(i4.class, ".g3dj", new n4(new r7(), t1Var));
            z(i4.class, ".g3db", new n4(new p8(), t1Var));
            z(i4.class, ".obj", new p4(t1Var));
            y(z5.class, new z1(t1Var));
            y(Cubemap.class, new s1(t1Var));
        }
        this.g = new q8(1, "AssetManager");
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

    public synchronized void t(String str, c7<k1> c7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, c7Var) == null) {
            synchronized (this) {
                z7<String> z7Var = this.d;
                c7.b<k1> it = c7Var.iterator();
                while (it.hasNext()) {
                    k1 next = it.next();
                    if (!z7Var.contains(next.a)) {
                        z7Var.add(next.a);
                        u(str, next);
                    }
                }
                z7Var.b(32);
            }
        }
    }

    public void B(k1 k1Var, RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k1Var, runtimeException) == null) {
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

    public synchronized <T, P extends m1<T>> void y(Class<T> cls, p1<T, P> p1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, cls, p1Var) == null) {
            synchronized (this) {
                z(cls, null, p1Var);
            }
        }
    }

    public synchronized void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                String replace = str.replace('\\', WebvttCueParser.CHAR_SLASH);
                if (this.h.b > 0) {
                    n1 first = this.h.first();
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
                    k1 h = this.f.h(i);
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
                        if (c2.a instanceof j7) {
                            ((j7) c2.a).dispose();
                        }
                        this.b.k(replace);
                        this.a.c(c).k(replace);
                    } else {
                        this.m.e("Unload (decrement): " + replace);
                    }
                    c7<String> c3 = this.c.c(replace);
                    if (c3 != null) {
                        c7.b<String> it = c3.iterator();
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
        m1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n1 peek = this.h.peek();
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
                        k1 k1Var = peek.b;
                        a(k1Var.a, k1Var.b, peek.k);
                        k1 k1Var2 = peek.b;
                        m1 m1Var = k1Var2.c;
                        if (m1Var != null && (aVar = m1Var.a) != null) {
                            aVar.a(this, k1Var2.a, k1Var2.b);
                        }
                        long b = o8.b();
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
        m1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            k1 h = this.f.h(0);
            if (v(h.a)) {
                this.m.a("Already loaded: " + h);
                a c = this.a.c(this.b.c(h.a)).c(h.a);
                c.b = c.b + 1;
                s(h.a);
                m1 m1Var = h.c;
                if (m1Var != null && (aVar = m1Var.a) != null) {
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
            y7<String, a> c = this.a.c(cls);
            if (c == null) {
                c = new y7<>();
                this.a.i(cls, c);
            }
            a aVar = new a();
            aVar.a = t;
            c.i(str, aVar);
        }
    }

    public final void f(k1 k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, k1Var) == null) {
            p1 o = o(k1Var.b, k1Var.a);
            if (o != null) {
                this.h.a(new n1(this, k1Var, o, this.g));
                this.l++;
                return;
            }
            throw new GdxRuntimeException("No loader for type: " + v8.e(k1Var.b));
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
                y7.c<Class> f = this.a.f();
                f.c();
                while (f.hasNext()) {
                    y7.a<String, a> it = this.a.c(f.next()).iterator();
                    while (it.hasNext()) {
                        y7.b next = it.next();
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
                n1 pop = this.h.pop();
                k1 k1Var = pop.b;
                if (pop.g && pop.h != null) {
                    c7.b<k1> it = pop.h.iterator();
                    while (it.hasNext()) {
                        C(it.next().a);
                    }
                }
                this.h.clear();
                l1 l1Var = this.i;
                if (l1Var != null) {
                    l1Var.a(k1Var, th);
                    return;
                }
                throw new GdxRuntimeException(th);
            }
            throw new GdxRuntimeException(th);
        }
    }

    public final void s(String str) {
        c7<String> c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, str) != null) || (c = this.c.c(str)) == null) {
            return;
        }
        c7.b<String> it = c.iterator();
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
                x7 x7Var = new x7();
                while (this.b.a > 0) {
                    x7Var.clear();
                    c7<String> d = this.b.f().d();
                    c7.b<String> it = d.iterator();
                    while (it.hasNext()) {
                        c7<String> c = this.c.c(it.next());
                        if (c != null) {
                            c7.b<String> it2 = c.iterator();
                            while (it2.hasNext()) {
                                x7Var.d(it2.next(), 0, 1);
                            }
                        }
                    }
                    c7.b<String> it3 = d.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        if (x7Var.c(next, 0) == 0) {
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

    public synchronized c7<String> n(String str) {
        InterceptResult invokeL;
        c7<String> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                c = this.c.c(str);
            }
            return c;
        }
        return (c7) invokeL.objValue;
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        boolean update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            long a2 = o8.a() + i;
            while (true) {
                update = update();
                if (update || o8.a() > a2) {
                    break;
                }
                t8.a();
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
                y7<String, a> c2 = this.a.c(cls);
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
        y7<String, a> c;
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

    public <T> p1 o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            y7<String, p1> c = this.e.c(cls);
            p1 p1Var = null;
            if (c != null && c.a >= 1) {
                if (str == null) {
                    return c.c("");
                }
                int i = -1;
                y7.a<String, p1> b = c.b();
                b.c();
                while (b.hasNext()) {
                    y7.b next = b.next();
                    if (((String) next.a).length() > i && str.endsWith((String) next.a)) {
                        p1Var = (p1) next.b;
                        i = ((String) next.a).length();
                    }
                }
            }
            return p1Var;
        }
        return (p1) invokeLL.objValue;
    }

    public final synchronized void u(String str, k1 k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, k1Var) == null) {
            synchronized (this) {
                c7<String> c = this.c.c(str);
                if (c == null) {
                    c = new c7<>();
                    this.c.i(str, c);
                }
                c.a(k1Var.a);
                if (v(k1Var.a)) {
                    t7 t7Var = this.m;
                    t7Var.a("Dependency already loaded: " + k1Var);
                    a c2 = this.a.c(this.b.c(k1Var.a)).c(k1Var.a);
                    c2.b = c2.b + 1;
                    s(k1Var.a);
                } else {
                    t7 t7Var2 = this.m;
                    t7Var2.e("Loading dependency: " + k1Var);
                    f(k1Var);
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

    public synchronized <T> void w(String str, Class<T> cls, m1<T> m1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, cls, m1Var) == null) {
            synchronized (this) {
                if (o(cls, str) != null) {
                    if (this.f.b == 0) {
                        this.j = 0;
                        this.k = 0;
                        this.l = 0;
                    }
                    for (int i = 0; i < this.f.b; i++) {
                        k1 k1Var = this.f.get(i);
                        if (k1Var.a.equals(str) && !k1Var.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + v8.e(cls) + ", found: " + v8.e(k1Var.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i2 = 0; i2 < this.h.b; i2++) {
                        k1 k1Var2 = this.h.get(i2).b;
                        if (k1Var2.a.equals(str) && !k1Var2.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + v8.e(cls) + ", found: " + v8.e(k1Var2.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class c = this.b.c(str);
                    if (c != null && !c.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + v8.e(cls) + ", found: " + v8.e(c) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.k++;
                    k1 k1Var3 = new k1(str, cls, m1Var);
                    this.f.a(k1Var3);
                    this.m.a("Queued: " + k1Var3);
                } else {
                    throw new GdxRuntimeException("No loader for type: " + v8.e(cls));
                }
            }
        }
    }

    public synchronized <T, P extends m1<T>> void z(Class<T> cls, String str, p1<T, P> p1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, cls, str, p1Var) == null) {
            synchronized (this) {
                if (cls != null) {
                    if (p1Var != null) {
                        t7 t7Var = this.m;
                        t7Var.a("Loader set: " + v8.e(cls) + LoadErrorCode.TOKEN_NEXT + v8.e(p1Var.getClass()));
                        y7<String, p1> c = this.e.c(cls);
                        if (c == null) {
                            y7<Class, y7<String, p1>> y7Var = this.e;
                            y7<String, p1> y7Var2 = new y7<>();
                            y7Var.i(cls, y7Var2);
                            c = y7Var2;
                        }
                        if (str == null) {
                            str = "";
                        }
                        c.i(str, p1Var);
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
