package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.a7;
import com.baidu.tieba.k1;
import com.baidu.tieba.w7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes5.dex */
public class m1 implements h7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w7<Class, w7<String, a>> a;
    public final w7<String, Class> b;
    public final w7<String, a7<String>> c;
    public final x7<String> d;
    public final w7<Class, w7<String, n1>> e;
    public final a7<i1> f;
    public final o8 g;
    public final a7<l1> h;
    public j1 i;
    public int j;
    public int k;
    public int l;
    public r7 m;

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
    public m1() {
        this(new d2());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((r1) newInitContext.callArgs[0]);
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

    public void B(i1 i1Var, RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i1Var, runtimeException) == null) {
            throw runtimeException;
        }
    }

    public synchronized void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                String replace = str.replace('\\', WebvttCueParser.CHAR_SLASH);
                if (this.h.b > 0) {
                    l1 f = this.h.f();
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
                    i1 i2 = this.f.i(i);
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
                        if (c2.a instanceof h7) {
                            ((h7) c2.a).dispose();
                        }
                        this.b.k(replace);
                        this.a.c(c).k(replace);
                    } else {
                        this.m.e("Unload (decrement): " + replace);
                    }
                    a7<String> c3 = this.c.c(replace);
                    if (c3 != null) {
                        a7.b<String> it = c3.iterator();
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
        k1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return invokeV.booleanValue;
        }
        l1 peek = this.h.peek();
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
                    i1 i1Var = peek.b;
                    a(i1Var.a, i1Var.b, peek.k);
                    i1 i1Var2 = peek.b;
                    k1 k1Var = i1Var2.c;
                    if (k1Var != null && (aVar = k1Var.a) != null) {
                        aVar.a(this, i1Var2.a, i1Var2.b);
                    }
                    long b = m8.b();
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
            w7<String, a> c = this.a.c(cls);
            if (c == null) {
                c = new w7<>();
                this.a.i(cls, c);
            }
            a aVar = new a();
            aVar.a = t;
            c.i(str, aVar);
        }
    }

    @Override // com.baidu.tieba.h7
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

    public final void f(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, i1Var) == null) {
            n1 o = o(i1Var.b, i1Var.a);
            if (o != null) {
                this.h.a(new l1(this, i1Var, o, this.g));
                this.l++;
                return;
            }
            throw new GdxRuntimeException("No loader for type: " + t8.e(i1Var.b));
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f.clear();
                while (!update()) {
                }
                v7 v7Var = new v7();
                while (this.b.a > 0) {
                    v7Var.clear();
                    a7<String> d = this.b.f().d();
                    a7.b<String> it = d.iterator();
                    while (it.hasNext()) {
                        a7<String> c = this.c.c(it.next());
                        if (c != null) {
                            a7.b<String> it2 = c.iterator();
                            while (it2.hasNext()) {
                                v7Var.d(it2.next(), 0, 1);
                            }
                        }
                    }
                    a7.b<String> it3 = d.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        if (v7Var.c(next, 0) == 0) {
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
                r8.a();
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
                w7<String, a> c2 = this.a.c(cls);
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
        w7<String, a> c;
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
                w7.c<Class> f = this.a.f();
                f.c();
                while (f.hasNext()) {
                    w7.a<String, a> it = this.a.c(f.next()).iterator();
                    while (it.hasNext()) {
                        w7.b next = it.next();
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

    public synchronized a7<String> n(String str) {
        InterceptResult invokeL;
        a7<String> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                c = this.c.c(str);
            }
            return c;
        }
        return (a7) invokeL.objValue;
    }

    public <T> n1 o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            w7<String, n1> c = this.e.c(cls);
            n1 n1Var = null;
            if (c != null && c.a >= 1) {
                if (str == null) {
                    return c.c("");
                }
                int i = -1;
                w7.a<String, n1> b = c.b();
                b.c();
                while (b.hasNext()) {
                    w7.b next = b.next();
                    if (((String) next.a).length() > i && str.endsWith((String) next.a)) {
                        n1Var = (n1) next.b;
                        i = ((String) next.a).length();
                    }
                }
            }
            return n1Var;
        }
        return (n1) invokeLL.objValue;
    }

    public r7 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : (r7) invokeV.objValue;
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
                l1 pop = this.h.pop();
                i1 i1Var = pop.b;
                if (pop.g && pop.h != null) {
                    a7.b<i1> it = pop.h.iterator();
                    while (it.hasNext()) {
                        C(it.next().a);
                    }
                }
                this.h.clear();
                j1 j1Var = this.i;
                if (j1Var != null) {
                    j1Var.a(i1Var, th);
                    return;
                }
                throw new GdxRuntimeException(th);
            }
            throw new GdxRuntimeException(th);
        }
    }

    public final void s(String str) {
        a7<String> c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (c = this.c.c(str)) == null) {
            return;
        }
        a7.b<String> it = c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.a.c(this.b.c(next)).c(next).b++;
            s(next);
        }
    }

    public synchronized void t(String str, a7<i1> a7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, a7Var) == null) {
            synchronized (this) {
                x7<String> x7Var = this.d;
                a7.b<i1> it = a7Var.iterator();
                while (it.hasNext()) {
                    i1 next = it.next();
                    if (!x7Var.contains(next.a)) {
                        x7Var.add(next.a);
                        u(str, next);
                    }
                }
                x7Var.b(32);
            }
        }
    }

    public final synchronized void u(String str, i1 i1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, i1Var) == null) {
            synchronized (this) {
                a7<String> c = this.c.c(str);
                if (c == null) {
                    c = new a7<>();
                    this.c.i(str, c);
                }
                c.a(i1Var.a);
                if (v(i1Var.a)) {
                    r7 r7Var = this.m;
                    r7Var.a("Dependency already loaded: " + i1Var);
                    a c2 = this.a.c(this.b.c(i1Var.a)).c(i1Var.a);
                    c2.b = c2.b + 1;
                    s(i1Var.a);
                } else {
                    r7 r7Var2 = this.m;
                    r7Var2.e("Loading dependency: " + i1Var);
                    f(i1Var);
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

    public synchronized <T> void w(String str, Class<T> cls, k1<T> k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, cls, k1Var) == null) {
            synchronized (this) {
                if (o(cls, str) != null) {
                    if (this.f.b == 0) {
                        this.j = 0;
                        this.k = 0;
                        this.l = 0;
                    }
                    for (int i = 0; i < this.f.b; i++) {
                        i1 i1Var = this.f.get(i);
                        if (i1Var.a.equals(str) && !i1Var.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + t8.e(cls) + ", found: " + t8.e(i1Var.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i2 = 0; i2 < this.h.b; i2++) {
                        i1 i1Var2 = this.h.get(i2).b;
                        if (i1Var2.a.equals(str) && !i1Var2.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + t8.e(cls) + ", found: " + t8.e(i1Var2.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class c = this.b.c(str);
                    if (c != null && !c.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + t8.e(cls) + ", found: " + t8.e(c) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.k++;
                    i1 i1Var3 = new i1(str, cls, k1Var);
                    this.f.a(i1Var3);
                    this.m.a("Queued: " + i1Var3);
                } else {
                    throw new GdxRuntimeException("No loader for type: " + t8.e(cls));
                }
            }
        }
    }

    public final void x() {
        k1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            i1 i = this.f.i(0);
            if (v(i.a)) {
                this.m.a("Already loaded: " + i);
                a c = this.a.c(this.b.c(i.a)).c(i.a);
                c.b = c.b + 1;
                s(i.a);
                k1 k1Var = i.c;
                if (k1Var != null && (aVar = k1Var.a) != null) {
                    aVar.a(this, i.a, i.b);
                }
                this.j++;
                return;
            }
            this.m.e("Loading: " + i);
            f(i);
        }
    }

    public synchronized <T, P extends k1<T>> void y(Class<T> cls, n1<T, P> n1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, cls, n1Var) == null) {
            synchronized (this) {
                z(cls, null, n1Var);
            }
        }
    }

    public synchronized <T, P extends k1<T>> void z(Class<T> cls, String str, n1<T, P> n1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, cls, str, n1Var) == null) {
            synchronized (this) {
                if (cls == null) {
                    throw new IllegalArgumentException("type cannot be null.");
                }
                if (n1Var != null) {
                    r7 r7Var = this.m;
                    r7Var.a("Loader set: " + t8.e(cls) + LoadErrorCode.TOKEN_NEXT + t8.e(n1Var.getClass()));
                    w7<String, n1> c = this.e.c(cls);
                    if (c == null) {
                        w7<Class, w7<String, n1>> w7Var = this.e;
                        w7<String, n1> w7Var2 = new w7<>();
                        w7Var.i(cls, w7Var2);
                        c = w7Var2;
                    }
                    if (str == null) {
                        str = "";
                    }
                    c.i(str, n1Var);
                } else {
                    throw new IllegalArgumentException("loader cannot be null.");
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m1(r1 r1Var) {
        this(r1Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((r1) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public m1(r1 r1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r1Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new w7<>();
        this.b = new w7<>();
        this.c = new w7<>();
        this.d = new x7<>();
        this.e = new w7<>();
        this.f = new a7<>();
        this.h = new a7<>();
        this.m = new r7("AssetManager", 0);
        if (z) {
            y(u3.class, new p1(r1Var));
            y(e2.class, new u1(r1Var));
            y(Pixmap.class, new w1(r1Var));
            y(f2.class, new z1(r1Var));
            y(b4.class, new b2(r1Var));
            y(Texture.class, new c2(r1Var));
            y(l6.class, new y1(r1Var));
            y(x3.class, new v1(r1Var));
            y(f5.class, new g5(r1Var));
            y(y3.class, new z3(r1Var));
            y(k7.class, new s1(r1Var));
            z(g4.class, ".g3dj", new l4(new p7(), r1Var));
            z(g4.class, ".g3db", new l4(new n8(), r1Var));
            z(g4.class, ".obj", new n4(r1Var));
            y(x5.class, new x1(r1Var));
            y(Cubemap.class, new q1(r1Var));
        }
        this.g = new o8(1, "AssetManager");
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        boolean update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            long a2 = m8.a() + i;
            while (true) {
                update = update();
                if (update || m8.a() > a2) {
                    break;
                }
                r8.a();
            }
            return update;
        }
        return invokeI.booleanValue;
    }
}
