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
import com.baidu.tieba.b4;
import com.baidu.tieba.d8;
import com.baidu.tieba.i4;
import com.baidu.tieba.v7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class s6 implements o7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public d8<Class, d8<String, Object>> a;
    public i4 b;
    public float c;
    public final d8<String, Class> d;

    /* loaded from: classes6.dex */
    public class a extends v7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s6 n;

        public a(s6 s6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = s6Var;
        }

        @Override // com.baidu.tieba.v7
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) {
                return str.equals("parent");
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.v7
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

        @Override // com.baidu.tieba.v7
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.D() && !a9.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.j(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends v7.b<s6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s6 a;
        public final /* synthetic */ s6 b;

        public b(s6 s6Var, s6 s6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s6Var, s6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s6Var;
            this.a = s6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v7.d
        /* renamed from: b */
        public s6 a(v7 v7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v7Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = v7Var.e(jsonValue2.G());
                        if (e == null) {
                            e = a9.a(jsonValue2.G());
                        }
                        c(v7Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (s6) invokeLLL.objValue;
        }

        public final void c(v7 v7Var, Class cls, JsonValue jsonValue) {
            Class cls2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v7Var, cls, jsonValue) == null) {
                if (cls == f.class) {
                    cls2 = c7.class;
                } else {
                    cls2 = cls;
                }
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = v7Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != c7.class && a9.f(c7.class, cls2)) {
                                this.b.f(jsonValue2.e, j, c7.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + a9.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends v7.b<b4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q3 a;
        public final /* synthetic */ s6 b;

        public c(s6 s6Var, q3 q3Var, s6 s6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s6Var, q3Var, s6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q3Var;
            this.b = s6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v7.d
        /* renamed from: b */
        public b4 a(v7 v7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            b4 b4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v7Var, jsonValue, cls)) == null) {
                String str = (String) v7Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) v7Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) v7Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) v7Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                q3 a = this.a.i().a(str);
                if (!a.c()) {
                    a = l1.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        h7<j4> m = this.b.m(h);
                        if (m != null) {
                            b4Var = new b4(new b4.a(a, bool.booleanValue()), m, true);
                        } else {
                            j4 j4Var = (j4) this.b.r(h, j4.class);
                            if (j4Var != null) {
                                b4Var = new b4(a, j4Var, bool.booleanValue());
                            } else {
                                q3 i = a.i();
                                q3 a2 = i.a(h + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX);
                                if (a2.c()) {
                                    b4Var = new b4(a, a2, bool.booleanValue());
                                } else {
                                    b4Var = new b4(a, bool.booleanValue());
                                }
                            }
                        }
                        b4Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            b4Var.f().h(intValue / b4Var.a());
                        }
                        return b4Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (b4) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends v7.b<r3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s6 a;

        public d(s6 s6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v7.d
        /* renamed from: b */
        public r3 a(v7 v7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v7Var, jsonValue, cls)) == null) {
                if (jsonValue.D()) {
                    return (r3) this.a.h(jsonValue.j(), r3.class);
                }
                String str = (String) v7Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return r3.h(str);
                }
                return new r3(((Float) v7Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) v7Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) v7Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) v7Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (r3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends v7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s6 a;

        public e(s6 s6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s6Var;
        }

        @Override // com.baidu.tieba.v7.d
        public Object a(v7 v7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, v7Var, jsonValue, cls)) == null) {
                String str = (String) v7Var.l("name", String.class, jsonValue);
                r3 r3Var = (r3) v7Var.l("color", r3.class, jsonValue);
                if (r3Var != null) {
                    c7 q = this.a.q(str, r3Var);
                    if (q instanceof b7) {
                        ((b7) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + r3Var + SmallTailInfo.EMOTION_SUFFIX);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448315370, "Lcom/baidu/tieba/s6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448315370, "Lcom/baidu/tieba/s6;");
                return;
            }
        }
        e = new Class[]{b4.class, r3.class, f.class, d7.class, e7.class, f7.class, g7.class, j6.class, k6.class, l6.class, m6.class, n6.class, o6.class, p6.class, q6.class, r6.class, t6.class, u6.class, v6.class, w6.class, x6.class, y6.class, z6.class, a7.class};
    }

    public s6() {
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
        this.a = new d8<>();
        this.c = 1.0f;
        this.d = new d8<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
    }

    @Override // com.baidu.tieba.o7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i4 i4Var = this.b;
            if (i4Var != null) {
                i4Var.dispose();
            }
            d8.e<d8<String, Object>> n = this.a.n();
            n.c();
            while (n.hasNext()) {
                d8.e<Object> n2 = n.next().n();
                n2.c();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof o7) {
                        ((o7) next).dispose();
                    }
                }
            }
        }
    }

    public s6(i4 i4Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new d8<>();
        this.c = 1.0f;
        this.d = new d8<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = i4Var;
        g(i4Var);
    }

    public j4 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            j4 j4Var = (j4) r(str, j4.class);
            if (j4Var != null) {
                return j4Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                j4 j4Var2 = new j4(texture);
                f(str, j4Var2, j4.class);
                return j4Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (j4) invokeL.objValue;
    }

    public h7<j4> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            j4 j4Var = (j4) r(str + "_0", j4.class);
            if (j4Var != null) {
                h7<j4> h7Var = new h7<>();
                int i = 1;
                while (j4Var != null) {
                    h7Var.a(j4Var);
                    j4Var = (j4) r(str + "_" + i, j4.class);
                    i++;
                }
                return h7Var;
            }
            return null;
        }
        return (h7) invokeL.objValue;
    }

    public void s(c7 c7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, c7Var) == null) {
            c7Var.b(c7Var.l() * this.c);
            c7Var.c(c7Var.g() * this.c);
            c7Var.d(c7Var.e() * this.c);
            c7Var.f(c7Var.i() * this.c);
            c7Var.j(c7Var.a() * this.c);
            c7Var.h(c7Var.k() * this.c);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    public c7 q(String str, r3 r3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, r3Var)) == null) {
            return p(i(str), r3Var);
        }
        return (c7) invokeLL.objValue;
    }

    public void f(String str, Object obj, Class cls) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str != null) {
                if (obj != null) {
                    d8<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        if (cls != j4.class && cls != c7.class && cls != h4.class) {
                            i = 64;
                        } else {
                            i = 256;
                        }
                        c2 = new d8<>(i);
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

    public void g(i4 i4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, i4Var) == null) {
            h7<i4.a> g = i4Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                i4.a aVar = g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, j4.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == c7.class) {
                        return (T) i(str);
                    }
                    if (cls == j4.class) {
                        return (T) l(str);
                    }
                    if (cls == d4.class) {
                        return (T) k(str);
                    }
                    if (cls == h4.class) {
                        return (T) n(str);
                    }
                    d8<String, Object> c2 = this.a.c(cls);
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

    public c7 i(String str) {
        InterceptResult invokeL;
        c7 e7Var;
        c7 e7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            c7 c7Var = (c7) r(str, c7.class);
            if (c7Var != null) {
                return c7Var;
            }
            try {
                j4 l = l(str);
                if (l instanceof i4.a) {
                    i4.a aVar = (i4.a) l;
                    if (aVar.k("split") != null) {
                        e7Var2 = new d7(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        e7Var2 = new e7(n(str));
                    }
                    c7Var = e7Var2;
                }
                if (c7Var == null) {
                    c7 f7Var = new f7(l);
                    try {
                        if (this.c != 1.0f) {
                            s(f7Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    c7Var = f7Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (c7Var == null) {
                d4 d4Var = (d4) r(str, d4.class);
                if (d4Var != null) {
                    e7Var = new d7(d4Var);
                } else {
                    h4 h4Var = (h4) r(str, h4.class);
                    if (h4Var != null) {
                        e7Var = new e7(h4Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                c7Var = e7Var;
            }
            if (c7Var instanceof b7) {
                ((b7) c7Var).n(str);
            }
            f(str, c7Var, c7.class);
            return c7Var;
        }
        return (c7) invokeL.objValue;
    }

    public v7 j(q3 q3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, q3Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(s6.class, new b(this, this));
            aVar.o(b4.class, new c(this, q3Var, this));
            aVar.o(r3.class, new d(this));
            aVar.o(f.class, new e(this));
            d8.a<String, Class> it = this.d.iterator();
            while (it.hasNext()) {
                d8.b next = it.next();
                aVar.a((String) next.a, (Class) next.b);
            }
            return aVar;
        }
        return (v7) invokeL.objValue;
    }

    public d4 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            d4 d4Var = (d4) r(str, d4.class);
            if (d4Var != null) {
                return d4Var;
            }
            try {
                j4 l = l(str);
                if ((l instanceof i4.a) && (k = ((i4.a) l).k("split")) != null) {
                    d4Var = new d4(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((i4.a) l).k("pad");
                    if (k2 != null) {
                        d4Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (d4Var == null) {
                    d4Var = new d4(l);
                }
                if (this.c != 1.0f) {
                    d4Var.m(this.c, this.c);
                }
                f(str, d4Var, d4.class);
                return d4Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (d4) invokeL.objValue;
    }

    public h4 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            h4 h4Var = (h4) r(str, h4.class);
            if (h4Var != null) {
                return h4Var;
            }
            try {
                j4 l = l(str);
                if (l instanceof i4.a) {
                    i4.a aVar = (i4.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        h4Var = new i4.b(aVar);
                    }
                }
                if (h4Var == null) {
                    h4Var = new h4(l);
                }
                if (this.c != 1.0f) {
                    h4Var.z(h4Var.n() * this.c, h4Var.k() * this.c);
                }
                f(str, h4Var, h4.class);
                return h4Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (h4) invokeL.objValue;
    }

    public void o(q3 q3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, q3Var) == null) {
            try {
                j(q3Var).d(s6.class, q3Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + q3Var, e2);
            }
        }
    }

    public c7 p(c7 c7Var, r3 r3Var) {
        InterceptResult invokeLL;
        c7 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, c7Var, r3Var)) == null) {
            if (c7Var instanceof f7) {
                p = ((f7) c7Var).p(r3Var);
            } else if (c7Var instanceof d7) {
                p = ((d7) c7Var).q(r3Var);
            } else if (c7Var instanceof e7) {
                p = ((e7) c7Var).p(r3Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + c7Var.getClass());
            }
            if (p instanceof b7) {
                b7 b7Var = (b7) p;
                if (c7Var instanceof b7) {
                    b7Var.n(((b7) c7Var).m() + " (" + r3Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    b7Var.n(" (" + r3Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (c7) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    d8<String, Object> c2 = this.a.c(cls);
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
