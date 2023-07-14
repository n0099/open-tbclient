package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class r97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final w97 b;
    public final f97 c;
    public final String d;
    public final d87 e;
    public final String f;
    public final u97 g;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof r97) {
                r97 r97Var = (r97) obj;
                return this.a == r97Var.a && Intrinsics.areEqual(this.b, r97Var.b) && Intrinsics.areEqual(this.c, r97Var.c) && Intrinsics.areEqual(this.d, r97Var.d) && Intrinsics.areEqual(this.e, r97Var.e) && Intrinsics.areEqual(this.f, r97Var.f) && Intrinsics.areEqual(this.g, r97Var.g);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int hashCode = ((((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            u97 u97Var = this.g;
            return hashCode + (u97Var == null ? 0 : u97Var.hashCode());
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "RichTextData(type=" + this.a + ", textData=" + this.b + ", iconData=" + this.c + ", emoji=" + this.d + ", businessInfo=" + this.e + ", schema=" + this.f + ", statData=" + this.g + ')';
        }
        return (String) invokeV.objValue;
    }

    public r97(int i, w97 textData, f97 iconData, String emoji, d87 businessInfo, String schema, u97 u97Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), textData, iconData, emoji, businessInfo, schema, u97Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(iconData, "iconData");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
        Intrinsics.checkNotNullParameter(schema, "schema");
        this.a = i;
        this.b = textData;
        this.c = iconData;
        this.d = emoji;
        this.e = businessInfo;
        this.f = schema;
        this.g = u97Var;
    }

    public final d87 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (d87) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final f97 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (f97) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final u97 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (u97) invokeV.objValue;
    }

    public final w97 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (w97) invokeV.objValue;
    }

    public final int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }
}
