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
    public final x7 a;
    public final x7 b;
    public final x7 c;
    public final y7 d;
    public final x7 e;
    public final b7 f;
    public final p8 g;
    public final b7 h;
    public k1 i;
    public int j;
    public int k;
    public int l;
    public s7 m;

    /* loaded from: classes5.dex */
    public class a {
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

    public s7 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.m;
        }
        return (s7) invokeV.objValue;
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
        this.a = new x7();
        this.b = new x7();
        this.c = new x7();
        this.d = new y7();
        this.e = new x7();
        this.f = new b7();
        this.h = new b7();
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

    public synchronized void A(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            synchronized (this) {
                Class cls = (Class) this.b.c(str);
                if (cls != null) {
                    ((a) ((x7) this.a.c(cls)).c(str)).b = i;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
        }
    }

    public synchronized void t(String str, b7 b7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, b7Var) == null) {
            synchronized (this) {
                y7 y7Var = this.d;
                b7.b it = b7Var.iterator();
                while (it.hasNext()) {
                    j1 j1Var = (j1) it.next();
                    if (!y7Var.contains(j1Var.a)) {
                        y7Var.add(j1Var.a);
                        u(str, j1Var);
                    }
                }
                y7Var.b(32);
            }
        }
    }

    public void B(j1 j1Var, RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j1Var, runtimeException) == null) {
            throw runtimeException;
        }
    }

    public synchronized Object j(String str, Class cls) {
        InterceptResult invokeLL;
        Object k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, cls)) == null) {
            synchronized (this) {
                k = k(str, cls, true);
            }
            return k;
        }
        return invokeLL.objValue;
    }

    public synchronized void y(Class cls, o1 o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, cls, o1Var) == null) {
            synchronized (this) {
                z(cls, null, o1Var);
            }
        }
    }

    public synchronized void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                String replace = str.replace('\\', WebvttCueParser.CHAR_SLASH);
                if (this.h.b > 0) {
                    m1 m1Var = (m1) this.h.f();
                    if (m1Var.b.a.equals(replace)) {
                        this.m.e("Unload (from tasks): " + replace);
                        m1Var.l = true;
                        m1Var.e();
                        return;
                    }
                }
                Class cls = (Class) this.b.c(replace);
                int i = 0;
                while (true) {
                    if (i < this.f.b) {
                        if (((j1) this.f.get(i)).a.equals(replace)) {
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
                    j1 j1Var = (j1) this.f.i(i);
                    this.m.e("Unload (from queue): " + replace);
                    if (cls != null && j1Var.c != null && j1Var.c.a != null) {
                        j1Var.c.a.a(this, j1Var.a, j1Var.b);
                    }
                } else if (cls != null) {
                    a aVar = (a) ((x7) this.a.c(cls)).c(replace);
                    int i2 = aVar.b - 1;
                    aVar.b = i2;
                    if (i2 <= 0) {
                        this.m.e("Unload (dispose): " + replace);
                        if (aVar.a instanceof i7) {
                            ((i7) aVar.a).dispose();
                        }
                        this.b.k(replace);
                        ((x7) this.a.c(cls)).k(replace);
                    } else {
                        this.m.e("Unload (decrement): " + replace);
                    }
                    b7 b7Var = (b7) this.c.c(replace);
                    if (b7Var != null) {
                        b7.b it = b7Var.iterator();
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            if (v(str2)) {
                                C(str2);
                            }
                        }
                    }
                    if (aVar.b <= 0) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            m1 m1Var = (m1) this.h.peek();
            try {
                if (!m1Var.l) {
                    if (!m1Var.update()) {
                        z = false;
                        if (z) {
                            return false;
                        }
                        if (this.h.b == 1) {
                            this.j++;
                            this.l = 0;
                        }
                        this.h.pop();
                        if (m1Var.l) {
                            return true;
                        }
                        j1 j1Var = m1Var.b;
                        a(j1Var.a, j1Var.b, m1Var.k);
                        j1 j1Var2 = m1Var.b;
                        l1 l1Var = j1Var2.c;
                        if (l1Var != null && (aVar = l1Var.a) != null) {
                            aVar.a(this, j1Var2.a, j1Var2.b);
                        }
                        long b = n8.b();
                        this.m.a("Loaded: " + (((float) (b - m1Var.e)) / 1000000.0f) + "ms " + m1Var.b);
                        return true;
                    }
                }
                z = true;
                if (z) {
                }
            } catch (RuntimeException e) {
                m1Var.l = true;
                B(m1Var.b, e);
                throw null;
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    public final void x() {
        l1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            j1 j1Var = (j1) this.f.i(0);
            if (v(j1Var.a)) {
                this.m.a("Already loaded: " + j1Var);
                a aVar2 = (a) ((x7) this.a.c((Class) this.b.c(j1Var.a))).c(j1Var.a);
                aVar2.b = aVar2.b + 1;
                s(j1Var.a);
                l1 l1Var = j1Var.c;
                if (l1Var != null && (aVar = l1Var.a) != null) {
                    aVar.a(this, j1Var.a, j1Var.b);
                }
                this.j++;
                return;
            }
            this.m.e("Loading: " + j1Var);
            f(j1Var);
        }
    }

    public void a(String str, Class cls, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, cls, obj) == null) {
            this.b.i(str, cls);
            x7 x7Var = (x7) this.a.c(cls);
            if (x7Var == null) {
                x7Var = new x7();
                this.a.i(cls, x7Var);
            }
            a aVar = new a();
            aVar.a = obj;
            x7Var.i(str, aVar);
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000e, B:8:0x0014, B:9:0x0026, B:11:0x002c, B:13:0x003a, B:15:0x0040), top: B:28:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String m(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            synchronized (this) {
                x7.c f = this.a.f();
                f.c();
                while (f.hasNext()) {
                    x7.a it = ((x7) this.a.c((Class) f.next())).iterator();
                    while (it.hasNext()) {
                        x7.b bVar = (x7.b) it.next();
                        Object obj2 = ((a) bVar.b).a;
                        if (obj2 == obj || obj.equals(obj2)) {
                            return (String) bVar.a;
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
                Class cls = (Class) this.b.c(str);
                if (cls != null) {
                    i = ((a) ((x7) this.a.c(cls)).c(str)).b;
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
                m1 m1Var = (m1) this.h.pop();
                j1 j1Var = m1Var.b;
                if (m1Var.g && m1Var.h != null) {
                    b7.b it = m1Var.h.iterator();
                    while (it.hasNext()) {
                        C(((j1) it.next()).a);
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
        b7 b7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, str) != null) || (b7Var = (b7) this.c.c(str)) == null) {
            return;
        }
        b7.b it = b7Var.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            ((a) ((x7) this.a.c((Class) this.b.c(str2))).c(str2)).b++;
            s(str2);
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
                    b7 d = this.b.f().d();
                    b7.b it = d.iterator();
                    while (it.hasNext()) {
                        b7 b7Var = (b7) this.c.c((String) it.next());
                        if (b7Var != null) {
                            b7.b it2 = b7Var.iterator();
                            while (it2.hasNext()) {
                                w7Var.d((String) it2.next(), 0, 1);
                            }
                        }
                    }
                    b7.b it3 = d.iterator();
                    while (it3.hasNext()) {
                        String str = (String) it3.next();
                        if (w7Var.c(str, 0) == 0) {
                            C(str);
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

    public synchronized Object i(String str) {
        InterceptResult invokeL;
        Object l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                l = l(str, true);
            }
            return l;
        }
        return invokeL.objValue;
    }

    public synchronized b7 n(String str) {
        InterceptResult invokeL;
        b7 b7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                b7Var = (b7) this.c.c(str);
            }
            return b7Var;
        }
        return (b7) invokeL.objValue;
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

    public synchronized Object k(String str, Class cls, boolean z) {
        InterceptResult invokeLLZ;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, cls, z)) == null) {
            synchronized (this) {
                x7 x7Var = (x7) this.a.c(cls);
                if (x7Var != null && (aVar = (a) x7Var.c(str)) != null) {
                    return aVar.a;
                }
                if (!z) {
                    return null;
                }
                throw new GdxRuntimeException("Asset not loaded: " + str);
            }
        }
        return invokeLLZ.objValue;
    }

    public synchronized Object l(String str, boolean z) {
        InterceptResult invokeLZ;
        x7 x7Var;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            synchronized (this) {
                Class cls = (Class) this.b.c(str);
                if (cls != null && (x7Var = (x7) this.a.c(cls)) != null && (aVar = (a) x7Var.c(str)) != null) {
                    return aVar.a;
                }
                if (!z) {
                    return null;
                }
                throw new GdxRuntimeException("Asset not loaded: " + str);
            }
        }
        return invokeLZ.objValue;
    }

    public o1 o(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            x7 x7Var = (x7) this.e.c(cls);
            o1 o1Var = null;
            if (x7Var != null && x7Var.a >= 1) {
                if (str == null) {
                    return (o1) x7Var.c("");
                }
                int i = -1;
                x7.a b = x7Var.b();
                b.c();
                while (b.hasNext()) {
                    x7.b bVar = (x7.b) b.next();
                    if (((String) bVar.a).length() > i && str.endsWith((String) bVar.a)) {
                        o1Var = (o1) bVar.b;
                        i = ((String) bVar.a).length();
                    }
                }
            }
            return o1Var;
        }
        return (o1) invokeLL.objValue;
    }

    public final synchronized void u(String str, j1 j1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, j1Var) == null) {
            synchronized (this) {
                b7 b7Var = (b7) this.c.c(str);
                if (b7Var == null) {
                    b7Var = new b7();
                    this.c.i(str, b7Var);
                }
                b7Var.a(j1Var.a);
                if (v(j1Var.a)) {
                    s7 s7Var = this.m;
                    s7Var.a("Dependency already loaded: " + j1Var);
                    a aVar = (a) ((x7) this.a.c((Class) this.b.c(j1Var.a))).c(j1Var.a);
                    aVar.b = aVar.b + 1;
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
                    if (this.f.b != 0) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void w(String str, Class cls, l1 l1Var) {
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
                        j1 j1Var = (j1) this.f.get(i);
                        if (j1Var.a.equals(str) && !j1Var.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + u8.e(cls) + ", found: " + u8.e(j1Var.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i2 = 0; i2 < this.h.b; i2++) {
                        j1 j1Var2 = ((m1) this.h.get(i2)).b;
                        if (j1Var2.a.equals(str) && !j1Var2.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + u8.e(cls) + ", found: " + u8.e(j1Var2.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class cls2 = (Class) this.b.c(str);
                    if (cls2 != null && !cls2.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + u8.e(cls) + ", found: " + u8.e(cls2) + SmallTailInfo.EMOTION_SUFFIX);
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

    public synchronized void z(Class cls, String str, o1 o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, cls, str, o1Var) == null) {
            synchronized (this) {
                if (cls != null) {
                    if (o1Var != null) {
                        s7 s7Var = this.m;
                        s7Var.a("Loader set: " + u8.e(cls) + LoadErrorCode.TOKEN_NEXT + u8.e(o1Var.getClass()));
                        x7 x7Var = (x7) this.e.c(cls);
                        if (x7Var == null) {
                            x7 x7Var2 = this.e;
                            x7 x7Var3 = new x7();
                            x7Var2.i(cls, x7Var3);
                            x7Var = x7Var3;
                        }
                        if (str == null) {
                            str = "";
                        }
                        x7Var.i(str, o1Var);
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
