package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class ujb<M extends Message<M, B>, B extends Message.a<M, B>> extends ProtoAdapter<M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<M> a;
    public final Class<B> b;
    public final Map<Integer, pjb<M, B>> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ujb(Class<M> cls, Class<B> cls2, Map<Integer, pjb<M, B>> map) {
        super(FieldEncoding.LENGTH_DELIMITED, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cls;
        this.b = cls2;
        this.c = map;
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> ujb<M, B> a(Class<M> cls) {
        InterceptResult invokeL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            Class e = e(cls);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Field field : cls.getDeclaredFields()) {
                WireField wireField = (WireField) field.getAnnotation(WireField.class);
                if (wireField != null) {
                    linkedHashMap.put(Integer.valueOf(wireField.tag()), new pjb(wireField, field, e));
                }
            }
            return new ujb<>(cls, e, Collections.unmodifiableMap(linkedHashMap));
        }
        return (ujb) invokeL.objValue;
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> Class<B> e(Class<M> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            try {
                return (Class<B>) Class.forName(cls.getName() + "$Builder");
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
            }
        }
        return (Class) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: d */
    public int encodedSize(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m)) == null) {
            int i = m.cachedSerializedSize;
            if (i != 0) {
                return i;
            }
            int i2 = 0;
            for (pjb<M, B> pjbVar : this.c.values()) {
                Object b = pjbVar.b(m);
                if (b != null) {
                    i2 += pjbVar.a().encodedSizeWithTag(pjbVar.c, b);
                }
            }
            int size = i2 + m.unknownFields().size();
            m.cachedSerializedSize = size;
            return size;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: b */
    public M decode(rjb rjbVar) throws IOException {
        InterceptResult invokeL;
        ProtoAdapter<?> i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rjbVar)) == null) {
            B f = f();
            long c = rjbVar.c();
            while (true) {
                int f2 = rjbVar.f();
                if (f2 != -1) {
                    pjb<M, B> pjbVar = this.c.get(Integer.valueOf(f2));
                    if (pjbVar != null) {
                        try {
                            if (pjbVar.f()) {
                                i = pjbVar.a();
                            } else {
                                i = pjbVar.i();
                            }
                            pjbVar.j(f, i.decode(rjbVar));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                            f.addUnknownField(f2, FieldEncoding.VARINT, Long.valueOf(e.value));
                        }
                    } else {
                        FieldEncoding g = rjbVar.g();
                        f.addUnknownField(f2, g, g.rawProtoAdapter().decode(rjbVar));
                    }
                } else {
                    rjbVar.d(c);
                    return (M) f.build();
                }
            }
        } else {
            return (M) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: h */
    public String toString(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            StringBuilder sb = new StringBuilder();
            for (pjb<M, B> pjbVar : this.c.values()) {
                Object b = pjbVar.b(m);
                if (b != null) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(pjbVar.b);
                    sb.append('=');
                    if (pjbVar.f) {
                        b = "██";
                    }
                    sb.append(b);
                }
            }
            sb.replace(0, 2, this.a.getSimpleName() + '{');
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: c */
    public void encode(sjb sjbVar, M m) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sjbVar, m) == null) {
            for (pjb<M, B> pjbVar : this.c.values()) {
                Object b = pjbVar.b(m);
                if (b != null) {
                    pjbVar.a().encodeWithTag(sjbVar, pjbVar.c, b);
                }
            }
            sjbVar.k(m.unknownFields());
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if ((obj instanceof ujb) && ((ujb) obj).a == this.a) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public B f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return this.b.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                throw new AssertionError(e);
            }
        }
        return (B) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.hashCode();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: g */
    public M redact(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, m)) == null) {
            Message.a<M, B> newBuilder = m.newBuilder();
            for (pjb<M, B> pjbVar : this.c.values()) {
                if (pjbVar.f && pjbVar.a == WireField.Label.REQUIRED) {
                    throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", pjbVar.b, this.javaType.getName()));
                }
                boolean isAssignableFrom = Message.class.isAssignableFrom(pjbVar.i().javaType);
                if (!pjbVar.f && (!isAssignableFrom || pjbVar.a.isRepeated())) {
                    if (isAssignableFrom && pjbVar.a.isRepeated()) {
                        wjb.k((List) pjbVar.e(newBuilder), pjbVar.i());
                    }
                } else {
                    Object e = pjbVar.e(newBuilder);
                    if (e != null) {
                        pjbVar.h(newBuilder, pjbVar.a().redact(e));
                    }
                }
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
        return (M) invokeL.objValue;
    }
}
