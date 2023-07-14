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
public final class o97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public final String c;
    public final String d;
    public u97 e;
    public u97 f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof o97) {
                o97 o97Var = (o97) obj;
                return this.a == o97Var.a && this.b == o97Var.b && Intrinsics.areEqual(this.c, o97Var.c) && Intrinsics.areEqual(this.d, o97Var.d) && Intrinsics.areEqual(this.e, o97Var.e) && Intrinsics.areEqual(this.f, o97Var.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            boolean z = this.a;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int hashCode = ((((((r0 * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            u97 u97Var = this.e;
            int hashCode2 = (hashCode + (u97Var == null ? 0 : u97Var.hashCode())) * 31;
            u97 u97Var2 = this.f;
            return hashCode2 + (u97Var2 != null ? u97Var2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "PersonAttentionData(isLike=" + this.a + ", likeStatus=" + this.b + ", userId=" + this.c + ", portrait=" + this.d + ", followStatData=" + this.e + ", unfollowStatData=" + this.f + ')';
        }
        return (String) invokeV.objValue;
    }

    public o97(boolean z, int i, String userId, String portrait, u97 u97Var, u97 u97Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), userId, portrait, u97Var, u97Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(portrait, "portrait");
        this.a = z;
        this.b = i;
        this.c = userId;
        this.d = portrait;
        this.e = u97Var;
        this.f = u97Var2;
    }

    public final u97 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (u97) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final u97 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (u97) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.a = z;
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = i;
        }
    }
}
