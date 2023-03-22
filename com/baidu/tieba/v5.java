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
import com.baidu.tieba.e3;
import com.baidu.tieba.g7;
import com.baidu.tieba.l3;
import com.baidu.tieba.y6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v5 implements r6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public g7<Class, g7<String, Object>> a;
    public l3 b;
    public float c;
    public final g7<String, Class> d;

    /* loaded from: classes6.dex */
    public class a extends y6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v5 n;

        public a(v5 v5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = v5Var;
        }

        @Override // com.baidu.tieba.y6
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) {
                return str.equals("parent");
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.y6
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

        @Override // com.baidu.tieba.y6
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.D() && !d8.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.j(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends y6.b<v5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v5 a;
        public final /* synthetic */ v5 b;

        public b(v5 v5Var, v5 v5Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v5Var, v5Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v5Var;
            this.a = v5Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y6.d
        /* renamed from: b */
        public v5 a(y6 y6Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y6Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = y6Var.e(jsonValue2.G());
                        if (e == null) {
                            e = d8.a(jsonValue2.G());
                        }
                        c(y6Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (v5) invokeLLL.objValue;
        }

        public final void c(y6 y6Var, Class cls, JsonValue jsonValue) {
            Class cls2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, y6Var, cls, jsonValue) == null) {
                if (cls == f.class) {
                    cls2 = f6.class;
                } else {
                    cls2 = cls;
                }
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = y6Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != f6.class && d8.f(f6.class, cls2)) {
                                this.b.f(jsonValue2.e, j, f6.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + d8.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends y6.b<e3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t2 a;
        public final /* synthetic */ v5 b;

        public c(v5 v5Var, t2 t2Var, v5 v5Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v5Var, t2Var, v5Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t2Var;
            this.b = v5Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y6.d
        /* renamed from: b */
        public e3 a(y6 y6Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            e3 e3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y6Var, jsonValue, cls)) == null) {
                String str = (String) y6Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) y6Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) y6Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) y6Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                t2 a = this.a.i().a(str);
                if (!a.c()) {
                    a = o0.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        k6<m3> m = this.b.m(h);
                        if (m != null) {
                            e3Var = new e3(new e3.a(a, bool.booleanValue()), m, true);
                        } else {
                            m3 m3Var = (m3) this.b.r(h, m3.class);
                            if (m3Var != null) {
                                e3Var = new e3(a, m3Var, bool.booleanValue());
                            } else {
                                t2 i = a.i();
                                t2 a2 = i.a(h + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX);
                                if (a2.c()) {
                                    e3Var = new e3(a, a2, bool.booleanValue());
                                } else {
                                    e3Var = new e3(a, bool.booleanValue());
                                }
                            }
                        }
                        e3Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            e3Var.f().h(intValue / e3Var.a());
                        }
                        return e3Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (e3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends y6.b<u2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v5 a;

        public d(v5 v5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y6.d
        /* renamed from: b */
        public u2 a(y6 y6Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y6Var, jsonValue, cls)) == null) {
                if (jsonValue.D()) {
                    return (u2) this.a.h(jsonValue.j(), u2.class);
                }
                String str = (String) y6Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return u2.h(str);
                }
                return new u2(((Float) y6Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) y6Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) y6Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) y6Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (u2) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends y6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v5 a;

        public e(v5 v5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v5Var;
        }

        @Override // com.baidu.tieba.y6.d
        public Object a(y6 y6Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, y6Var, jsonValue, cls)) == null) {
                String str = (String) y6Var.l("name", String.class, jsonValue);
                u2 u2Var = (u2) y6Var.l("color", u2.class, jsonValue);
                if (u2Var != null) {
                    f6 q = this.a.q(str, u2Var);
                    if (q instanceof e6) {
                        ((e6) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + u2Var + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    return q;
                }
                throw new SerializationException("TintedDrawable missing color: " + jsonValue);
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318222, "Lcom/baidu/tieba/v5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318222, "Lcom/baidu/tieba/v5;");
                return;
            }
        }
        e = new Class[]{e3.class, u2.class, f.class, g6.class, h6.class, i6.class, j6.class, m5.class, n5.class, o5.class, p5.class, q5.class, r5.class, s5.class, t5.class, u5.class, w5.class, x5.class, y5.class, z5.class, a6.class, b6.class, c6.class, d6.class};
    }

    public v5() {
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
        this.a = new g7<>();
        this.c = 1.0f;
        this.d = new g7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
    }

    @Override // com.baidu.tieba.r6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l3 l3Var = this.b;
            if (l3Var != null) {
                l3Var.dispose();
            }
            g7.e<g7<String, Object>> n = this.a.n();
            n.c();
            while (n.hasNext()) {
                g7.e<Object> n2 = n.next().n();
                n2.c();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof r6) {
                        ((r6) next).dispose();
                    }
                }
            }
        }
    }

    public v5(l3 l3Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l3Var};
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
        this.c = 1.0f;
        this.d = new g7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = l3Var;
        g(l3Var);
    }

    public m3 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            m3 m3Var = (m3) r(str, m3.class);
            if (m3Var != null) {
                return m3Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                m3 m3Var2 = new m3(texture);
                f(str, m3Var2, m3.class);
                return m3Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (m3) invokeL.objValue;
    }

    public k6<m3> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            m3 m3Var = (m3) r(str + "_0", m3.class);
            if (m3Var != null) {
                k6<m3> k6Var = new k6<>();
                int i = 1;
                while (m3Var != null) {
                    k6Var.a(m3Var);
                    m3Var = (m3) r(str + "_" + i, m3.class);
                    i++;
                }
                return k6Var;
            }
            return null;
        }
        return (k6) invokeL.objValue;
    }

    public void s(f6 f6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, f6Var) == null) {
            f6Var.b(f6Var.l() * this.c);
            f6Var.c(f6Var.g() * this.c);
            f6Var.d(f6Var.e() * this.c);
            f6Var.f(f6Var.i() * this.c);
            f6Var.j(f6Var.a() * this.c);
            f6Var.h(f6Var.k() * this.c);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    public f6 q(String str, u2 u2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, u2Var)) == null) {
            return p(i(str), u2Var);
        }
        return (f6) invokeLL.objValue;
    }

    public void f(String str, Object obj, Class cls) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str != null) {
                if (obj != null) {
                    g7<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        if (cls != m3.class && cls != f6.class && cls != k3.class) {
                            i = 64;
                        } else {
                            i = 256;
                        }
                        c2 = new g7<>(i);
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

    public void g(l3 l3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l3Var) == null) {
            k6<l3.a> g = l3Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                l3.a aVar = g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, m3.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == f6.class) {
                        return (T) i(str);
                    }
                    if (cls == m3.class) {
                        return (T) l(str);
                    }
                    if (cls == g3.class) {
                        return (T) k(str);
                    }
                    if (cls == k3.class) {
                        return (T) n(str);
                    }
                    g7<String, Object> c2 = this.a.c(cls);
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

    public f6 i(String str) {
        InterceptResult invokeL;
        f6 h6Var;
        f6 h6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            f6 f6Var = (f6) r(str, f6.class);
            if (f6Var != null) {
                return f6Var;
            }
            try {
                m3 l = l(str);
                if (l instanceof l3.a) {
                    l3.a aVar = (l3.a) l;
                    if (aVar.k("split") != null) {
                        h6Var2 = new g6(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        h6Var2 = new h6(n(str));
                    }
                    f6Var = h6Var2;
                }
                if (f6Var == null) {
                    f6 i6Var = new i6(l);
                    try {
                        if (this.c != 1.0f) {
                            s(i6Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    f6Var = i6Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (f6Var == null) {
                g3 g3Var = (g3) r(str, g3.class);
                if (g3Var != null) {
                    h6Var = new g6(g3Var);
                } else {
                    k3 k3Var = (k3) r(str, k3.class);
                    if (k3Var != null) {
                        h6Var = new h6(k3Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                f6Var = h6Var;
            }
            if (f6Var instanceof e6) {
                ((e6) f6Var).n(str);
            }
            f(str, f6Var, f6.class);
            return f6Var;
        }
        return (f6) invokeL.objValue;
    }

    public y6 j(t2 t2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, t2Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(v5.class, new b(this, this));
            aVar.o(e3.class, new c(this, t2Var, this));
            aVar.o(u2.class, new d(this));
            aVar.o(f.class, new e(this));
            g7.a<String, Class> it = this.d.iterator();
            while (it.hasNext()) {
                g7.b next = it.next();
                aVar.a((String) next.a, (Class) next.b);
            }
            return aVar;
        }
        return (y6) invokeL.objValue;
    }

    public g3 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            g3 g3Var = (g3) r(str, g3.class);
            if (g3Var != null) {
                return g3Var;
            }
            try {
                m3 l = l(str);
                if ((l instanceof l3.a) && (k = ((l3.a) l).k("split")) != null) {
                    g3Var = new g3(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((l3.a) l).k("pad");
                    if (k2 != null) {
                        g3Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (g3Var == null) {
                    g3Var = new g3(l);
                }
                if (this.c != 1.0f) {
                    g3Var.m(this.c, this.c);
                }
                f(str, g3Var, g3.class);
                return g3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (g3) invokeL.objValue;
    }

    public k3 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            k3 k3Var = (k3) r(str, k3.class);
            if (k3Var != null) {
                return k3Var;
            }
            try {
                m3 l = l(str);
                if (l instanceof l3.a) {
                    l3.a aVar = (l3.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        k3Var = new l3.b(aVar);
                    }
                }
                if (k3Var == null) {
                    k3Var = new k3(l);
                }
                if (this.c != 1.0f) {
                    k3Var.z(k3Var.n() * this.c, k3Var.k() * this.c);
                }
                f(str, k3Var, k3.class);
                return k3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (k3) invokeL.objValue;
    }

    public void o(t2 t2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t2Var) == null) {
            try {
                j(t2Var).d(v5.class, t2Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + t2Var, e2);
            }
        }
    }

    public f6 p(f6 f6Var, u2 u2Var) {
        InterceptResult invokeLL;
        f6 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, f6Var, u2Var)) == null) {
            if (f6Var instanceof i6) {
                p = ((i6) f6Var).p(u2Var);
            } else if (f6Var instanceof g6) {
                p = ((g6) f6Var).q(u2Var);
            } else if (f6Var instanceof h6) {
                p = ((h6) f6Var).p(u2Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + f6Var.getClass());
            }
            if (p instanceof e6) {
                e6 e6Var = (e6) p;
                if (f6Var instanceof e6) {
                    e6Var.n(((e6) f6Var).m() + " (" + u2Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    e6Var.n(" (" + u2Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (f6) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    g7<String, Object> c2 = this.a.c(cls);
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
