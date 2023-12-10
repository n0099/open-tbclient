package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class oi7 implements lm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<mi7> a;
    public final mi7 b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof oi7) {
                oi7 oi7Var = (oi7) obj;
                return Intrinsics.areEqual(this.a, oi7Var.a) && Intrinsics.areEqual(this.b, oi7Var.b) && Intrinsics.areEqual(this.c, oi7Var.c) && Intrinsics.areEqual(this.d, oi7Var.d) && Intrinsics.areEqual(this.e, oi7Var.e) && Intrinsics.areEqual(this.f, oi7Var.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "AiSecondFloorData(botList=" + this.a + ", selectedBot=" + this.b + ", guideText=" + this.c + ", maskImgUrl=" + this.d + ", titleImgUrl=" + this.e + ", aiPageUrl=" + this.f + ')';
        }
        return (String) invokeV.objValue;
    }

    public oi7(List<mi7> botList, mi7 selectedBot, String guideText, String maskImgUrl, String titleImgUrl, String aiPageUrl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {botList, selectedBot, guideText, maskImgUrl, titleImgUrl, aiPageUrl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(botList, "botList");
        Intrinsics.checkNotNullParameter(selectedBot, "selectedBot");
        Intrinsics.checkNotNullParameter(guideText, "guideText");
        Intrinsics.checkNotNullParameter(maskImgUrl, "maskImgUrl");
        Intrinsics.checkNotNullParameter(titleImgUrl, "titleImgUrl");
        Intrinsics.checkNotNullParameter(aiPageUrl, "aiPageUrl");
        this.a = botList;
        this.b = selectedBot;
        this.c = guideText;
        this.d = maskImgUrl;
        this.e = titleImgUrl;
        this.f = aiPageUrl;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final List<mi7> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final mi7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (mi7) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }
}
