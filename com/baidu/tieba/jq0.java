package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.utils.ExtensionsKt;
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
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class jq0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a p;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947891808, "Lcom/baidu/tieba/jq0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947891808, "Lcom/baidu/tieba/jq0;");
                return;
            }
        }
        p = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof jq0) {
                    jq0 jq0Var = (jq0) obj;
                    return Intrinsics.areEqual(this.a, jq0Var.a) && Intrinsics.areEqual(this.b, jq0Var.b) && Intrinsics.areEqual(this.c, jq0Var.c) && Intrinsics.areEqual(this.d, jq0Var.d) && Intrinsics.areEqual(this.e, jq0Var.e) && Intrinsics.areEqual(this.f, jq0Var.f) && Intrinsics.areEqual(this.g, jq0Var.g) && Intrinsics.areEqual(this.h, jq0Var.h) && this.i == jq0Var.i && Intrinsics.areEqual(this.j, jq0Var.j) && Intrinsics.areEqual(this.k, jq0Var.k) && Intrinsics.areEqual(this.l, jq0Var.l) && Intrinsics.areEqual(this.m, jq0Var.m) && Intrinsics.areEqual(this.n, jq0Var.n) && Intrinsics.areEqual(this.o, jq0Var.o);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.e;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.f;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.g;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.h;
            int hashCode8 = (((hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.i) * 31;
            String str9 = this.j;
            int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.k;
            int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.l;
            int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
            String str12 = this.m;
            int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
            String str13 = this.n;
            int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
            String str14 = this.o;
            return hashCode13 + (str14 != null ? str14.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "RewardData(stayCmd=" + this.a + ", rewardCmd=" + this.b + ", taskFrom=" + this.c + ", token=" + this.d + ", uniqueId=" + this.e + ", taskId=" + this.f + ", activeUrl=" + this.g + ", timerFrontIcon=" + this.h + ", taskDuration=" + this.i + ", taskPolicy=" + this.j + ", timerText=" + this.k + ", timeDefaultCompleteText=" + this.l + ", timeCompleteLottieUrl=" + this.m + ", extPolicy=" + this.n + ", timeCompleteText=" + this.o + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
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
        public final jq0 a(JSONObject jsonObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonObject)) == null) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                String optString = jsonObject.optString("stay_cmd");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"stay_cmd\")");
                String optString2 = jsonObject.optString("reward_cmd");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"reward_cmd\")");
                String optString3 = jsonObject.optString("task_from");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"task_from\")");
                String b = ExtensionsKt.b(jsonObject, "token");
                String optString4 = jsonObject.optString("unique_id");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"unique_id\")");
                String b2 = ExtensionsKt.b(jsonObject, "task_id");
                String optString5 = jsonObject.optString("active_url");
                Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"active_url\")");
                String optString6 = jsonObject.optString("timer_front_icon");
                Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"timer_front_icon\")");
                int optInt = jsonObject.optInt("task_duration");
                String optString7 = jsonObject.optString("task_policy");
                Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(\"task_policy\")");
                String optString8 = jsonObject.optString("timer_text", "s后可领取奖励");
                Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(\"timer_te…ULT_PROGRESS_BUBBLE_TEXT)");
                String optString9 = jsonObject.optString("time_default_complete_text", "已完成任务");
                Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(\"time_def…\", DEFAULT_COMPLETE_TEXT)");
                String optString10 = jsonObject.optString("time_complete_lottie_url");
                Intrinsics.checkNotNullExpressionValue(optString10, "json.optString(\"time_complete_lottie_url\")");
                String optString11 = jsonObject.optString("extPolicy");
                Intrinsics.checkNotNullExpressionValue(optString11, "json.optString(\"extPolicy\")");
                String optString12 = jsonObject.optString("time_complete_text");
                Intrinsics.checkNotNullExpressionValue(optString12, "json.optString(\"time_complete_text\")");
                return new jq0(optString, optString2, optString3, b, optString4, b2, optString5, optString6, optInt, optString7, optString8, optString9, optString10, optString11, optString12);
            }
            return (jq0) invokeL.objValue;
        }
    }

    public jq0(String stayCmd, String rewardCmd, String taskFrom, String token, String uniqueId, String taskId, String activeUrl, String timerFrontIcon, int i, String taskPolicy, String timerText, String timeDefaultCompleteText, String timeCompleteLottieUrl, String extPolicy, String timeCompleteText) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {stayCmd, rewardCmd, taskFrom, token, uniqueId, taskId, activeUrl, timerFrontIcon, Integer.valueOf(i), taskPolicy, timerText, timeDefaultCompleteText, timeCompleteLottieUrl, extPolicy, timeCompleteText};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(stayCmd, "stayCmd");
        Intrinsics.checkNotNullParameter(rewardCmd, "rewardCmd");
        Intrinsics.checkNotNullParameter(taskFrom, "taskFrom");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(activeUrl, "activeUrl");
        Intrinsics.checkNotNullParameter(timerFrontIcon, "timerFrontIcon");
        Intrinsics.checkNotNullParameter(taskPolicy, "taskPolicy");
        Intrinsics.checkNotNullParameter(timerText, "timerText");
        Intrinsics.checkNotNullParameter(timeDefaultCompleteText, "timeDefaultCompleteText");
        Intrinsics.checkNotNullParameter(timeCompleteLottieUrl, "timeCompleteLottieUrl");
        Intrinsics.checkNotNullParameter(extPolicy, "extPolicy");
        Intrinsics.checkNotNullParameter(timeCompleteText, "timeCompleteText");
        this.a = stayCmd;
        this.b = rewardCmd;
        this.c = taskFrom;
        this.d = token;
        this.e = uniqueId;
        this.f = taskId;
        this.g = activeUrl;
        this.h = timerFrontIcon;
        this.i = i;
        this.j = taskPolicy;
        this.k = timerText;
        this.l = timeDefaultCompleteText;
        this.m = timeCompleteLottieUrl;
        this.n = extPolicy;
        this.o = timeCompleteText;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String jSONObject = ExtensionsKt.a(this.a).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "stayCmd.cmdToJsonObj().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String b(String count) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, count)) == null) {
            Intrinsics.checkNotNullParameter(count, "count");
            return StringsKt__StringsJVMKt.replace$default(this.o, "__COINTIPS__", count, false, 4, (Object) null);
        }
        return (String) invokeL.objValue;
    }

    public final String d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            return StringsKt__StringsJVMKt.replace$default(e(), "__REMAININGTIME__", String.valueOf(j), false, 4, (Object) null);
        }
        return (String) invokeJ.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String jSONObject = ExtensionsKt.a(this.b).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "rewardCmd.cmdToJsonObj().toString()");
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                str = "再看一个领取更多福利";
            }
            return StringsKt__StringsJVMKt.replace$default(jSONObject, "__COINTIPS__", str, false, 4, (Object) null);
        }
        return (String) invokeL.objValue;
    }
}
