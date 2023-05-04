package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class jy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ky6 a;
    public final List<qy6> b;
    public final List<qy6> c;
    public final lz6 d;
    public final lz6 e;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof jy6) {
                jy6 jy6Var = (jy6) obj;
                return Intrinsics.areEqual(this.a, jy6Var.a) && Intrinsics.areEqual(this.b, jy6Var.b) && Intrinsics.areEqual(this.c, jy6Var.c) && Intrinsics.areEqual(this.d, jy6Var.d) && Intrinsics.areEqual(this.e, jy6Var.e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            lz6 lz6Var = this.d;
            int hashCode2 = (hashCode + (lz6Var == null ? 0 : lz6Var.hashCode())) * 31;
            lz6 lz6Var2 = this.e;
            return hashCode2 + (lz6Var2 != null ? lz6Var2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "CardHeadData(imageData=" + this.a + ", mainData=" + this.b + ", extraData=" + this.c + ", statData=" + this.d + ", statData2=" + this.e + ')';
        }
        return (String) invokeV.objValue;
    }

    public jy6(ky6 imageData, List<? extends qy6> mainData, List<? extends qy6> extraData, lz6 lz6Var, lz6 lz6Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageData, mainData, extraData, lz6Var, lz6Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(imageData, "imageData");
        Intrinsics.checkNotNullParameter(mainData, "mainData");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.a = imageData;
        this.b = mainData;
        this.c = extraData;
        this.d = lz6Var;
        this.e = lz6Var2;
    }

    public final List<qy6> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final ky6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (ky6) invokeV.objValue;
    }

    public final List<qy6> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final lz6 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (lz6) invokeV.objValue;
    }

    public final lz6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (lz6) invokeV.objValue;
    }
}
