package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ws0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948281013, "Lcom/baidu/tieba/ws0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948281013, "Lcom/baidu/tieba/ws0;");
                return;
            }
        }
        g = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof ws0) {
                    ws0 ws0Var = (ws0) obj;
                    return Intrinsics.areEqual(this.a, ws0Var.a) && Intrinsics.areEqual(this.b, ws0Var.b) && Intrinsics.areEqual(this.c, ws0Var.c) && Intrinsics.areEqual(this.d, ws0Var.d) && Intrinsics.areEqual(this.e, ws0Var.e) && this.f == ws0Var.f;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.e;
            return ((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "LottieDialogRewardData(coin=" + this.a + ", appendCoin=" + this.b + ", appendUrl=" + this.c + ", upperLimit=" + this.d + ", completeToast=" + this.e + ", countDownTime=" + this.f + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ws0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    String optString = jSONObject.optString("data");
                    if (optString == null) {
                        optString = "";
                    }
                    JSONObject jSONObject2 = new JSONObject(optString);
                    String optString2 = jSONObject2.optString("coin");
                    Intrinsics.checkNotNullExpressionValue(optString2, "dataJsonObject.optString(\"coin\")");
                    String optString3 = jSONObject2.optString("appendCoin");
                    Intrinsics.checkNotNullExpressionValue(optString3, "dataJsonObject.optString(\"appendCoin\")");
                    String optString4 = jSONObject2.optString("appendUrl");
                    Intrinsics.checkNotNullExpressionValue(optString4, "dataJsonObject.optString(\"appendUrl\")");
                    String optString5 = jSONObject2.optString("upperLimit");
                    Intrinsics.checkNotNullExpressionValue(optString5, "dataJsonObject.optString(\"upperLimit\")");
                    String optString6 = jSONObject2.optString("completeToast");
                    Intrinsics.checkNotNullExpressionValue(optString6, "dataJsonObject.optString(\"completeToast\")");
                    String optString7 = jSONObject2.optString("count_down");
                    Intrinsics.checkNotNullExpressionValue(optString7, "dataJsonObject.optString(\"count_down\")");
                    Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(optString7);
                    if (intOrNull != null) {
                        i = intOrNull.intValue();
                    } else {
                        i = 59;
                    }
                    return new ws0(optString2, optString3, optString4, optString5, optString6, i);
                }
                return null;
            }
            return (ws0) invokeL.objValue;
        }
    }

    public ws0(String coin, String appendCoin, String appendUrl, String upperLimit, String completeToast, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {coin, appendCoin, appendUrl, upperLimit, completeToast, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(coin, "coin");
        Intrinsics.checkNotNullParameter(appendCoin, "appendCoin");
        Intrinsics.checkNotNullParameter(appendUrl, "appendUrl");
        Intrinsics.checkNotNullParameter(upperLimit, "upperLimit");
        Intrinsics.checkNotNullParameter(completeToast, "completeToast");
        this.a = coin;
        this.b = appendCoin;
        this.c = appendUrl;
        this.d = upperLimit;
        this.e = completeToast;
        this.f = i;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f = i;
        }
    }
}
