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
/* loaded from: classes6.dex */
public final class kyb<M extends Message<M, B>, B extends Message.a<M, B>> extends ProtoAdapter<M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<M> a;
    public final Class<B> b;
    public final Map<Integer, fyb<M, B>> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kyb(Class<M> cls, Class<B> cls2, Map<Integer, fyb<M, B>> map) {
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

    public static <M extends Message<M, B>, B extends Message.a<M, B>> kyb<M, B> a(Class<M> cls) {
        InterceptResult invokeL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            Class e = e(cls);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Field field : cls.getDeclaredFields()) {
                WireField wireField = (WireField) field.getAnnotation(WireField.class);
                if (wireField != null) {
                    linkedHashMap.put(Integer.valueOf(wireField.tag()), new fyb(wireField, field, e));
                }
            }
            return new kyb<>(cls, e, Collections.unmodifiableMap(linkedHashMap));
        }
        return (kyb) invokeL.objValue;
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
            for (fyb<M, B> fybVar : this.c.values()) {
                Object b = fybVar.b(m);
                if (b != null) {
                    i2 += fybVar.a().encodedSizeWithTag(fybVar.c, b);
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
    public M decode(hyb hybVar) throws IOException {
        InterceptResult invokeL;
        ProtoAdapter<?> i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hybVar)) == null) {
            B f = f();
            long c = hybVar.c();
            while (true) {
                int f2 = hybVar.f();
                if (f2 != -1) {
                    fyb<M, B> fybVar = this.c.get(Integer.valueOf(f2));
                    if (fybVar != null) {
                        try {
                            if (fybVar.f()) {
                                i = fybVar.a();
                            } else {
                                i = fybVar.i();
                            }
                            fybVar.j(f, i.decode(hybVar));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                            f.addUnknownField(f2, FieldEncoding.VARINT, Long.valueOf(e.value));
                        }
                    } else {
                        FieldEncoding g = hybVar.g();
                        f.addUnknownField(f2, g, g.rawProtoAdapter().decode(hybVar));
                    }
                } else {
                    hybVar.d(c);
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
            for (fyb<M, B> fybVar : this.c.values()) {
                Object b = fybVar.b(m);
                if (b != null) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(fybVar.b);
                    sb.append('=');
                    if (fybVar.f) {
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
    public void encode(iyb iybVar, M m) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iybVar, m) == null) {
            for (fyb<M, B> fybVar : this.c.values()) {
                Object b = fybVar.b(m);
                if (b != null) {
                    fybVar.a().encodeWithTag(iybVar, fybVar.c, b);
                }
            }
            iybVar.k(m.unknownFields());
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if ((obj instanceof kyb) && ((kyb) obj).a == this.a) {
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
            for (fyb<M, B> fybVar : this.c.values()) {
                if (fybVar.f && fybVar.a == WireField.Label.REQUIRED) {
                    throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", fybVar.b, this.javaType.getName()));
                }
                boolean isAssignableFrom = Message.class.isAssignableFrom(fybVar.i().javaType);
                if (!fybVar.f && (!isAssignableFrom || fybVar.a.isRepeated())) {
                    if (isAssignableFrom && fybVar.a.isRepeated()) {
                        myb.k((List) fybVar.e(newBuilder), fybVar.i());
                    }
                } else {
                    Object e = fybVar.e(newBuilder);
                    if (e != null) {
                        fybVar.h(newBuilder, fybVar.a().redact(e));
                    }
                }
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
        return (M) invokeL.objValue;
    }
}
