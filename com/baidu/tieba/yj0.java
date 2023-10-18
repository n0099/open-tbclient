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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class yj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948331946, "Lcom/baidu/tieba/yj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948331946, "Lcom/baidu/tieba/yj0;");
                return;
            }
        }
        f = new a(null);
    }

    @JvmStatic
    public static final yj0 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? f.a(jSONObject) : (yj0) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof yj0) {
                    yj0 yj0Var = (yj0) obj;
                    return Intrinsics.areEqual(this.a, yj0Var.a) && Intrinsics.areEqual(this.b, yj0Var.b) && Intrinsics.areEqual(this.c, yj0Var.c) && Intrinsics.areEqual(this.d, yj0Var.d) && Intrinsics.areEqual(this.e, yj0Var.e);
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
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "NadTaskRewardResponse(reward=" + this.a + ", rewardTips=" + this.b + ", upperLimit=" + this.c + ", videoDownloadCoin=" + this.d + ", videoDownloadActiveUrl=" + this.e + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
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

        @JvmStatic
        public final yj0 a(JSONObject jsonObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonObject)) == null) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                String optString = jsonObject.optString("coin");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(\"coin\")");
                String optString2 = jsonObject.optString("coinTips", "再看一个领取更多福利");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"coinTips\", DEFAULT_COIN_TIPS)");
                String optString3 = jsonObject.optString("upperLimit", "0");
                Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"upperLimit\", \"0\")");
                String optString4 = jsonObject.optString("videoDownloadCoin");
                Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"videoDownloadCoin\")");
                String optString5 = jsonObject.optString("videoDownloadActiveUrl");
                Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"videoDownloadActiveUrl\")");
                return new yj0(optString, optString2, optString3, optString4, optString5);
            }
            return (yj0) invokeL.objValue;
        }
    }

    public yj0(String reward, String rewardTips, String upperLimit, String videoDownloadCoin, String videoDownloadActiveUrl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reward, rewardTips, upperLimit, videoDownloadCoin, videoDownloadActiveUrl};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(reward, "reward");
        Intrinsics.checkNotNullParameter(rewardTips, "rewardTips");
        Intrinsics.checkNotNullParameter(upperLimit, "upperLimit");
        Intrinsics.checkNotNullParameter(videoDownloadCoin, "videoDownloadCoin");
        Intrinsics.checkNotNullParameter(videoDownloadActiveUrl, "videoDownloadActiveUrl");
        this.a = reward;
        this.b = rewardTips;
        this.c = upperLimit;
        this.d = videoDownloadCoin;
        this.e = videoDownloadActiveUrl;
    }

    public final boolean a() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.e.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return Intrinsics.areEqual(this.c, "1");
        }
        return invokeV.booleanValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }
}
