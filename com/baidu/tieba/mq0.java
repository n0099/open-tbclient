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
/* loaded from: classes5.dex */
public final class mq0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a A;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final pq0 c;
    public final nq0 d;
    public hq0 e;
    public final String f;
    public final String g;
    public final String h;
    public String i;
    public final String j;
    public final String k;
    public final int l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final fq0 r;
    public final rq0 s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;
    public final String y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981181, "Lcom/baidu/tieba/mq0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981181, "Lcom/baidu/tieba/mq0;");
                return;
            }
        }
        A = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof mq0) {
                    mq0 mq0Var = (mq0) obj;
                    return Intrinsics.areEqual(this.a, mq0Var.a) && Intrinsics.areEqual(this.b, mq0Var.b) && Intrinsics.areEqual(this.c, mq0Var.c) && Intrinsics.areEqual(this.d, mq0Var.d) && Intrinsics.areEqual(this.e, mq0Var.e) && Intrinsics.areEqual(this.f, mq0Var.f) && Intrinsics.areEqual(this.g, mq0Var.g) && Intrinsics.areEqual(this.h, mq0Var.h) && Intrinsics.areEqual(this.i, mq0Var.i) && Intrinsics.areEqual(this.j, mq0Var.j) && Intrinsics.areEqual(this.k, mq0Var.k) && this.l == mq0Var.l && Intrinsics.areEqual(this.m, mq0Var.m) && Intrinsics.areEqual(this.n, mq0Var.n) && Intrinsics.areEqual(this.o, mq0Var.o) && Intrinsics.areEqual(this.p, mq0Var.p) && Intrinsics.areEqual(this.q, mq0Var.q) && Intrinsics.areEqual(this.r, mq0Var.r) && Intrinsics.areEqual(this.s, mq0Var.s) && Intrinsics.areEqual(this.t, mq0Var.t) && Intrinsics.areEqual(this.u, mq0Var.u) && Intrinsics.areEqual(this.v, mq0Var.v) && Intrinsics.areEqual(this.w, mq0Var.w) && Intrinsics.areEqual(this.x, mq0Var.x) && Intrinsics.areEqual(this.y, mq0Var.y) && Intrinsics.areEqual(this.z, mq0Var.z);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            pq0 pq0Var = this.c;
            int hashCode3 = (hashCode2 + (pq0Var != null ? pq0Var.hashCode() : 0)) * 31;
            nq0 nq0Var = this.d;
            int hashCode4 = (hashCode3 + (nq0Var != null ? nq0Var.hashCode() : 0)) * 31;
            hq0 hq0Var = this.e;
            int hashCode5 = (hashCode4 + (hq0Var != null ? hq0Var.hashCode() : 0)) * 31;
            String str3 = this.f;
            int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.g;
            int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.h;
            int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.i;
            int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.j;
            int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.k;
            int hashCode11 = (((hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.l) * 31;
            String str9 = this.m;
            int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.n;
            int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.o;
            int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
            String str12 = this.p;
            int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
            String str13 = this.q;
            int hashCode16 = (hashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
            fq0 fq0Var = this.r;
            int hashCode17 = (hashCode16 + (fq0Var != null ? fq0Var.hashCode() : 0)) * 31;
            rq0 rq0Var = this.s;
            int hashCode18 = (hashCode17 + (rq0Var != null ? rq0Var.hashCode() : 0)) * 31;
            String str14 = this.t;
            int hashCode19 = (hashCode18 + (str14 != null ? str14.hashCode() : 0)) * 31;
            String str15 = this.u;
            int hashCode20 = (hashCode19 + (str15 != null ? str15.hashCode() : 0)) * 31;
            String str16 = this.v;
            int hashCode21 = (hashCode20 + (str16 != null ? str16.hashCode() : 0)) * 31;
            String str17 = this.w;
            int hashCode22 = (hashCode21 + (str17 != null ? str17.hashCode() : 0)) * 31;
            String str18 = this.x;
            int hashCode23 = (hashCode22 + (str18 != null ? str18.hashCode() : 0)) * 31;
            String str19 = this.y;
            int hashCode24 = (hashCode23 + (str19 != null ? str19.hashCode() : 0)) * 31;
            String str20 = this.z;
            return hashCode24 + (str20 != null ? str20.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return "RewardData(stayCmd=" + this.a + ", rewardCmd=" + this.b + ", suspend=" + this.c + ", rewardFestivalData=" + this.d + ", lottieDialogRewardData=" + this.e + ", taskFrom=" + this.f + ", token=" + this.g + ", uniqueId=" + this.h + ", taskId=" + this.i + ", activeUrl=" + this.j + ", timerFrontIcon=" + this.k + ", taskDuration=" + this.l + ", taskPolicy=" + this.m + ", timerText=" + this.n + ", timeDefaultCompleteText=" + this.o + ", timeCompleteLottieUrl=" + this.p + ", timeCompleteText=" + this.q + ", extPolicy=" + this.r + ", taskCenterPolicy=" + this.s + ", taskCenterPolicyStr=" + this.t + ", scheme=" + this.u + ", downloadTaskCmd=" + this.v + ", downloadTaskTaskId=" + this.w + ", invokeCompleteToast=" + this.x + ", invokeIncompleteToast=" + this.y + ", invokeSdkCompleteCoin=" + this.z + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final mq0 a(JSONObject jsonObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonObject)) == null) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                String optString = jsonObject.optString("stay_cmd");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"stay_cmd\")");
                String optString2 = jsonObject.optString("reward_cmd");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"reward_cmd\")");
                pq0 a = pq0.h.a(jsonObject.optJSONObject("suspend"));
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
                String optString11 = jsonObject.optString("time_complete_text");
                Intrinsics.checkNotNullExpressionValue(optString11, "json.optString(\"time_complete_text\")");
                fq0 a2 = fq0.e.a(jsonObject.optJSONObject("ext_policy"));
                rq0 a3 = rq0.c.a(jsonObject.optJSONObject("task_center_policy"));
                String optString12 = jsonObject.optString("task_center_policy_string");
                Intrinsics.checkNotNullExpressionValue(optString12, "json.optString(\"task_center_policy_string\")");
                String optString13 = jsonObject.optString("scheme");
                Intrinsics.checkNotNullExpressionValue(optString13, "json.optString(\"scheme\")");
                nq0 a4 = nq0.e.a(jsonObject.optJSONObject("lottie_convert"));
                String optString14 = jsonObject.optString("download_exp_cmd");
                Intrinsics.checkNotNullExpressionValue(optString14, "json.optString(\"download_exp_cmd\")");
                String optString15 = jsonObject.optString("download_exp_task_id");
                Intrinsics.checkNotNullExpressionValue(optString15, "json.optString(\"download_exp_task_id\")");
                return new mq0(optString, optString2, a, a4, null, optString3, b, optString4, b2, optString5, optString6, optInt, optString7, optString8, optString9, optString10, optString11, a2, a3, optString12, optString13, optString14, optString15, jsonObject.optString("invoke_complete_toast"), jsonObject.optString("invoke_incomplete_toast"), null, 33554432, null);
            }
            return (mq0) invokeL.objValue;
        }
    }

    public mq0(String stayCmd, String rewardCmd, pq0 pq0Var, nq0 nq0Var, hq0 hq0Var, String taskFrom, String token, String uniqueId, String taskId, String activeUrl, String timerFrontIcon, int i, String taskPolicy, String timerText, String timeDefaultCompleteText, String timeCompleteLottieUrl, String timeCompleteText, fq0 fq0Var, rq0 rq0Var, String taskCenterPolicyStr, String scheme, String downloadTaskCmd, String downloadTaskTaskId, String str, String str2, String invokeSdkCompleteCoin) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {stayCmd, rewardCmd, pq0Var, nq0Var, hq0Var, taskFrom, token, uniqueId, taskId, activeUrl, timerFrontIcon, Integer.valueOf(i), taskPolicy, timerText, timeDefaultCompleteText, timeCompleteLottieUrl, timeCompleteText, fq0Var, rq0Var, taskCenterPolicyStr, scheme, downloadTaskCmd, downloadTaskTaskId, str, str2, invokeSdkCompleteCoin};
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
        Intrinsics.checkNotNullParameter(timeCompleteText, "timeCompleteText");
        Intrinsics.checkNotNullParameter(taskCenterPolicyStr, "taskCenterPolicyStr");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(downloadTaskCmd, "downloadTaskCmd");
        Intrinsics.checkNotNullParameter(downloadTaskTaskId, "downloadTaskTaskId");
        Intrinsics.checkNotNullParameter(invokeSdkCompleteCoin, "invokeSdkCompleteCoin");
        this.a = stayCmd;
        this.b = rewardCmd;
        this.c = pq0Var;
        this.d = nq0Var;
        this.e = hq0Var;
        this.f = taskFrom;
        this.g = token;
        this.h = uniqueId;
        this.i = taskId;
        this.j = activeUrl;
        this.k = timerFrontIcon;
        this.l = i;
        this.m = taskPolicy;
        this.n = timerText;
        this.o = timeDefaultCompleteText;
        this.p = timeCompleteLottieUrl;
        this.q = timeCompleteText;
        this.r = fq0Var;
        this.s = rq0Var;
        this.t = taskCenterPolicyStr;
        this.u = scheme;
        this.v = downloadTaskCmd;
        this.w = downloadTaskTaskId;
        this.x = str;
        this.y = str2;
        this.z = invokeSdkCompleteCoin;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ mq0(String str, String str2, pq0 pq0Var, nq0 nq0Var, hq0 hq0Var, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, String str11, String str12, String str13, fq0 fq0Var, rq0 rq0Var, String str14, String str15, String str16, String str17, String str18, String str19, String str20, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, pq0Var, nq0Var, hq0Var, str3, str4, str5, str6, str7, str8, i, str9, str10, str11, str12, str13, fq0Var, rq0Var, str14, str15, str16, str17, str18, str19, r27);
        String str21;
        if ((i2 & 33554432) != 0) {
            str21 = "";
        } else {
            str21 = str20;
        }
    }

    public final String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.u.length() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String jSONObject = ExtensionsKt.a(this.v).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "downloadTaskCmd.cmdToJsonObj().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.w;
        }
        return (String) invokeV.objValue;
    }

    public final fq0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.r;
        }
        return (fq0) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.y;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public final hq0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.e;
        }
        return (hq0) invokeV.objValue;
    }

    public final nq0 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.d;
        }
        return (nq0) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String jSONObject = ExtensionsKt.a(this.a).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "stayCmd.cmdToJsonObj().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    public final pq0 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.c;
        }
        return (pq0) invokeV.objValue;
    }

    public final rq0 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.s;
        }
        return (rq0) invokeV.objValue;
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public final String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public final String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public final String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.z = str;
        }
    }

    public final void E(hq0 hq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hq0Var) == null) {
            this.e = hq0Var;
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.i = str;
        }
    }

    public final String b(String count) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, count)) == null) {
            Intrinsics.checkNotNullParameter(count, "count");
            return StringsKt__StringsJVMKt.replace$default(this.q, "__COINTIPS__", count, false, 4, (Object) null);
        }
        return (String) invokeL.objValue;
    }

    public final String n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) {
            return StringsKt__StringsJVMKt.replace$default(o(), "__REMAININGTIME__", String.valueOf(j), false, 4, (Object) null);
        }
        return (String) invokeJ.objValue;
    }

    public final String j(String coin, String buttonCoin) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, coin, buttonCoin)) == null) {
            Intrinsics.checkNotNullParameter(coin, "coin");
            Intrinsics.checkNotNullParameter(buttonCoin, "buttonCoin");
            nq0 nq0Var = this.d;
            if (nq0Var != null && (a2 = nq0Var.a()) != null) {
                jSONObject = ExtensionsKt.a(a2);
            } else {
                jSONObject = null;
            }
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(String.valueOf(jSONObject), "__PREVCOINTIPS__", coin, false, 4, (Object) null), "__COINTIPS__", buttonCoin, false, 4, (Object) null);
        }
        return (String) invokeLL.objValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
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
