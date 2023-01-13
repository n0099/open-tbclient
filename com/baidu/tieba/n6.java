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
import com.baidu.tieba.d4;
import com.baidu.tieba.q7;
import com.baidu.tieba.w3;
import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n6 implements j7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public y7<Class, y7<String, Object>> a;
    public d4 b;
    public float c;
    public final y7<String, Class> d;

    /* loaded from: classes5.dex */
    public class a extends q7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6 n;

        public a(n6 n6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = n6Var;
        }

        @Override // com.baidu.tieba.q7
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) {
                return str.equals("parent");
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.q7
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

        @Override // com.baidu.tieba.q7
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.D() && !v8.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.j(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends q7.b<n6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6 a;
        public final /* synthetic */ n6 b;

        public b(n6 n6Var, n6 n6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6Var, n6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n6Var;
            this.a = n6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q7.d
        /* renamed from: b */
        public n6 a(q7 q7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q7Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = q7Var.e(jsonValue2.G());
                        if (e == null) {
                            e = v8.a(jsonValue2.G());
                        }
                        c(q7Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (n6) invokeLLL.objValue;
        }

        public final void c(q7 q7Var, Class cls, JsonValue jsonValue) {
            Class cls2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, q7Var, cls, jsonValue) == null) {
                if (cls == f.class) {
                    cls2 = x6.class;
                } else {
                    cls2 = cls;
                }
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = q7Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != x6.class && v8.f(x6.class, cls2)) {
                                this.b.f(jsonValue2.e, j, x6.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + v8.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends q7.b<w3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l3 a;
        public final /* synthetic */ n6 b;

        public c(n6 n6Var, l3 l3Var, n6 n6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6Var, l3Var, n6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l3Var;
            this.b = n6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q7.d
        /* renamed from: b */
        public w3 a(q7 q7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            w3 w3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q7Var, jsonValue, cls)) == null) {
                String str = (String) q7Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) q7Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) q7Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) q7Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                l3 a = this.a.i().a(str);
                if (!a.c()) {
                    a = g1.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        c7<e4> m = this.b.m(h);
                        if (m != null) {
                            w3Var = new w3(new w3.a(a, bool.booleanValue()), m, true);
                        } else {
                            e4 e4Var = (e4) this.b.r(h, e4.class);
                            if (e4Var != null) {
                                w3Var = new w3(a, e4Var, bool.booleanValue());
                            } else {
                                l3 i = a.i();
                                l3 a2 = i.a(h + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX);
                                if (a2.c()) {
                                    w3Var = new w3(a, a2, bool.booleanValue());
                                } else {
                                    w3Var = new w3(a, bool.booleanValue());
                                }
                            }
                        }
                        w3Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            w3Var.f().h(intValue / w3Var.a());
                        }
                        return w3Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (w3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends q7.b<m3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6 a;

        public d(n6 n6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q7.d
        /* renamed from: b */
        public m3 a(q7 q7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q7Var, jsonValue, cls)) == null) {
                if (jsonValue.D()) {
                    return (m3) this.a.h(jsonValue.j(), m3.class);
                }
                String str = (String) q7Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return m3.h(str);
                }
                return new m3(((Float) q7Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) q7Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) q7Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) q7Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (m3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e extends q7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6 a;

        public e(n6 n6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6Var;
        }

        @Override // com.baidu.tieba.q7.d
        public Object a(q7 q7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, q7Var, jsonValue, cls)) == null) {
                String str = (String) q7Var.l("name", String.class, jsonValue);
                m3 m3Var = (m3) q7Var.l("color", m3.class, jsonValue);
                if (m3Var != null) {
                    x6 q = this.a.q(str, m3Var);
                    if (q instanceof w6) {
                        ((w6) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + m3Var + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    return q;
                }
                throw new SerializationException("TintedDrawable missing color: " + jsonValue);
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448310565, "Lcom/baidu/tieba/n6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448310565, "Lcom/baidu/tieba/n6;");
                return;
            }
        }
        e = new Class[]{w3.class, m3.class, f.class, y6.class, z6.class, a7.class, b7.class, e6.class, f6.class, g6.class, h6.class, i6.class, j6.class, k6.class, l6.class, m6.class, o6.class, p6.class, q6.class, r6.class, s6.class, t6.class, u6.class, v6.class};
    }

    public n6() {
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
        this.a = new y7<>();
        this.c = 1.0f;
        this.d = new y7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
    }

    @Override // com.baidu.tieba.j7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d4 d4Var = this.b;
            if (d4Var != null) {
                d4Var.dispose();
            }
            y7.e<y7<String, Object>> n = this.a.n();
            n.c();
            while (n.hasNext()) {
                y7.e<Object> n2 = n.next().n();
                n2.c();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof j7) {
                        ((j7) next).dispose();
                    }
                }
            }
        }
    }

    public n6(d4 d4Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d4Var};
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
        this.c = 1.0f;
        this.d = new y7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = d4Var;
        g(d4Var);
    }

    public e4 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            e4 e4Var = (e4) r(str, e4.class);
            if (e4Var != null) {
                return e4Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                e4 e4Var2 = new e4(texture);
                f(str, e4Var2, e4.class);
                return e4Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (e4) invokeL.objValue;
    }

    public c7<e4> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            e4 e4Var = (e4) r(str + "_0", e4.class);
            if (e4Var != null) {
                c7<e4> c7Var = new c7<>();
                int i = 1;
                while (e4Var != null) {
                    c7Var.a(e4Var);
                    e4Var = (e4) r(str + "_" + i, e4.class);
                    i++;
                }
                return c7Var;
            }
            return null;
        }
        return (c7) invokeL.objValue;
    }

    public void s(x6 x6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, x6Var) == null) {
            x6Var.b(x6Var.l() * this.c);
            x6Var.c(x6Var.g() * this.c);
            x6Var.d(x6Var.e() * this.c);
            x6Var.f(x6Var.i() * this.c);
            x6Var.j(x6Var.a() * this.c);
            x6Var.h(x6Var.k() * this.c);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    public x6 q(String str, m3 m3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, m3Var)) == null) {
            return p(i(str), m3Var);
        }
        return (x6) invokeLL.objValue;
    }

    public void f(String str, Object obj, Class cls) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str != null) {
                if (obj != null) {
                    y7<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        if (cls != e4.class && cls != x6.class && cls != c4.class) {
                            i = 64;
                        } else {
                            i = 256;
                        }
                        c2 = new y7<>(i);
                        this.a.i(cls, c2);
                    }
                    c2.i(str, obj);
                    return;
                }
                throw new IllegalArgumentException("resource cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
    }

    public void g(d4 d4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d4Var) == null) {
            c7<d4.a> g = d4Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                d4.a aVar = g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, e4.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == x6.class) {
                        return (T) i(str);
                    }
                    if (cls == e4.class) {
                        return (T) l(str);
                    }
                    if (cls == y3.class) {
                        return (T) k(str);
                    }
                    if (cls == c4.class) {
                        return (T) n(str);
                    }
                    y7<String, Object> c2 = this.a.c(cls);
                    if (c2 != null) {
                        T t = (T) c2.c(str);
                        if (t != null) {
                            return t;
                        }
                        throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                    }
                    throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return (T) invokeLL.objValue;
    }

    public x6 i(String str) {
        InterceptResult invokeL;
        x6 z6Var;
        x6 z6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            x6 x6Var = (x6) r(str, x6.class);
            if (x6Var != null) {
                return x6Var;
            }
            try {
                e4 l = l(str);
                if (l instanceof d4.a) {
                    d4.a aVar = (d4.a) l;
                    if (aVar.k("split") != null) {
                        z6Var2 = new y6(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        z6Var2 = new z6(n(str));
                    }
                    x6Var = z6Var2;
                }
                if (x6Var == null) {
                    x6 a7Var = new a7(l);
                    try {
                        if (this.c != 1.0f) {
                            s(a7Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    x6Var = a7Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (x6Var == null) {
                y3 y3Var = (y3) r(str, y3.class);
                if (y3Var != null) {
                    z6Var = new y6(y3Var);
                } else {
                    c4 c4Var = (c4) r(str, c4.class);
                    if (c4Var != null) {
                        z6Var = new z6(c4Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                x6Var = z6Var;
            }
            if (x6Var instanceof w6) {
                ((w6) x6Var).n(str);
            }
            f(str, x6Var, x6.class);
            return x6Var;
        }
        return (x6) invokeL.objValue;
    }

    public q7 j(l3 l3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, l3Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(n6.class, new b(this, this));
            aVar.o(w3.class, new c(this, l3Var, this));
            aVar.o(m3.class, new d(this));
            aVar.o(f.class, new e(this));
            y7.a<String, Class> it = this.d.iterator();
            while (it.hasNext()) {
                y7.b next = it.next();
                aVar.a((String) next.a, (Class) next.b);
            }
            return aVar;
        }
        return (q7) invokeL.objValue;
    }

    public y3 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            y3 y3Var = (y3) r(str, y3.class);
            if (y3Var != null) {
                return y3Var;
            }
            try {
                e4 l = l(str);
                if ((l instanceof d4.a) && (k = ((d4.a) l).k("split")) != null) {
                    y3Var = new y3(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((d4.a) l).k("pad");
                    if (k2 != null) {
                        y3Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (y3Var == null) {
                    y3Var = new y3(l);
                }
                if (this.c != 1.0f) {
                    y3Var.m(this.c, this.c);
                }
                f(str, y3Var, y3.class);
                return y3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (y3) invokeL.objValue;
    }

    public c4 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            c4 c4Var = (c4) r(str, c4.class);
            if (c4Var != null) {
                return c4Var;
            }
            try {
                e4 l = l(str);
                if (l instanceof d4.a) {
                    d4.a aVar = (d4.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        c4Var = new d4.b(aVar);
                    }
                }
                if (c4Var == null) {
                    c4Var = new c4(l);
                }
                if (this.c != 1.0f) {
                    c4Var.z(c4Var.n() * this.c, c4Var.k() * this.c);
                }
                f(str, c4Var, c4.class);
                return c4Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (c4) invokeL.objValue;
    }

    public void o(l3 l3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, l3Var) == null) {
            try {
                j(l3Var).d(n6.class, l3Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + l3Var, e2);
            }
        }
    }

    public x6 p(x6 x6Var, m3 m3Var) {
        InterceptResult invokeLL;
        x6 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, x6Var, m3Var)) == null) {
            if (x6Var instanceof a7) {
                p = ((a7) x6Var).p(m3Var);
            } else if (x6Var instanceof y6) {
                p = ((y6) x6Var).q(m3Var);
            } else if (x6Var instanceof z6) {
                p = ((z6) x6Var).p(m3Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + x6Var.getClass());
            }
            if (p instanceof w6) {
                w6 w6Var = (w6) p;
                if (x6Var instanceof w6) {
                    w6Var.n(((w6) x6Var).m() + " (" + m3Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    w6Var.n(" (" + m3Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (x6) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    y7<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        return null;
                    }
                    return (T) c2.c(str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return (T) invokeLL.objValue;
    }
}
