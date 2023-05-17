package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.c7;
import com.baidu.tieba.i3;
import com.baidu.tieba.k7;
import com.baidu.tieba.p3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class z5 implements v6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public k7<Class, k7<String, Object>> a;
    public p3 b;
    public float c;
    public final k7<String, Class> d;

    /* loaded from: classes8.dex */
    public class a extends c7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z5 n;

        public a(z5 z5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = z5Var;
        }

        @Override // com.baidu.tieba.c7
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) {
                return str.equals("parent");
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.c7
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

        @Override // com.baidu.tieba.c7
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.D() && !h8.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.j(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends c7.b<z5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z5 a;
        public final /* synthetic */ z5 b;

        public b(z5 z5Var, z5 z5Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z5Var, z5Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z5Var;
            this.a = z5Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c7.d
        /* renamed from: b */
        public z5 a(c7 c7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c7Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = c7Var.e(jsonValue2.G());
                        if (e == null) {
                            e = h8.a(jsonValue2.G());
                        }
                        c(c7Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (z5) invokeLLL.objValue;
        }

        public final void c(c7 c7Var, Class cls, JsonValue jsonValue) {
            Class cls2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, c7Var, cls, jsonValue) == null) {
                if (cls == f.class) {
                    cls2 = j6.class;
                } else {
                    cls2 = cls;
                }
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = c7Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != j6.class && h8.f(j6.class, cls2)) {
                                this.b.f(jsonValue2.e, j, j6.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + h8.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends c7.b<i3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x2 a;
        public final /* synthetic */ z5 b;

        public c(z5 z5Var, x2 x2Var, z5 z5Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z5Var, x2Var, z5Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x2Var;
            this.b = z5Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c7.d
        /* renamed from: b */
        public i3 a(c7 c7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            i3 i3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c7Var, jsonValue, cls)) == null) {
                String str = (String) c7Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) c7Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) c7Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) c7Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                x2 a = this.a.i().a(str);
                if (!a.c()) {
                    a = s0.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        o6<q3> m = this.b.m(h);
                        if (m != null) {
                            i3Var = new i3(new i3.a(a, bool.booleanValue()), m, true);
                        } else {
                            q3 q3Var = (q3) this.b.r(h, q3.class);
                            if (q3Var != null) {
                                i3Var = new i3(a, q3Var, bool.booleanValue());
                            } else {
                                x2 i = a.i();
                                x2 a2 = i.a(h + ".png");
                                if (a2.c()) {
                                    i3Var = new i3(a, a2, bool.booleanValue());
                                } else {
                                    i3Var = new i3(a, bool.booleanValue());
                                }
                            }
                        }
                        i3Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            i3Var.f().h(intValue / i3Var.a());
                        }
                        return i3Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (i3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends c7.b<y2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z5 a;

        public d(z5 z5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c7.d
        /* renamed from: b */
        public y2 a(c7 c7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c7Var, jsonValue, cls)) == null) {
                if (jsonValue.D()) {
                    return (y2) this.a.h(jsonValue.j(), y2.class);
                }
                String str = (String) c7Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return y2.h(str);
                }
                return new y2(((Float) c7Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) c7Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) c7Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) c7Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (y2) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends c7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z5 a;

        public e(z5 z5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z5Var;
        }

        @Override // com.baidu.tieba.c7.d
        public Object a(c7 c7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, c7Var, jsonValue, cls)) == null) {
                String str = (String) c7Var.l("name", String.class, jsonValue);
                y2 y2Var = (y2) c7Var.l("color", y2.class, jsonValue);
                if (y2Var != null) {
                    j6 q = this.a.q(str, y2Var);
                    if (q instanceof i6) {
                        ((i6) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + y2Var + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    return q;
                }
                throw new SerializationException("TintedDrawable missing color: " + jsonValue);
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448322066, "Lcom/baidu/tieba/z5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448322066, "Lcom/baidu/tieba/z5;");
                return;
            }
        }
        e = new Class[]{i3.class, y2.class, f.class, k6.class, l6.class, m6.class, n6.class, q5.class, r5.class, s5.class, t5.class, u5.class, v5.class, w5.class, x5.class, y5.class, a6.class, b6.class, c6.class, d6.class, e6.class, f6.class, g6.class, h6.class};
    }

    public z5() {
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
        this.a = new k7<>();
        this.c = 1.0f;
        this.d = new k7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
    }

    @Override // com.baidu.tieba.v6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p3 p3Var = this.b;
            if (p3Var != null) {
                p3Var.dispose();
            }
            k7.e<k7<String, Object>> n = this.a.n();
            n.c();
            while (n.hasNext()) {
                k7.e<Object> n2 = n.next().n();
                n2.c();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof v6) {
                        ((v6) next).dispose();
                    }
                }
            }
        }
    }

    public z5(p3 p3Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p3Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new k7<>();
        this.c = 1.0f;
        this.d = new k7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = p3Var;
        g(p3Var);
    }

    public q3 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            q3 q3Var = (q3) r(str, q3.class);
            if (q3Var != null) {
                return q3Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                q3 q3Var2 = new q3(texture);
                f(str, q3Var2, q3.class);
                return q3Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (q3) invokeL.objValue;
    }

    public o6<q3> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            q3 q3Var = (q3) r(str + "_0", q3.class);
            if (q3Var != null) {
                o6<q3> o6Var = new o6<>();
                int i = 1;
                while (q3Var != null) {
                    o6Var.a(q3Var);
                    q3Var = (q3) r(str + "_" + i, q3.class);
                    i++;
                }
                return o6Var;
            }
            return null;
        }
        return (o6) invokeL.objValue;
    }

    public void s(j6 j6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, j6Var) == null) {
            j6Var.b(j6Var.l() * this.c);
            j6Var.c(j6Var.g() * this.c);
            j6Var.d(j6Var.e() * this.c);
            j6Var.f(j6Var.i() * this.c);
            j6Var.j(j6Var.a() * this.c);
            j6Var.h(j6Var.k() * this.c);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    public j6 q(String str, y2 y2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, y2Var)) == null) {
            return p(i(str), y2Var);
        }
        return (j6) invokeLL.objValue;
    }

    public void f(String str, Object obj, Class cls) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str != null) {
                if (obj != null) {
                    k7<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        if (cls != q3.class && cls != j6.class && cls != o3.class) {
                            i = 64;
                        } else {
                            i = 256;
                        }
                        c2 = new k7<>(i);
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

    public void g(p3 p3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p3Var) == null) {
            o6<p3.a> g = p3Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                p3.a aVar = g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, q3.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == j6.class) {
                        return (T) i(str);
                    }
                    if (cls == q3.class) {
                        return (T) l(str);
                    }
                    if (cls == k3.class) {
                        return (T) k(str);
                    }
                    if (cls == o3.class) {
                        return (T) n(str);
                    }
                    k7<String, Object> c2 = this.a.c(cls);
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

    public j6 i(String str) {
        InterceptResult invokeL;
        j6 l6Var;
        j6 l6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            j6 j6Var = (j6) r(str, j6.class);
            if (j6Var != null) {
                return j6Var;
            }
            try {
                q3 l = l(str);
                if (l instanceof p3.a) {
                    p3.a aVar = (p3.a) l;
                    if (aVar.k("split") != null) {
                        l6Var2 = new k6(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        l6Var2 = new l6(n(str));
                    }
                    j6Var = l6Var2;
                }
                if (j6Var == null) {
                    j6 m6Var = new m6(l);
                    try {
                        if (this.c != 1.0f) {
                            s(m6Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    j6Var = m6Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (j6Var == null) {
                k3 k3Var = (k3) r(str, k3.class);
                if (k3Var != null) {
                    l6Var = new k6(k3Var);
                } else {
                    o3 o3Var = (o3) r(str, o3.class);
                    if (o3Var != null) {
                        l6Var = new l6(o3Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                j6Var = l6Var;
            }
            if (j6Var instanceof i6) {
                ((i6) j6Var).n(str);
            }
            f(str, j6Var, j6.class);
            return j6Var;
        }
        return (j6) invokeL.objValue;
    }

    public c7 j(x2 x2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, x2Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(z5.class, new b(this, this));
            aVar.o(i3.class, new c(this, x2Var, this));
            aVar.o(y2.class, new d(this));
            aVar.o(f.class, new e(this));
            k7.a<String, Class> it = this.d.iterator();
            while (it.hasNext()) {
                k7.b next = it.next();
                aVar.a((String) next.a, (Class) next.b);
            }
            return aVar;
        }
        return (c7) invokeL.objValue;
    }

    public k3 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            k3 k3Var = (k3) r(str, k3.class);
            if (k3Var != null) {
                return k3Var;
            }
            try {
                q3 l = l(str);
                if ((l instanceof p3.a) && (k = ((p3.a) l).k("split")) != null) {
                    k3Var = new k3(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((p3.a) l).k("pad");
                    if (k2 != null) {
                        k3Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (k3Var == null) {
                    k3Var = new k3(l);
                }
                if (this.c != 1.0f) {
                    k3Var.m(this.c, this.c);
                }
                f(str, k3Var, k3.class);
                return k3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (k3) invokeL.objValue;
    }

    public o3 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            o3 o3Var = (o3) r(str, o3.class);
            if (o3Var != null) {
                return o3Var;
            }
            try {
                q3 l = l(str);
                if (l instanceof p3.a) {
                    p3.a aVar = (p3.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        o3Var = new p3.b(aVar);
                    }
                }
                if (o3Var == null) {
                    o3Var = new o3(l);
                }
                if (this.c != 1.0f) {
                    o3Var.z(o3Var.n() * this.c, o3Var.k() * this.c);
                }
                f(str, o3Var, o3.class);
                return o3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (o3) invokeL.objValue;
    }

    public void o(x2 x2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, x2Var) == null) {
            try {
                j(x2Var).d(z5.class, x2Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + x2Var, e2);
            }
        }
    }

    public j6 p(j6 j6Var, y2 y2Var) {
        InterceptResult invokeLL;
        j6 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, j6Var, y2Var)) == null) {
            if (j6Var instanceof m6) {
                p = ((m6) j6Var).p(y2Var);
            } else if (j6Var instanceof k6) {
                p = ((k6) j6Var).q(y2Var);
            } else if (j6Var instanceof l6) {
                p = ((l6) j6Var).p(y2Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + j6Var.getClass());
            }
            if (p instanceof i6) {
                i6 i6Var = (i6) p;
                if (j6Var instanceof i6) {
                    i6Var.n(((i6) j6Var).m() + " (" + y2Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    i6Var.n(" (" + y2Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (j6) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    k7<String, Object> c2 = this.a.c(cls);
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
