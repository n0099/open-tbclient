package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
/* loaded from: classes6.dex */
public final class z66 implements ReadWriteProperty {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function1 a;
    public Comparable b;

    public z66(Comparable initial, Function1 onChange) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {initial, onChange};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        this.a = onChange;
        this.b = initial;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    /* renamed from: a */
    public Comparable getValue(Object thisRef, KProperty property) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, thisRef, property)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            return this.b;
        }
        return (Comparable) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.properties.ReadWriteProperty
    /* renamed from: b */
    public void setValue(Object thisRef, KProperty property, Comparable value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thisRef, property, value) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            Intrinsics.checkNotNullParameter(value, "value");
            Comparable comparable = this.b;
            this.b = value;
            if (!Intrinsics.areEqual(comparable, value)) {
                this.a.invoke(value);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b.toString();
        }
        return (String) invokeV.objValue;
    }
}
