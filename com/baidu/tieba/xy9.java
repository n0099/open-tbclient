package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class xy9<M extends Message<M, B>, B extends Message.a<M, B>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WireField.Label a;
    public final String b;
    public final int c;
    public final String d;
    public final String e;
    public final boolean f;
    public final Field g;
    public final Field h;
    public final Method i;
    public ProtoAdapter<?> j;
    public ProtoAdapter<?> k;
    public ProtoAdapter<Object> l;

    public xy9(WireField wireField, Field field, Class<B> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wireField, field, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wireField.label();
        this.b = field.getName();
        this.c = wireField.tag();
        this.d = wireField.keyAdapter();
        this.e = wireField.adapter();
        this.f = wireField.redacted();
        this.g = field;
        this.h = c(cls, this.b);
        this.i = d(cls, this.b, field.getType());
    }

    public static Field c(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, str)) == null) {
            try {
                return cls.getField(str);
            } catch (NoSuchFieldException unused) {
                throw new AssertionError("No builder field " + cls.getName() + "." + str);
            }
        }
        return (Field) invokeLL.objValue;
    }

    public void j(B b, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, b, obj) == null) {
            if (this.a.isRepeated()) {
                ((List) e(b)).add(obj);
            } else if (!this.d.isEmpty()) {
                ((Map) e(b)).putAll((Map) obj);
            } else {
                h(b, obj);
            }
        }
    }

    public static Method d(Class<?> cls, String str, Class<?> cls2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, cls2)) == null) {
            try {
                return cls.getMethod(str, cls2);
            } catch (NoSuchMethodException unused) {
                throw new AssertionError("No builder method " + cls.getName() + "." + str + "(" + cls2.getName() + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public ProtoAdapter<Object> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ProtoAdapter<Object> protoAdapter = this.l;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            if (f()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(g(), i());
                this.l = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = i().withLabel(this.a);
            this.l = withLabel;
            return withLabel;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public Object b(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m)) == null) {
            try {
                return this.g.get(m);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
        return invokeL.objValue;
    }

    public Object e(B b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b)) == null) {
            try {
                return this.h.get(b);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
        return invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !this.d.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public ProtoAdapter<?> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ProtoAdapter<?> protoAdapter = this.k;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.d);
            this.k = protoAdapter2;
            return protoAdapter2;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public ProtoAdapter<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ProtoAdapter<?> protoAdapter = this.j;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.e);
            this.j = protoAdapter2;
            return protoAdapter2;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public void h(B b, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, b, obj) == null) {
            try {
                if (this.a.isOneOf()) {
                    this.i.invoke(b, obj);
                } else {
                    this.h.set(b, obj);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError(e);
            }
        }
    }
}
