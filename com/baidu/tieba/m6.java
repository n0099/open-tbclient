package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.c4;
import com.baidu.tieba.p7;
import com.baidu.tieba.v3;
import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m6 implements i7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public x7 a;
    public c4 b;
    public float c;
    public final x7 d;

    /* loaded from: classes4.dex */
    public class a extends p7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6 n;

        public a(m6 m6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = m6Var;
        }

        @Override // com.baidu.tieba.p7
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) {
                return str.equals("parent");
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.p7
        public void i(Object obj, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, jsonValue) == null) {
                if (jsonValue.s("parent")) {
                    String str = (String) l("parent", String.class, jsonValue);
                    Class<?> cls = obj.getClass();
                    do {
                        try {
                            c(this.n.h(str, cls), obj);
                        } catch (GdxRuntimeException unused) {
                            cls = cls.getSuperclass();
                            if (cls == Object.class) {
                                SerializationException serializationException = new SerializationException("Unable to find parent resource with name: " + str);
                                serializationException.addTrace(jsonValue.f.Q());
                                throw serializationException;
                            }
                        }
                    } while (cls == Object.class);
                    SerializationException serializationException2 = new SerializationException("Unable to find parent resource with name: " + str);
                    serializationException2.addTrace(jsonValue.f.Q());
                    throw serializationException2;
                }
                super.i(obj, jsonValue);
            }
        }

        @Override // com.baidu.tieba.p7
        public Object k(Class cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.D() && !u8.f(CharSequence.class, cls)) {
                    return this.n.h(jsonValue.j(), cls);
                }
                return super.k(cls, cls2, jsonValue);
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends p7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6 a;
        public final /* synthetic */ m6 b;

        public b(m6 m6Var, m6 m6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6Var, m6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m6Var;
            this.a = m6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p7.d
        /* renamed from: b */
        public m6 a(p7 p7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p7Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = p7Var.e(jsonValue2.G());
                        if (e == null) {
                            e = u8.a(jsonValue2.G());
                        }
                        c(p7Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (m6) invokeLLL.objValue;
        }

        public final void c(p7 p7Var, Class cls, JsonValue jsonValue) {
            Class cls2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, p7Var, cls, jsonValue) == null) {
                if (cls == f.class) {
                    cls2 = w6.class;
                } else {
                    cls2 = cls;
                }
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = p7Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != w6.class && u8.f(w6.class, cls2)) {
                                this.b.f(jsonValue2.e, j, w6.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + u8.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends p7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k3 a;
        public final /* synthetic */ m6 b;

        public c(m6 m6Var, k3 k3Var, m6 m6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6Var, k3Var, m6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k3Var;
            this.b = m6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p7.d
        /* renamed from: b */
        public v3 a(p7 p7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            v3 v3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p7Var, jsonValue, cls)) == null) {
                String str = (String) p7Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) p7Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) p7Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) p7Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                k3 a = this.a.i().a(str);
                if (!a.c()) {
                    a = f1.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        b7 m = this.b.m(h);
                        if (m != null) {
                            v3Var = new v3(new v3.a(a, bool.booleanValue()), m, true);
                        } else {
                            d4 d4Var = (d4) this.b.r(h, d4.class);
                            if (d4Var != null) {
                                v3Var = new v3(a, d4Var, bool.booleanValue());
                            } else {
                                k3 i = a.i();
                                k3 a2 = i.a(h + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX);
                                if (a2.c()) {
                                    v3Var = new v3(a, a2, bool.booleanValue());
                                } else {
                                    v3Var = new v3(a, bool.booleanValue());
                                }
                            }
                        }
                        v3Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            v3Var.f().h(intValue / v3Var.a());
                        }
                        return v3Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (v3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends p7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6 a;

        public d(m6 m6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p7.d
        /* renamed from: b */
        public l3 a(p7 p7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p7Var, jsonValue, cls)) == null) {
                if (jsonValue.D()) {
                    return (l3) this.a.h(jsonValue.j(), l3.class);
                }
                String str = (String) p7Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return l3.h(str);
                }
                return new l3(((Float) p7Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) p7Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) p7Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) p7Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (l3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends p7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m6 a;

        public e(m6 m6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m6Var;
        }

        @Override // com.baidu.tieba.p7.d
        public Object a(p7 p7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, p7Var, jsonValue, cls)) == null) {
                String str = (String) p7Var.l("name", String.class, jsonValue);
                l3 l3Var = (l3) p7Var.l("color", l3.class, jsonValue);
                if (l3Var != null) {
                    w6 q = this.a.q(str, l3Var);
                    if (q instanceof v6) {
                        ((v6) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + l3Var + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    return q;
                }
                throw new SerializationException("TintedDrawable missing color: " + jsonValue);
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448309604, "Lcom/baidu/tieba/m6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448309604, "Lcom/baidu/tieba/m6;");
                return;
            }
        }
        e = new Class[]{v3.class, l3.class, f.class, x6.class, y6.class, z6.class, a7.class, d6.class, e6.class, f6.class, g6.class, h6.class, i6.class, j6.class, k6.class, l6.class, n6.class, o6.class, p6.class, q6.class, r6.class, s6.class, t6.class, u6.class};
    }

    public m6() {
        Class[] clsArr;
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
        this.a = new x7();
        this.c = 1.0f;
        this.d = new x7(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
    }

    @Override // com.baidu.tieba.i7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c4 c4Var = this.b;
            if (c4Var != null) {
                c4Var.dispose();
            }
            x7.e n = this.a.n();
            n.c();
            while (n.hasNext()) {
                x7.e n2 = ((x7) n.next()).n();
                n2.c();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof i7) {
                        ((i7) next).dispose();
                    }
                }
            }
        }
    }

    public m6(c4 c4Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c4Var};
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
        this.c = 1.0f;
        this.d = new x7(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = c4Var;
        g(c4Var);
    }

    public d4 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            d4 d4Var = (d4) r(str, d4.class);
            if (d4Var != null) {
                return d4Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                d4 d4Var2 = new d4(texture);
                f(str, d4Var2, d4.class);
                return d4Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (d4) invokeL.objValue;
    }

    public b7 m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            d4 d4Var = (d4) r(str + "_0", d4.class);
            if (d4Var != null) {
                b7 b7Var = new b7();
                int i = 1;
                while (d4Var != null) {
                    b7Var.a(d4Var);
                    d4Var = (d4) r(str + "_" + i, d4.class);
                    i++;
                }
                return b7Var;
            }
            return null;
        }
        return (b7) invokeL.objValue;
    }

    public void s(w6 w6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, w6Var) == null) {
            w6Var.b(w6Var.l() * this.c);
            w6Var.c(w6Var.g() * this.c);
            w6Var.d(w6Var.e() * this.c);
            w6Var.f(w6Var.i() * this.c);
            w6Var.j(w6Var.a() * this.c);
            w6Var.h(w6Var.k() * this.c);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    public w6 q(String str, l3 l3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, l3Var)) == null) {
            return p(i(str), l3Var);
        }
        return (w6) invokeLL.objValue;
    }

    public void f(String str, Object obj, Class cls) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str != null) {
                if (obj != null) {
                    x7 x7Var = (x7) this.a.c(cls);
                    if (x7Var == null) {
                        if (cls != d4.class && cls != w6.class && cls != b4.class) {
                            i = 64;
                        } else {
                            i = 256;
                        }
                        x7Var = new x7(i);
                        this.a.i(cls, x7Var);
                    }
                    x7Var.i(str, obj);
                    return;
                }
                throw new IllegalArgumentException("resource cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
    }

    public void g(c4 c4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c4Var) == null) {
            b7 g = c4Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                c4.a aVar = (c4.a) g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, d4.class);
            }
        }
    }

    public Object h(String str, Class cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == w6.class) {
                        return i(str);
                    }
                    if (cls == d4.class) {
                        return l(str);
                    }
                    if (cls == x3.class) {
                        return k(str);
                    }
                    if (cls == b4.class) {
                        return n(str);
                    }
                    x7 x7Var = (x7) this.a.c(cls);
                    if (x7Var != null) {
                        Object c2 = x7Var.c(str);
                        if (c2 != null) {
                            return c2;
                        }
                        throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                    }
                    throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return invokeLL.objValue;
    }

    public w6 i(String str) {
        InterceptResult invokeL;
        w6 y6Var;
        w6 y6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            w6 w6Var = (w6) r(str, w6.class);
            if (w6Var != null) {
                return w6Var;
            }
            try {
                d4 l = l(str);
                if (l instanceof c4.a) {
                    c4.a aVar = (c4.a) l;
                    if (aVar.k("split") != null) {
                        y6Var2 = new x6(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        y6Var2 = new y6(n(str));
                    }
                    w6Var = y6Var2;
                }
                if (w6Var == null) {
                    w6 z6Var = new z6(l);
                    try {
                        if (this.c != 1.0f) {
                            s(z6Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    w6Var = z6Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (w6Var == null) {
                x3 x3Var = (x3) r(str, x3.class);
                if (x3Var != null) {
                    y6Var = new x6(x3Var);
                } else {
                    b4 b4Var = (b4) r(str, b4.class);
                    if (b4Var != null) {
                        y6Var = new y6(b4Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                w6Var = y6Var;
            }
            if (w6Var instanceof v6) {
                ((v6) w6Var).n(str);
            }
            f(str, w6Var, w6.class);
            return w6Var;
        }
        return (w6) invokeL.objValue;
    }

    public p7 j(k3 k3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k3Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(m6.class, new b(this, this));
            aVar.o(v3.class, new c(this, k3Var, this));
            aVar.o(l3.class, new d(this));
            aVar.o(f.class, new e(this));
            x7.a it = this.d.iterator();
            while (it.hasNext()) {
                x7.b bVar = (x7.b) it.next();
                aVar.a((String) bVar.a, (Class) bVar.b);
            }
            return aVar;
        }
        return (p7) invokeL.objValue;
    }

    public x3 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            x3 x3Var = (x3) r(str, x3.class);
            if (x3Var != null) {
                return x3Var;
            }
            try {
                d4 l = l(str);
                if ((l instanceof c4.a) && (k = ((c4.a) l).k("split")) != null) {
                    x3Var = new x3(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((c4.a) l).k("pad");
                    if (k2 != null) {
                        x3Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (x3Var == null) {
                    x3Var = new x3(l);
                }
                if (this.c != 1.0f) {
                    x3Var.m(this.c, this.c);
                }
                f(str, x3Var, x3.class);
                return x3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (x3) invokeL.objValue;
    }

    public b4 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            b4 b4Var = (b4) r(str, b4.class);
            if (b4Var != null) {
                return b4Var;
            }
            try {
                d4 l = l(str);
                if (l instanceof c4.a) {
                    c4.a aVar = (c4.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        b4Var = new c4.b(aVar);
                    }
                }
                if (b4Var == null) {
                    b4Var = new b4(l);
                }
                if (this.c != 1.0f) {
                    b4Var.z(b4Var.n() * this.c, b4Var.k() * this.c);
                }
                f(str, b4Var, b4.class);
                return b4Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (b4) invokeL.objValue;
    }

    public void o(k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, k3Var) == null) {
            try {
                j(k3Var).d(m6.class, k3Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + k3Var, e2);
            }
        }
    }

    public w6 p(w6 w6Var, l3 l3Var) {
        InterceptResult invokeLL;
        w6 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, w6Var, l3Var)) == null) {
            if (w6Var instanceof z6) {
                p = ((z6) w6Var).p(l3Var);
            } else if (w6Var instanceof x6) {
                p = ((x6) w6Var).q(l3Var);
            } else if (w6Var instanceof y6) {
                p = ((y6) w6Var).p(l3Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + w6Var.getClass());
            }
            if (p instanceof v6) {
                v6 v6Var = (v6) p;
                if (w6Var instanceof v6) {
                    v6Var.n(((v6) w6Var).m() + " (" + l3Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    v6Var.n(" (" + l3Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (w6) invokeLL.objValue;
    }

    public Object r(String str, Class cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    x7 x7Var = (x7) this.a.c(cls);
                    if (x7Var == null) {
                        return null;
                    }
                    return x7Var.c(str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return invokeLL.objValue;
    }
}
