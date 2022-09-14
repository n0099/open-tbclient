package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.b7;
import com.baidu.tieba.l1;
import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes5.dex */
public class n1 implements i7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final x7<Class, x7<String, a>> a;
    public final x7<String, Class> b;
    public final x7<String, b7<String>> c;
    public final y7<String> d;
    public final x7<Class, x7<String, o1>> e;
    public final b7<j1> f;
    public final p8 g;
    public final b7<m1> h;
    public k1 i;
    public int j;
    public int k;
    public int l;
    public s7 m;

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
    public n1() {
        this(new e2());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((s1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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

    public void B(j1 j1Var, RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j1Var, runtimeException) == null) {
            throw runtimeException;
        }
    }

    public synchronized void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                String replace = str.replace('\\', WebvttCueParser.CHAR_SLASH);
                if (this.h.b > 0) {
                    m1 f = this.h.f();
                    if (f.b.a.equals(replace)) {
                        this.m.e("Unload (from tasks): " + replace);
                        f.l = true;
                        f.e();
                        return;
                    }
                }
                Class c = this.b.c(replace);
                int i = 0;
                while (true) {
                    if (i >= this.f.b) {
                        i = -1;
                        break;
                    } else if (this.f.get(i).a.equals(replace)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    this.k--;
                    j1 i2 = this.f.i(i);
                    this.m.e("Unload (from queue): " + replace);
                    if (c != null && i2.c != null && i2.c.a != null) {
                        i2.c.a.a(this, i2.a, i2.b);
                    }
                } else if (c != null) {
                    a c2 = this.a.c(c).c(replace);
                    int i3 = c2.b - 1;
                    c2.b = i3;
                    if (i3 <= 0) {
                        this.m.e("Unload (dispose): " + replace);
                        if (c2.a instanceof i7) {
                            ((i7) c2.a).dispose();
                        }
                        this.b.k(replace);
                        this.a.c(c).k(replace);
                    } else {
                        this.m.e("Unload (decrement): " + replace);
                    }
                    b7<String> c3 = this.c.c(replace);
                    if (c3 != null) {
                        b7.b<String> it = c3.iterator();
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
        l1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return invokeV.booleanValue;
        }
        m1 peek = this.h.peek();
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
                    j1 j1Var = peek.b;
                    a(j1Var.a, j1Var.b, peek.k);
                    j1 j1Var2 = peek.b;
                    l1 l1Var = j1Var2.c;
                    if (l1Var != null && (aVar = l1Var.a) != null) {
                        aVar.a(this, j1Var2.a, j1Var2.b);
                    }
                    long b = n8.b();
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
    }

    public <T> void a(String str, Class<T> cls, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, cls, t) == null) {
            this.b.i(str, cls);
            x7<String, a> c = this.a.c(cls);
            if (c == null) {
                c = new x7<>();
                this.a.i(cls, c);
            }
            a aVar = new a();
            aVar.a = t;
            c.i(str, aVar);
        }
    }

    @Override // com.baidu.tieba.i7
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

    public final void f(j1 j1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, j1Var) == null) {
            o1 o = o(j1Var.b, j1Var.a);
            if (o != null) {
                this.h.a(new m1(this, j1Var, o, this.g));
                this.l++;
                return;
            }
            throw new GdxRuntimeException("No loader for type: " + u8.e(j1Var.b));
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f.clear();
                while (!update()) {
                }
                w7 w7Var = new w7();
                while (this.b.a > 0) {
                    w7Var.clear();
                    b7<String> d = this.b.f().d();
                    b7.b<String> it = d.iterator();
                    while (it.hasNext()) {
                        b7<String> c = this.c.c(it.next());
                        if (c != null) {
                            b7.b<String> it2 = c.iterator();
                            while (it2.hasNext()) {
                                w7Var.d(it2.next(), 0, 1);
                            }
                        }
                    }
                    b7.b<String> it3 = d.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        if (w7Var.c(next, 0) == 0) {
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

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.a("Waiting for loading to complete...");
            while (!update()) {
                s8.a();
            }
            this.m.a("Loading complete.");
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

    public synchronized <T> T k(String str, Class<T> cls, boolean z) {
        InterceptResult invokeLLZ;
        a c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, cls, z)) == null) {
            synchronized (this) {
                x7<String, a> c2 = this.a.c(cls);
                if (c2 == null || (c = c2.c(str)) == null) {
                    if (z) {
                        throw new GdxRuntimeException("Asset not loaded: " + str);
                    }
                    return null;
                }
                return (T) c.a;
            }
        }
        return (T) invokeLLZ.objValue;
    }

    public synchronized <T> T l(String str, boolean z) {
        InterceptResult invokeLZ;
        x7<String, a> c;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            synchronized (this) {
                Class c3 = this.b.c(str);
                if (c3 == null || (c = this.a.c(c3)) == null || (c2 = c.c(str)) == null) {
                    if (z) {
                        throw new GdxRuntimeException("Asset not loaded: " + str);
                    }
                    return null;
                }
                return (T) c2.a;
            }
        }
        return (T) invokeLZ.objValue;
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
                x7.c<Class> f = this.a.f();
                f.c();
                while (f.hasNext()) {
                    x7.a<String, a> it = this.a.c(f.next()).iterator();
                    while (it.hasNext()) {
                        x7.b next = it.next();
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

    public synchronized b7<String> n(String str) {
        InterceptResult invokeL;
        b7<String> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                c = this.c.c(str);
            }
            return c;
        }
        return (b7) invokeL.objValue;
    }

    public <T> o1 o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            x7<String, o1> c = this.e.c(cls);
            o1 o1Var = null;
            if (c != null && c.a >= 1) {
                if (str == null) {
                    return c.c("");
                }
                int i = -1;
                x7.a<String, o1> b = c.b();
                b.c();
                while (b.hasNext()) {
                    x7.b next = b.next();
                    if (((String) next.a).length() > i && str.endsWith((String) next.a)) {
                        o1Var = (o1) next.b;
                        i = ((String) next.a).length();
                    }
                }
            }
            return o1Var;
        }
        return (o1) invokeLL.objValue;
    }

    public s7 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : (s7) invokeV.objValue;
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
                m1 pop = this.h.pop();
                j1 j1Var = pop.b;
                if (pop.g && pop.h != null) {
                    b7.b<j1> it = pop.h.iterator();
                    while (it.hasNext()) {
                        C(it.next().a);
                    }
                }
                this.h.clear();
                k1 k1Var = this.i;
                if (k1Var != null) {
                    k1Var.a(j1Var, th);
                    return;
                }
                throw new GdxRuntimeException(th);
            }
            throw new GdxRuntimeException(th);
        }
    }

    public final void s(String str) {
        b7<String> c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (c = this.c.c(str)) == null) {
            return;
        }
        b7.b<String> it = c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.a.c(this.b.c(next)).c(next).b++;
            s(next);
        }
    }

    public synchronized void t(String str, b7<j1> b7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, b7Var) == null) {
            synchronized (this) {
                y7<String> y7Var = this.d;
                b7.b<j1> it = b7Var.iterator();
                while (it.hasNext()) {
                    j1 next = it.next();
                    if (!y7Var.contains(next.a)) {
                        y7Var.add(next.a);
                        u(str, next);
                    }
                }
                y7Var.b(32);
            }
        }
    }

    public final synchronized void u(String str, j1 j1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, j1Var) == null) {
            synchronized (this) {
                b7<String> c = this.c.c(str);
                if (c == null) {
                    c = new b7<>();
                    this.c.i(str, c);
                }
                c.a(j1Var.a);
                if (v(j1Var.a)) {
                    s7 s7Var = this.m;
                    s7Var.a("Dependency already loaded: " + j1Var);
                    a c2 = this.a.c(this.b.c(j1Var.a)).c(j1Var.a);
                    c2.b = c2.b + 1;
                    s(j1Var.a);
                } else {
                    s7 s7Var2 = this.m;
                    s7Var2.e("Loading dependency: " + j1Var);
                    f(j1Var);
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
                    return this.f.b == 0;
                }
            }
        }
        return invokeV.booleanValue;
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

    public synchronized <T> void w(String str, Class<T> cls, l1<T> l1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, cls, l1Var) == null) {
            synchronized (this) {
                if (o(cls, str) != null) {
                    if (this.f.b == 0) {
                        this.j = 0;
                        this.k = 0;
                        this.l = 0;
                    }
                    for (int i = 0; i < this.f.b; i++) {
                        j1 j1Var = this.f.get(i);
                        if (j1Var.a.equals(str) && !j1Var.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + u8.e(cls) + ", found: " + u8.e(j1Var.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i2 = 0; i2 < this.h.b; i2++) {
                        j1 j1Var2 = this.h.get(i2).b;
                        if (j1Var2.a.equals(str) && !j1Var2.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + u8.e(cls) + ", found: " + u8.e(j1Var2.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class c = this.b.c(str);
                    if (c != null && !c.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + u8.e(cls) + ", found: " + u8.e(c) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.k++;
                    j1 j1Var3 = new j1(str, cls, l1Var);
                    this.f.a(j1Var3);
                    this.m.a("Queued: " + j1Var3);
                } else {
                    throw new GdxRuntimeException("No loader for type: " + u8.e(cls));
                }
            }
        }
    }

    public final void x() {
        l1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            j1 i = this.f.i(0);
            if (v(i.a)) {
                this.m.a("Already loaded: " + i);
                a c = this.a.c(this.b.c(i.a)).c(i.a);
                c.b = c.b + 1;
                s(i.a);
                l1 l1Var = i.c;
                if (l1Var != null && (aVar = l1Var.a) != null) {
                    aVar.a(this, i.a, i.b);
                }
                this.j++;
                return;
            }
            this.m.e("Loading: " + i);
            f(i);
        }
    }

    public synchronized <T, P extends l1<T>> void y(Class<T> cls, o1<T, P> o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, cls, o1Var) == null) {
            synchronized (this) {
                z(cls, null, o1Var);
            }
        }
    }

    public synchronized <T, P extends l1<T>> void z(Class<T> cls, String str, o1<T, P> o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, cls, str, o1Var) == null) {
            synchronized (this) {
                if (cls == null) {
                    throw new IllegalArgumentException("type cannot be null.");
                }
                if (o1Var != null) {
                    s7 s7Var = this.m;
                    s7Var.a("Loader set: " + u8.e(cls) + LoadErrorCode.TOKEN_NEXT + u8.e(o1Var.getClass()));
                    x7<String, o1> c = this.e.c(cls);
                    if (c == null) {
                        x7<Class, x7<String, o1>> x7Var = this.e;
                        x7<String, o1> x7Var2 = new x7<>();
                        x7Var.i(cls, x7Var2);
                        c = x7Var2;
                    }
                    if (str == null) {
                        str = "";
                    }
                    c.i(str, o1Var);
                } else {
                    throw new IllegalArgumentException("loader cannot be null.");
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n1(s1 s1Var) {
        this(s1Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((s1) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public n1(s1 s1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s1Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new x7<>();
        this.b = new x7<>();
        this.c = new x7<>();
        this.d = new y7<>();
        this.e = new x7<>();
        this.f = new b7<>();
        this.h = new b7<>();
        this.m = new s7("AssetManager", 0);
        if (z) {
            y(v3.class, new q1(s1Var));
            y(f2.class, new v1(s1Var));
            y(Pixmap.class, new x1(s1Var));
            y(g2.class, new a2(s1Var));
            y(c4.class, new c2(s1Var));
            y(Texture.class, new d2(s1Var));
            y(m6.class, new z1(s1Var));
            y(y3.class, new w1(s1Var));
            y(g5.class, new h5(s1Var));
            y(z3.class, new a4(s1Var));
            y(l7.class, new t1(s1Var));
            z(h4.class, ".g3dj", new m4(new q7(), s1Var));
            z(h4.class, ".g3db", new m4(new o8(), s1Var));
            z(h4.class, ".obj", new o4(s1Var));
            y(y5.class, new y1(s1Var));
            y(Cubemap.class, new r1(s1Var));
        }
        this.g = new p8(1, "AssetManager");
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        boolean update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            long a2 = n8.a() + i;
            while (true) {
                update = update();
                if (update || n8.a() > a2) {
                    break;
                }
                s8.a();
            }
            return update;
        }
        return invokeI.booleanValue;
    }
}
