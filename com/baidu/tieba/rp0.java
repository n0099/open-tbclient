package com.baidu.tieba;

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
/* loaded from: classes5.dex */
public final class rp0 {
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

    /* loaded from: classes5.dex */
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

        @JvmStatic
        public final rp0 a(JSONObject jsonObject) {
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
                String a = u21.a(jsonObject, "token");
                String optString4 = jsonObject.optString("unique_id");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"unique_id\")");
                String a2 = u21.a(jsonObject, "task_id");
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
                return new rp0(optString, optString2, optString3, a, optString4, a2, optString5, optString6, optInt, optString7, optString8, optString9, optString10, optString11, optString12);
            }
            return (rp0) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948129175, "Lcom/baidu/tieba/rp0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948129175, "Lcom/baidu/tieba/rp0;");
                return;
            }
        }
        p = new a(null);
    }

    public rp0(String stayCmd, String rewardCmd, String taskFrom, String token, String uniqueId, String taskId, String activeUrl, String timerFrontIcon, int i, String taskPolicy, String timerText, String timeDefaultCompleteText, String timeCompleteLottieUrl, String extPolicy, String timeCompleteText) {
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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof rp0) {
                    rp0 rp0Var = (rp0) obj;
                    return Intrinsics.areEqual(this.a, rp0Var.a) && Intrinsics.areEqual(this.b, rp0Var.b) && Intrinsics.areEqual(this.c, rp0Var.c) && Intrinsics.areEqual(this.d, rp0Var.d) && Intrinsics.areEqual(this.e, rp0Var.e) && Intrinsics.areEqual(this.f, rp0Var.f) && Intrinsics.areEqual(this.g, rp0Var.g) && Intrinsics.areEqual(this.h, rp0Var.h) && this.i == rp0Var.i && Intrinsics.areEqual(this.j, rp0Var.j) && Intrinsics.areEqual(this.k, rp0Var.k) && Intrinsics.areEqual(this.l, rp0Var.l) && Intrinsics.areEqual(this.m, rp0Var.m) && Intrinsics.areEqual(this.n, rp0Var.n) && Intrinsics.areEqual(this.o, rp0Var.o);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "RewardData(stayCmd=" + this.a + ", rewardCmd=" + this.b + ", taskFrom=" + this.c + ", token=" + this.d + ", uniqueId=" + this.e + ", taskId=" + this.f + ", activeUrl=" + this.g + ", timerFrontIcon=" + this.h + ", taskDuration=" + this.i + ", taskPolicy=" + this.j + ", timerText=" + this.k + ", timeDefaultCompleteText=" + this.l + ", timeCompleteLottieUrl=" + this.m + ", extPolicy=" + this.n + ", timeCompleteText=" + this.o + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
