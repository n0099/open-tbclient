package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter$OutputType;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.g7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes7.dex */
public class y6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public d g;
    public final g7<Class, i7<String, a>> h;
    public final g7<String, Class> i;
    public final g7<Class, String> j;
    public final g7<Class, d> k;
    public final Object[] l;
    public final Object[] m;

    /* loaded from: classes7.dex */
    public interface c {
        void a(y6 y6Var, JsonValue jsonValue);
    }

    /* loaded from: classes7.dex */
    public interface d<T> {
        T a(y6 y6Var, JsonValue jsonValue, Class cls);
    }

    public boolean g(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, cls, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final f8 a;
        public Class b;
        public boolean c;

        public a(f8 f8Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f8Var;
            if (!d8.f(g7.class, f8Var.getType()) && !d8.f(Map.class, f8Var.getType())) {
                i = 0;
            } else {
                i = 1;
            }
            this.b = f8Var.c(i);
            this.c = f8Var.f(Deprecated.class);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class b<T> implements d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

    public y6() {
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
        this.a = DealIntentService.KEY_CLASS;
        this.e = true;
        this.h = new g7<>();
        this.i = new g7<>();
        this.j = new g7<>();
        this.k = new g7<>();
        new g7();
        this.l = new Object[]{null};
        this.m = new Object[]{null};
        JsonWriter$OutputType jsonWriter$OutputType = JsonWriter$OutputType.minimal;
    }

    public void a(String str, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cls) == null) {
            this.i.i(str, cls);
            this.j.i(cls, str);
        }
    }

    public <T> T j(Class<T> cls, JsonValue jsonValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, cls, jsonValue)) == null) {
            return (T) k(cls, null, jsonValue);
        }
        return (T) invokeLL.objValue;
    }

    public <T> void o(Class<T> cls, d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, cls, dVar) == null) {
            this.k.i(cls, dVar);
        }
    }

    public final String b(Enum r5) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5)) == null) {
            if (this.e) {
                return r5.name();
            }
            return r5.toString();
        }
        return (String) invokeL.objValue;
    }

    public Class e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.i.c(str);
        }
        return (Class) invokeL.objValue;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.a = str;
        }
    }

    public void c(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, obj2) == null) {
            i7<String, a> f = f(obj2.getClass());
            g7.a<String, a> it = f(obj.getClass()).iterator();
            while (it.hasNext()) {
                g7.b next = it.next();
                a c2 = f.c(next.a);
                f8 f8Var = ((a) next.b).a;
                if (c2 != null) {
                    try {
                        c2.a.j(obj2, f8Var.a(obj));
                    } catch (ReflectionException e) {
                        throw new SerializationException("Error copying field: " + f8Var.d(), e);
                    }
                } else {
                    throw new SerializationException("To object is missing field: " + ((String) next.a));
                }
            }
        }
    }

    public <T> T d(Class<T> cls, t2 t2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, t2Var)) == null) {
            try {
                return (T) k(cls, null, new z6().a(t2Var));
            } catch (Exception e) {
                throw new SerializationException("Error reading file: " + t2Var, e);
            }
        }
        return (T) invokeLL.objValue;
    }

    public final i7<String, a> f(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            i7<String, a> c2 = this.h.c(cls);
            if (c2 != null) {
                return c2;
            }
            k6 k6Var = new k6();
            for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                k6Var.a(cls2);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = k6Var.b - 1; i >= 0; i--) {
                Collections.addAll(arrayList, d8.d((Class) k6Var.get(i)));
            }
            i7<String, a> i7Var = new i7<>(arrayList.size());
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                f8 f8Var = (f8) arrayList.get(i2);
                if (!f8Var.i() && !f8Var.g() && !f8Var.h()) {
                    if (!f8Var.e()) {
                        try {
                            f8Var.k(true);
                        } catch (AccessControlException unused) {
                        }
                    }
                    i7Var.i(f8Var.d(), new a(f8Var));
                }
            }
            if (this.f) {
                i7Var.o.l();
            }
            this.h.i(cls, i7Var);
            return i7Var;
        }
        return (i7) invokeL.objValue;
    }

    public Object h(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            try {
                return d8.i(cls);
            } catch (Exception e) {
                e = e;
                try {
                    e8 c2 = d8.c(cls, new Class[0]);
                    c2.c(true);
                    return c2.b(new Object[0]);
                } catch (ReflectionException unused) {
                    if (d8.f(Enum.class, cls)) {
                        if (cls.getEnumConstants() == null) {
                            cls = cls.getSuperclass();
                        }
                        return cls.getEnumConstants()[0];
                    } else if (!cls.isArray()) {
                        if (d8.g(cls) && !d8.h(cls)) {
                            throw new SerializationException("Class cannot be created (non-static member class): " + cls.getName(), e);
                        }
                        throw new SerializationException("Class cannot be created (missing no-arg constructor): " + cls.getName(), e);
                    } else {
                        throw new SerializationException("Encountered JSON object when expected array of type: " + cls.getName(), e);
                    }
                } catch (SecurityException unused2) {
                    throw new SerializationException("Error constructing instance of class: " + cls.getName(), e);
                } catch (Exception e2) {
                    e = e2;
                    throw new SerializationException("Error constructing instance of class: " + cls.getName(), e);
                }
            }
        }
        return invokeL.objValue;
    }

    public void i(Object obj, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, jsonValue) == null) {
            Class<?> cls = obj.getClass();
            i7<String, a> f = f(cls);
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                a c2 = f.c(jsonValue2.G().replace(" ", "_"));
                if (c2 == null) {
                    if (!jsonValue2.e.equals(this.a) && !this.b && !g(cls, jsonValue2.e)) {
                        SerializationException serializationException = new SerializationException("Field not found: " + jsonValue2.e + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        serializationException.addTrace(jsonValue2.Q());
                        throw serializationException;
                    }
                } else if (!this.c || this.d || !c2.c) {
                    f8 f8Var = c2.a;
                    try {
                        f8Var.j(obj, k(f8Var.getType(), c2.b, jsonValue2));
                    } catch (SerializationException e) {
                        e.addTrace(f8Var.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        throw e;
                    } catch (ReflectionException e2) {
                        throw new SerializationException("Error accessing field: " + f8Var.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX, e2);
                    } catch (RuntimeException e3) {
                        SerializationException serializationException2 = new SerializationException(e3);
                        serializationException2.addTrace(jsonValue2.Q());
                        serializationException2.addTrace(f8Var.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        throw serializationException2;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r13v3. Raw type applied. Possible types: java.lang.Class<com.baidu.tieba.k6> */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0208, code lost:
        if (r13 == java.lang.Object.class) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0354, code lost:
        if (r13 == r0) goto L138;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0431 A[RETURN] */
    /* JADX WARN: Type inference failed for: r0v68, types: [com.baidu.tieba.y6$c] */
    /* JADX WARN: Type inference failed for: r0v71, types: [com.baidu.tieba.y6$d] */
    /* JADX WARN: Type inference failed for: r12v14, types: [com.baidu.tieba.y6$d] */
    /* JADX WARN: Type inference failed for: r12v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.baidu.tieba.y6, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.badlogic.gdx.utils.JsonValue, T] */
    /* JADX WARN: Type inference failed for: r2v45, types: [com.badlogic.gdx.utils.JsonValue, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v24, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v25, types: [com.baidu.tieba.l6, T] */
    /* JADX WARN: Type inference failed for: r3v26, types: [T, com.baidu.tieba.x6] */
    /* JADX WARN: Type inference failed for: r3v27, types: [T, com.baidu.tieba.c7] */
    /* JADX WARN: Type inference failed for: r3v28, types: [T, com.baidu.tieba.w6] */
    /* JADX WARN: Type inference failed for: r3v29, types: [T, com.baidu.tieba.h7] */
    /* JADX WARN: Type inference failed for: r3v30, types: [T, com.baidu.tieba.e7] */
    /* JADX WARN: Type inference failed for: r3v31, types: [T, com.baidu.tieba.f7] */
    /* JADX WARN: Type inference failed for: r3v32, types: [T, com.baidu.tieba.g7] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v41, types: [com.baidu.tieba.m7] */
    /* JADX WARN: Type inference failed for: r3v45, types: [com.baidu.tieba.k6] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
        InterceptResult invokeLLL;
        Class cls3;
        JsonValue jsonValue2;
        Class cls4;
        JsonValue jsonValue3;
        T t;
        T t2;
        T t3;
        String r;
        Class cls5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, cls, cls2, jsonValue)) == null) {
            Class cls6 = cls2;
            ?? r2 = (T) jsonValue;
            if (r2 == 0) {
                return null;
            }
            if (jsonValue.C()) {
                String str = this.a;
                if (str == null) {
                    r = null;
                } else {
                    r = r2.r(str, null);
                }
                if (r != null) {
                    Class e = e(r);
                    if (e == null) {
                        try {
                            cls5 = d8.a(r);
                        } catch (ReflectionException e2) {
                            throw new SerializationException(e2);
                        }
                    } else {
                        cls5 = e;
                    }
                } else {
                    cls5 = cls;
                }
                if (cls5 == null) {
                    ?? r0 = this.g;
                    if (r0 != 0) {
                        return (T) r0.a(this, r2, cls5);
                    }
                    return r2;
                } else if (this.a != null && d8.f(Collection.class, cls5)) {
                    ?? r22 = (T) r2.l("items");
                    jsonValue2 = r22;
                    cls3 = cls5;
                    if (r22 == 0) {
                        throw new SerializationException("Unable to convert object to collection: " + r22 + " (" + cls5.getName() + SmallTailInfo.EMOTION_SUFFIX);
                    }
                } else {
                    d c2 = this.k.c(cls5);
                    if (c2 != 0) {
                        return (T) c2.a(this, r2, cls5);
                    }
                    if (cls5 != String.class && cls5 != Integer.class && cls5 != Boolean.class && cls5 != Float.class && cls5 != Long.class && cls5 != Double.class && cls5 != Short.class && cls5 != Byte.class && cls5 != Character.class && !d8.f(Enum.class, cls5)) {
                        T t4 = (T) h(cls5);
                        if (t4 instanceof c) {
                            ((c) t4).a(this, r2);
                            return t4;
                        } else if (t4 instanceof g7) {
                            ?? r3 = (T) ((g7) t4);
                            for (JsonValue jsonValue4 = r2.f; jsonValue4 != null; jsonValue4 = jsonValue4.h) {
                                r3.i(jsonValue4.e, k(cls6, null, jsonValue4));
                            }
                            return r3;
                        } else if (t4 instanceof f7) {
                            ?? r32 = (T) ((f7) t4);
                            for (JsonValue jsonValue5 = r2.f; jsonValue5 != null; jsonValue5 = jsonValue5.h) {
                                r32.h(jsonValue5.e, ((Integer) k(Integer.class, null, jsonValue5)).intValue());
                            }
                            return r32;
                        } else if (t4 instanceof e7) {
                            ?? r33 = (T) ((e7) t4);
                            for (JsonValue jsonValue6 = r2.f; jsonValue6 != null; jsonValue6 = jsonValue6.h) {
                                r33.g(jsonValue6.e, ((Float) k(Float.class, null, jsonValue6)).floatValue());
                            }
                            return r33;
                        } else if (t4 instanceof h7) {
                            ?? r34 = (T) ((h7) t4);
                            for (JsonValue m = r2.m(SavedStateHandle.VALUES); m != null; m = m.h) {
                                r34.add(k(cls6, null, m));
                            }
                            return r34;
                        } else if (t4 instanceof w6) {
                            ?? r35 = (T) ((w6) t4);
                            for (JsonValue jsonValue7 = r2.f; jsonValue7 != null; jsonValue7 = jsonValue7.h) {
                                r35.e(Integer.parseInt(jsonValue7.e), k(cls6, null, jsonValue7));
                            }
                            return r35;
                        } else if (t4 instanceof c7) {
                            ?? r36 = (T) ((c7) t4);
                            for (JsonValue jsonValue8 = r2.f; jsonValue8 != null; jsonValue8 = jsonValue8.h) {
                                r36.f(Long.parseLong(jsonValue8.e), k(cls6, null, jsonValue8));
                            }
                            return r36;
                        } else if (t4 instanceof x6) {
                            ?? r37 = (T) ((x6) t4);
                            for (JsonValue m2 = r2.m(SavedStateHandle.VALUES); m2 != null; m2 = m2.h) {
                                r37.a(m2.f());
                            }
                            return r37;
                        } else if (t4 instanceof l6) {
                            ?? r38 = (T) ((l6) t4);
                            for (JsonValue jsonValue9 = r2.f; jsonValue9 != null; jsonValue9 = jsonValue9.h) {
                                r38.e(jsonValue9.e, k(cls6, null, jsonValue9));
                            }
                            return r38;
                        } else if (t4 instanceof Map) {
                            ?? r39 = (T) ((Map) t4);
                            for (JsonValue jsonValue10 = r2.f; jsonValue10 != null; jsonValue10 = jsonValue10.h) {
                                if (!jsonValue10.e.equals(this.a)) {
                                    r39.put(jsonValue10.e, k(cls6, null, jsonValue10));
                                }
                            }
                            return r39;
                        } else {
                            i(t4, r2);
                            return t4;
                        }
                    }
                    return (T) l("value", cls5, r2);
                }
            } else {
                cls3 = cls;
                jsonValue2 = r2;
            }
            if (cls3 != null) {
                d c3 = this.k.c(cls3);
                if (c3 != null) {
                    return (T) c3.a(this, jsonValue2, cls3);
                }
                if (d8.f(c.class, cls3)) {
                    T t5 = (T) h(cls3);
                    ((c) t5).a(this, jsonValue2);
                    return t5;
                }
            }
            int i = 0;
            if (jsonValue2.u()) {
                Class cls7 = cls3 != null ? cls3 : k6.class;
                if (d8.f(k6.class, cls7)) {
                    if (cls7 == k6.class) {
                        t3 = (T) new k6();
                    } else {
                        t3 = (T) ((k6) h(cls7));
                    }
                    for (JsonValue jsonValue11 = jsonValue2.f; jsonValue11 != null; jsonValue11 = jsonValue11.h) {
                        ((k6) t3).a(k(cls6, null, jsonValue11));
                    }
                    return t3;
                } else if (d8.f(m7.class, cls7)) {
                    if (cls7 == m7.class) {
                        t2 = (T) new m7();
                    } else {
                        t2 = (T) ((m7) h(cls7));
                    }
                    for (JsonValue jsonValue12 = jsonValue2.f; jsonValue12 != null; jsonValue12 = jsonValue12.h) {
                        ((m7) t2).addLast(k(cls6, null, jsonValue12));
                    }
                    return t2;
                } else if (d8.f(Collection.class, cls7)) {
                    if (cls7.isInterface()) {
                        t = (T) new ArrayList();
                    } else {
                        t = (T) ((Collection) h(cls7));
                    }
                    for (JsonValue jsonValue13 = jsonValue2.f; jsonValue13 != null; jsonValue13 = jsonValue13.h) {
                        ((Collection) t).add(k(cls6, null, jsonValue13));
                    }
                    return t;
                } else if (cls7.isArray()) {
                    Class<?> componentType = cls7.getComponentType();
                    Class<?> cls8 = cls6;
                    if (cls6 == null) {
                        cls8 = componentType;
                    }
                    T t6 = (T) c8.a(componentType, jsonValue2.j);
                    JsonValue jsonValue14 = jsonValue2.f;
                    while (jsonValue14 != null) {
                        c8.b(t6, i, k(cls8, null, jsonValue14));
                        jsonValue14 = jsonValue14.h;
                        i++;
                    }
                    return t6;
                } else {
                    throw new SerializationException("Unable to convert value to required type: " + jsonValue2 + " (" + cls7.getName() + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            boolean A = jsonValue2.A();
            JsonValue jsonValue15 = jsonValue2;
            if (A) {
                if (cls3 != null) {
                    if (cls3 != Float.TYPE && cls3 != Float.class) {
                        if (cls3 != Integer.TYPE && cls3 != Integer.class) {
                            if (cls3 != Long.TYPE && cls3 != Long.class) {
                                if (cls3 != Double.TYPE && cls3 != Double.class) {
                                    if (cls3 == String.class) {
                                        return (T) jsonValue2.j();
                                    }
                                    if (cls3 != Short.TYPE && cls3 != Short.class) {
                                        if (cls3 == Byte.TYPE || cls3 == Byte.class) {
                                            return (T) Byte.valueOf(jsonValue2.b());
                                        }
                                        jsonValue15 = new JsonValue(jsonValue2.j());
                                    }
                                    return (T) Short.valueOf(jsonValue2.h());
                                }
                                return (T) Double.valueOf(jsonValue2.c());
                            }
                            return (T) Long.valueOf(jsonValue2.g());
                        }
                        return (T) Integer.valueOf(jsonValue2.f());
                    }
                }
                return (T) Float.valueOf(jsonValue2.d());
            }
            if (!jsonValue15.v()) {
                cls4 = Boolean.class;
                jsonValue3 = jsonValue15;
            } else {
                if (cls3 != null) {
                    try {
                        if (cls3 != Boolean.TYPE) {
                            cls4 = Boolean.class;
                        }
                    } catch (NumberFormatException unused) {
                        cls4 = Boolean.class;
                    }
                }
                cls4 = Boolean.class;
                try {
                    return (T) Boolean.valueOf(jsonValue15.a());
                } catch (NumberFormatException unused2) {
                    jsonValue3 = new JsonValue(jsonValue15.j());
                    if (!jsonValue3.D()) {
                    }
                }
            }
            if (!jsonValue3.D()) {
                ?? r12 = (T) jsonValue3.j();
                if (cls3 != null && cls3 != String.class) {
                    if (cls3 != Integer.TYPE && cls3 != Integer.class) {
                        if (cls3 != Float.TYPE && cls3 != Float.class) {
                            if (cls3 != Long.TYPE && cls3 != Long.class) {
                                if (cls3 != Double.TYPE && cls3 != Double.class) {
                                    if (cls3 != Short.TYPE && cls3 != Short.class) {
                                        if (cls3 == Byte.TYPE || cls3 == Byte.class) {
                                            return (T) Byte.valueOf((String) r12);
                                        }
                                        if (cls3 != Boolean.TYPE && cls3 != cls4) {
                                            if (cls3 != Character.TYPE && cls3 != Character.class) {
                                                if (d8.f(Enum.class, cls3)) {
                                                    Enum[] enumArr = (Enum[]) cls3.getEnumConstants();
                                                    int length = enumArr.length;
                                                    while (i < length) {
                                                        ?? r5 = (T) enumArr[i];
                                                        if (r12.equals(b(r5))) {
                                                            return r5;
                                                        }
                                                        i++;
                                                    }
                                                }
                                                if (cls3 == CharSequence.class) {
                                                    return r12;
                                                }
                                                throw new SerializationException("Unable to convert value to required type: " + jsonValue3 + " (" + cls3.getName() + SmallTailInfo.EMOTION_SUFFIX);
                                            }
                                            return (T) Character.valueOf(r12.charAt(0));
                                        }
                                        return (T) Boolean.valueOf((String) r12);
                                    }
                                    return (T) Short.valueOf((String) r12);
                                }
                                return (T) Double.valueOf((String) r12);
                            }
                            return (T) Long.valueOf((String) r12);
                        }
                        return (T) Float.valueOf((String) r12);
                    }
                    return (T) Integer.valueOf((String) r12);
                }
                return r12;
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public <T> T l(String str, Class<T> cls, JsonValue jsonValue) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, cls, jsonValue)) == null) {
            return (T) k(cls, null, jsonValue.l(str));
        }
        return (T) invokeLLL.objValue;
    }

    public <T> T m(String str, Class<T> cls, Class cls2, JsonValue jsonValue) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, str, cls, cls2, jsonValue)) == null) {
            return (T) k(cls, cls2, jsonValue.l(str));
        }
        return (T) invokeLLLL.objValue;
    }

    public <T> T n(String str, Class<T> cls, T t, JsonValue jsonValue) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, str, cls, t, jsonValue)) == null) {
            JsonValue l = jsonValue.l(str);
            if (l == null) {
                return t;
            }
            return (T) k(cls, null, l);
        }
        return (T) invokeLLLL.objValue;
    }
}
