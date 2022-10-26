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
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class yt9 extends ProtoAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class a;
    public final Class b;
    public final Map c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yt9(Class cls, Class cls2, Map map) {
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

    public static yt9 a(Class cls) {
        InterceptResult invokeL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            Class e = e(cls);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Field field : cls.getDeclaredFields()) {
                WireField wireField = (WireField) field.getAnnotation(WireField.class);
                if (wireField != null) {
                    linkedHashMap.put(Integer.valueOf(wireField.tag()), new tt9(wireField, field, e));
                }
            }
            return new yt9(cls, e, Collections.unmodifiableMap(linkedHashMap));
        }
        return (yt9) invokeL.objValue;
    }

    public static Class e(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            try {
                return Class.forName(cls.getName() + "$Builder");
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
            }
        }
        return (Class) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: d */
    public int encodedSize(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message)) == null) {
            int i = message.cachedSerializedSize;
            if (i != 0) {
                return i;
            }
            int i2 = 0;
            for (tt9 tt9Var : this.c.values()) {
                Object b = tt9Var.b(message);
                if (b != null) {
                    i2 += tt9Var.a().encodedSizeWithTag(tt9Var.c, b);
                }
            }
            int size = i2 + message.unknownFields().size();
            message.cachedSerializedSize = size;
            return size;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: b */
    public Message decode(vt9 vt9Var) throws IOException {
        InterceptResult invokeL;
        ProtoAdapter i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
            Message.a f = f();
            long c = vt9Var.c();
            while (true) {
                int f2 = vt9Var.f();
                if (f2 != -1) {
                    tt9 tt9Var = (tt9) this.c.get(Integer.valueOf(f2));
                    if (tt9Var != null) {
                        try {
                            if (tt9Var.f()) {
                                i = tt9Var.a();
                            } else {
                                i = tt9Var.i();
                            }
                            tt9Var.j(f, i.decode(vt9Var));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                            f.addUnknownField(f2, FieldEncoding.VARINT, Long.valueOf(e.value));
                        }
                    } else {
                        FieldEncoding g = vt9Var.g();
                        f.addUnknownField(f2, g, g.rawProtoAdapter().decode(vt9Var));
                    }
                } else {
                    vt9Var.d(c);
                    return f.build();
                }
            }
        } else {
            return (Message) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: h */
    public String toString(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, message)) == null) {
            StringBuilder sb = new StringBuilder();
            for (tt9 tt9Var : this.c.values()) {
                Object b = tt9Var.b(message);
                if (b != null) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(tt9Var.b);
                    sb.append('=');
                    if (tt9Var.f) {
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
    public void encode(wt9 wt9Var, Message message) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, message) == null) {
            for (tt9 tt9Var : this.c.values()) {
                Object b = tt9Var.b(message);
                if (b != null) {
                    tt9Var.a().encodeWithTag(wt9Var, tt9Var.c, b);
                }
            }
            wt9Var.k(message.unknownFields());
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if ((obj instanceof yt9) && ((yt9) obj).a == this.a) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Message.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return (Message.a) this.b.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                throw new AssertionError(e);
            }
        }
        return (Message.a) invokeV.objValue;
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
    public Message redact(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message)) == null) {
            Message.a newBuilder = message.newBuilder();
            for (tt9 tt9Var : this.c.values()) {
                if (tt9Var.f && tt9Var.a == WireField.Label.REQUIRED) {
                    throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", tt9Var.b, this.javaType.getName()));
                }
                boolean isAssignableFrom = Message.class.isAssignableFrom(tt9Var.i().javaType);
                if (!tt9Var.f && (!isAssignableFrom || tt9Var.a.isRepeated())) {
                    if (isAssignableFrom && tt9Var.a.isRepeated()) {
                        au9.k((List) tt9Var.e(newBuilder), tt9Var.i());
                    }
                } else {
                    Object e = tt9Var.e(newBuilder);
                    if (e != null) {
                        tt9Var.h(newBuilder, tt9Var.a().redact(e));
                    }
                }
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
        return (Message) invokeL.objValue;
    }
}
