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
import com.baidu.tieba.x7;
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
/* loaded from: classes5.dex */
public class p7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public d g;
    public final x7 h;
    public final x7 i;
    public final x7 j;
    public final x7 k;
    public final Object[] l;
    public final Object[] m;

    /* loaded from: classes5.dex */
    public interface c {
        void a(p7 p7Var, JsonValue jsonValue);
    }

    /* loaded from: classes5.dex */
    public interface d {
        Object a(p7 p7Var, JsonValue jsonValue, Class cls);
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

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final w8 a;
        public Class b;
        public boolean c;

        public a(w8 w8Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w8Var;
            if (!u8.f(x7.class, w8Var.getType()) && !u8.f(Map.class, w8Var.getType())) {
                i = 0;
            } else {
                i = 1;
            }
            this.b = w8Var.c(i);
            this.c = w8Var.f(Deprecated.class);
        }
    }

    /* loaded from: classes5.dex */
    public abstract class b implements d {
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

    public p7() {
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
        this.h = new x7();
        this.i = new x7();
        this.j = new x7();
        this.k = new x7();
        new x7();
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

    public Object j(Class cls, JsonValue jsonValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, cls, jsonValue)) == null) {
            return k(cls, null, jsonValue);
        }
        return invokeLL.objValue;
    }

    public void o(Class cls, d dVar) {
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
            return (Class) this.i.c(str);
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
            z7 f = f(obj2.getClass());
            x7.a it = f(obj.getClass()).iterator();
            while (it.hasNext()) {
                x7.b bVar = (x7.b) it.next();
                a aVar = (a) f.c(bVar.a);
                w8 w8Var = ((a) bVar.b).a;
                if (aVar != null) {
                    try {
                        aVar.a.j(obj2, w8Var.a(obj));
                    } catch (ReflectionException e) {
                        throw new SerializationException("Error copying field: " + w8Var.d(), e);
                    }
                } else {
                    throw new SerializationException("To object is missing field: " + ((String) bVar.a));
                }
            }
        }
    }

    public Object d(Class cls, k3 k3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, k3Var)) == null) {
            try {
                return k(cls, null, new q7().a(k3Var));
            } catch (Exception e) {
                throw new SerializationException("Error reading file: " + k3Var, e);
            }
        }
        return invokeLL.objValue;
    }

    public final z7 f(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            z7 z7Var = (z7) this.h.c(cls);
            if (z7Var != null) {
                return z7Var;
            }
            b7 b7Var = new b7();
            for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                b7Var.a(cls2);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = b7Var.b - 1; i >= 0; i--) {
                Collections.addAll(arrayList, u8.d((Class) b7Var.get(i)));
            }
            z7 z7Var2 = new z7(arrayList.size());
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                w8 w8Var = (w8) arrayList.get(i2);
                if (!w8Var.i() && !w8Var.g() && !w8Var.h()) {
                    if (!w8Var.e()) {
                        try {
                            w8Var.k(true);
                        } catch (AccessControlException unused) {
                        }
                    }
                    z7Var2.i(w8Var.d(), new a(w8Var));
                }
            }
            if (this.f) {
                z7Var2.o.m();
            }
            this.h.i(cls, z7Var2);
            return z7Var2;
        }
        return (z7) invokeL.objValue;
    }

    public Object h(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            try {
                return u8.i(cls);
            } catch (Exception e) {
                e = e;
                try {
                    v8 c2 = u8.c(cls, new Class[0]);
                    c2.c(true);
                    return c2.b(new Object[0]);
                } catch (ReflectionException unused) {
                    if (u8.f(Enum.class, cls)) {
                        if (cls.getEnumConstants() == null) {
                            cls = cls.getSuperclass();
                        }
                        return cls.getEnumConstants()[0];
                    } else if (!cls.isArray()) {
                        if (u8.g(cls) && !u8.h(cls)) {
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
            z7 f = f(cls);
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                a aVar = (a) f.c(jsonValue2.G().replace(" ", "_"));
                if (aVar == null) {
                    if (!jsonValue2.e.equals(this.a) && !this.b && !g(cls, jsonValue2.e)) {
                        SerializationException serializationException = new SerializationException("Field not found: " + jsonValue2.e + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        serializationException.addTrace(jsonValue2.Q());
                        throw serializationException;
                    }
                } else if (!this.c || this.d || !aVar.c) {
                    w8 w8Var = aVar.a;
                    try {
                        w8Var.j(obj, k(w8Var.getType(), aVar.b, jsonValue2));
                    } catch (SerializationException e) {
                        e.addTrace(w8Var.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        throw e;
                    } catch (ReflectionException e2) {
                        throw new SerializationException("Error accessing field: " + w8Var.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX, e2);
                    } catch (RuntimeException e3) {
                        SerializationException serializationException2 = new SerializationException(e3);
                        serializationException2.addTrace(jsonValue2.Q());
                        serializationException2.addTrace(w8Var.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        throw serializationException2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:225:0x0354, code lost:
        if (r13 == r0) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0431 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object k(Class cls, Class cls2, JsonValue jsonValue) {
        InterceptResult invokeLLL;
        Class cls3;
        Class cls4;
        Collection collection;
        d8 d8Var;
        b7 b7Var;
        String r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, cls, cls2, jsonValue)) == null) {
            Class<?> cls5 = cls2;
            JsonValue jsonValue2 = jsonValue;
            if (jsonValue2 == null) {
                return null;
            }
            if (jsonValue.C()) {
                String str = this.a;
                if (str == null) {
                    r = null;
                } else {
                    r = jsonValue2.r(str, null);
                }
                if (r != null) {
                    Class e = e(r);
                    if (e == null) {
                        try {
                            cls3 = u8.a(r);
                        } catch (ReflectionException e2) {
                            throw new SerializationException(e2);
                        }
                    } else {
                        cls3 = e;
                    }
                } else {
                    cls3 = cls;
                }
                if (cls3 == null) {
                    d dVar = this.g;
                    if (dVar != null) {
                        return dVar.a(this, jsonValue2, cls3);
                    }
                    return jsonValue2;
                } else if (this.a != null && u8.f(Collection.class, cls3)) {
                    jsonValue2 = jsonValue2.l("items");
                    if (jsonValue2 == null) {
                        throw new SerializationException("Unable to convert object to collection: " + jsonValue2 + " (" + cls3.getName() + SmallTailInfo.EMOTION_SUFFIX);
                    }
                } else {
                    d dVar2 = (d) this.k.c(cls3);
                    if (dVar2 != null) {
                        return dVar2.a(this, jsonValue2, cls3);
                    }
                    if (cls3 != String.class && cls3 != Integer.class && cls3 != Boolean.class && cls3 != Float.class && cls3 != Long.class && cls3 != Double.class && cls3 != Short.class && cls3 != Byte.class && cls3 != Character.class && !u8.f(Enum.class, cls3)) {
                        Object h = h(cls3);
                        if (h instanceof c) {
                            ((c) h).a(this, jsonValue2);
                            return h;
                        } else if (h instanceof x7) {
                            x7 x7Var = (x7) h;
                            for (JsonValue jsonValue3 = jsonValue2.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                                x7Var.i(jsonValue3.e, k(cls5, null, jsonValue3));
                            }
                            return x7Var;
                        } else if (h instanceof w7) {
                            w7 w7Var = (w7) h;
                            for (JsonValue jsonValue4 = jsonValue2.f; jsonValue4 != null; jsonValue4 = jsonValue4.h) {
                                w7Var.h(jsonValue4.e, ((Integer) k(Integer.class, null, jsonValue4)).intValue());
                            }
                            return w7Var;
                        } else if (h instanceof v7) {
                            v7 v7Var = (v7) h;
                            for (JsonValue jsonValue5 = jsonValue2.f; jsonValue5 != null; jsonValue5 = jsonValue5.h) {
                                v7Var.g(jsonValue5.e, ((Float) k(Float.class, null, jsonValue5)).floatValue());
                            }
                            return v7Var;
                        } else if (h instanceof y7) {
                            y7 y7Var = (y7) h;
                            for (JsonValue m = jsonValue2.m(SavedStateHandle.VALUES); m != null; m = m.h) {
                                y7Var.add(k(cls5, null, m));
                            }
                            return y7Var;
                        } else if (h instanceof n7) {
                            n7 n7Var = (n7) h;
                            for (JsonValue jsonValue6 = jsonValue2.f; jsonValue6 != null; jsonValue6 = jsonValue6.h) {
                                n7Var.e(Integer.parseInt(jsonValue6.e), k(cls5, null, jsonValue6));
                            }
                            return n7Var;
                        } else if (h instanceof t7) {
                            t7 t7Var = (t7) h;
                            for (JsonValue jsonValue7 = jsonValue2.f; jsonValue7 != null; jsonValue7 = jsonValue7.h) {
                                t7Var.f(Long.parseLong(jsonValue7.e), k(cls5, null, jsonValue7));
                            }
                            return t7Var;
                        } else if (h instanceof o7) {
                            o7 o7Var = (o7) h;
                            for (JsonValue m2 = jsonValue2.m(SavedStateHandle.VALUES); m2 != null; m2 = m2.h) {
                                o7Var.a(m2.f());
                            }
                            return o7Var;
                        } else if (h instanceof c7) {
                            c7 c7Var = (c7) h;
                            for (JsonValue jsonValue8 = jsonValue2.f; jsonValue8 != null; jsonValue8 = jsonValue8.h) {
                                c7Var.e(jsonValue8.e, k(cls5, null, jsonValue8));
                            }
                            return c7Var;
                        } else if (h instanceof Map) {
                            Map map = (Map) h;
                            for (JsonValue jsonValue9 = jsonValue2.f; jsonValue9 != null; jsonValue9 = jsonValue9.h) {
                                if (!jsonValue9.e.equals(this.a)) {
                                    map.put(jsonValue9.e, k(cls5, null, jsonValue9));
                                }
                            }
                            return map;
                        } else {
                            i(h, jsonValue2);
                            return h;
                        }
                    }
                    return l("value", cls3, jsonValue2);
                }
            } else {
                cls3 = cls;
            }
            if (cls3 != null) {
                d dVar3 = (d) this.k.c(cls3);
                if (dVar3 != null) {
                    return dVar3.a(this, jsonValue2, cls3);
                }
                if (u8.f(c.class, cls3)) {
                    Object h2 = h(cls3);
                    ((c) h2).a(this, jsonValue2);
                    return h2;
                }
            }
            int i = 0;
            if (jsonValue2.u()) {
                cls3 = (cls3 == null || cls3 == Object.class) ? b7.class : b7.class;
                if (u8.f(b7.class, cls3)) {
                    if (cls3 == b7.class) {
                        b7Var = new b7();
                    } else {
                        b7Var = (b7) h(cls3);
                    }
                    for (JsonValue jsonValue10 = jsonValue2.f; jsonValue10 != null; jsonValue10 = jsonValue10.h) {
                        b7Var.a(k(cls5, null, jsonValue10));
                    }
                    return b7Var;
                } else if (u8.f(d8.class, cls3)) {
                    if (cls3 == d8.class) {
                        d8Var = new d8();
                    } else {
                        d8Var = (d8) h(cls3);
                    }
                    for (JsonValue jsonValue11 = jsonValue2.f; jsonValue11 != null; jsonValue11 = jsonValue11.h) {
                        d8Var.addLast(k(cls5, null, jsonValue11));
                    }
                    return d8Var;
                } else if (u8.f(Collection.class, cls3)) {
                    if (cls3.isInterface()) {
                        collection = new ArrayList();
                    } else {
                        collection = (Collection) h(cls3);
                    }
                    for (JsonValue jsonValue12 = jsonValue2.f; jsonValue12 != null; jsonValue12 = jsonValue12.h) {
                        collection.add(k(cls5, null, jsonValue12));
                    }
                    return collection;
                } else if (cls3.isArray()) {
                    Class<?> componentType = cls3.getComponentType();
                    if (cls5 == null) {
                        cls5 = componentType;
                    }
                    Object a2 = t8.a(componentType, jsonValue2.j);
                    JsonValue jsonValue13 = jsonValue2.f;
                    while (jsonValue13 != null) {
                        t8.b(a2, i, k(cls5, null, jsonValue13));
                        jsonValue13 = jsonValue13.h;
                        i++;
                    }
                    return a2;
                } else {
                    throw new SerializationException("Unable to convert value to required type: " + jsonValue2 + " (" + cls3.getName() + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            if (jsonValue2.A()) {
                if (cls3 != null) {
                    if (cls3 != Float.TYPE && cls3 != Float.class) {
                        if (cls3 != Integer.TYPE && cls3 != Integer.class) {
                            if (cls3 != Long.TYPE && cls3 != Long.class) {
                                if (cls3 != Double.TYPE && cls3 != Double.class) {
                                    if (cls3 == String.class) {
                                        return jsonValue2.j();
                                    }
                                    if (cls3 != Short.TYPE && cls3 != Short.class) {
                                        if (cls3 == Byte.TYPE || cls3 == Byte.class) {
                                            return Byte.valueOf(jsonValue2.b());
                                        }
                                        jsonValue2 = new JsonValue(jsonValue2.j());
                                    }
                                    return Short.valueOf(jsonValue2.h());
                                }
                                return Double.valueOf(jsonValue2.c());
                            }
                            return Long.valueOf(jsonValue2.g());
                        }
                        return Integer.valueOf(jsonValue2.f());
                    }
                }
                return Float.valueOf(jsonValue2.d());
            }
            if (!jsonValue2.v()) {
                cls4 = Boolean.class;
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
                    return Boolean.valueOf(jsonValue2.a());
                } catch (NumberFormatException unused2) {
                    jsonValue2 = new JsonValue(jsonValue2.j());
                    if (!jsonValue2.D()) {
                    }
                }
            }
            if (!jsonValue2.D()) {
                String j = jsonValue2.j();
                if (cls3 != null && cls3 != String.class) {
                    if (cls3 != Integer.TYPE && cls3 != Integer.class) {
                        if (cls3 != Float.TYPE && cls3 != Float.class) {
                            if (cls3 != Long.TYPE && cls3 != Long.class) {
                                if (cls3 != Double.TYPE && cls3 != Double.class) {
                                    if (cls3 != Short.TYPE && cls3 != Short.class) {
                                        if (cls3 == Byte.TYPE || cls3 == Byte.class) {
                                            return Byte.valueOf(j);
                                        }
                                        if (cls3 != Boolean.TYPE && cls3 != cls4) {
                                            if (cls3 != Character.TYPE && cls3 != Character.class) {
                                                if (u8.f(Enum.class, cls3)) {
                                                    Enum[] enumArr = (Enum[]) cls3.getEnumConstants();
                                                    int length = enumArr.length;
                                                    while (i < length) {
                                                        Enum r5 = enumArr[i];
                                                        if (j.equals(b(r5))) {
                                                            return r5;
                                                        }
                                                        i++;
                                                    }
                                                }
                                                if (cls3 == CharSequence.class) {
                                                    return j;
                                                }
                                                throw new SerializationException("Unable to convert value to required type: " + jsonValue2 + " (" + cls3.getName() + SmallTailInfo.EMOTION_SUFFIX);
                                            }
                                            return Character.valueOf(j.charAt(0));
                                        }
                                        return Boolean.valueOf(j);
                                    }
                                    return Short.valueOf(j);
                                }
                                return Double.valueOf(j);
                            }
                            return Long.valueOf(j);
                        }
                        return Float.valueOf(j);
                    }
                    return Integer.valueOf(j);
                }
                return j;
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    public Object l(String str, Class cls, JsonValue jsonValue) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, cls, jsonValue)) == null) {
            return k(cls, null, jsonValue.l(str));
        }
        return invokeLLL.objValue;
    }

    public Object m(String str, Class cls, Class cls2, JsonValue jsonValue) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, str, cls, cls2, jsonValue)) == null) {
            return k(cls, cls2, jsonValue.l(str));
        }
        return invokeLLLL.objValue;
    }

    public Object n(String str, Class cls, Object obj, JsonValue jsonValue) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, str, cls, obj, jsonValue)) == null) {
            JsonValue l = jsonValue.l(str);
            if (l == null) {
                return obj;
            }
            return k(cls, null, l);
        }
        return invokeLLLL.objValue;
    }
}
