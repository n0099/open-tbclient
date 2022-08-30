package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class rn0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a A;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;
    public final List<MonitorUrl> i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final int u;
    public final String v;
    public final String w;
    public final String x;
    public final String y;
    public final String z;

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
        public final rn0 a(JSONObject jsonObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonObject)) == null) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                int optInt = jsonObject.optInt("reward_switch", 0);
                String optString = jsonObject.optString("activity_cmd");
                String optString2 = jsonObject.optString("stay_cmd");
                String optString3 = jsonObject.optString("reward_cmd");
                String optString4 = jsonObject.optString("task_from");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"task_from\")");
                String a = sn0.a(jsonObject, "token");
                String optString5 = jsonObject.optString("unique_id");
                Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"unique_id\")");
                int optInt2 = jsonObject.optInt("reward_log_type");
                List<MonitorUrl> fromJson = MonitorUrl.fromJson(jsonObject.optJSONArray("ad_monitor_url"));
                String a2 = sn0.a(jsonObject, "task_id");
                String optString6 = jsonObject.optString("active_url");
                Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"active_url\")");
                String b = sn0.b(jsonObject, "task_type", "0");
                String a3 = sn0.a(jsonObject, "task_behavior");
                String optString7 = jsonObject.optString("receive_url");
                String optString8 = jsonObject.optString("progress_lottie");
                Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(\"progress_lottie\")");
                String optString9 = jsonObject.optString("complete_lottie");
                Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(\"complete_lottie\")");
                String b2 = sn0.b(jsonObject, GameGuideConfigInfo.KEY_PROGRESS_COLOR, "#FF6D4D");
                String optString10 = jsonObject.optString("bubble_icon");
                Intrinsics.checkNotNullExpressionValue(optString10, "json.optString(\"bubble_icon\")");
                String optString11 = jsonObject.optString("bubble_front_icon");
                Intrinsics.checkNotNullExpressionValue(optString11, "json.optString(\"bubble_front_icon\")");
                String optString12 = jsonObject.optString("bubble_text");
                Intrinsics.checkNotNullExpressionValue(optString12, "json.optString(\"bubble_text\")");
                int optInt3 = jsonObject.optInt("task_duration", 15);
                String optString13 = jsonObject.optString("search_id");
                Intrinsics.checkNotNullExpressionValue(optString13, "json.optString(\"search_id\")");
                String optString14 = jsonObject.optString("bubble_arrow");
                Intrinsics.checkNotNullExpressionValue(optString14, "json.optString(\"bubble_arrow\")");
                String optString15 = jsonObject.optString("bubble_color");
                Intrinsics.checkNotNullExpressionValue(optString15, "json.optString(\"bubble_color\")");
                String optString16 = jsonObject.optString("bubble_text_color");
                Intrinsics.checkNotNullExpressionValue(optString16, "json.optString(\"bubble_text_color\")");
                String optString17 = jsonObject.optString("task_policy");
                Intrinsics.checkNotNullExpressionValue(optString17, "json.optString(\"task_policy\")");
                return new rn0(optInt, optString, optString2, optString3, optString4, a, optString5, optInt2, fromJson, a2, optString6, b, a3, optString7, optString8, optString9, b2, optString10, optString11, optString12, optInt3, optString13, optString14, optString15, optString16, optString17);
            }
            return (rn0) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948127253, "Lcom/baidu/tieba/rn0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948127253, "Lcom/baidu/tieba/rn0;");
                return;
            }
        }
        A = new a(null);
    }

    public rn0(int i, String str, String str2, String str3, String taskFrom, String token, String uniqueId, int i2, List<MonitorUrl> list, String taskId, String activeUrl, String taskType, String taskBehavior, String str4, String progressLottieUrl, String completeLottieUrl, String progressColor, String bubbleIcon, String bubbleFrontIcon, String bubbleText, int i3, String searchId, String bubbleArrow, String bubbleBgColor, String bubbleTextColor, String taskPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, taskFrom, token, uniqueId, Integer.valueOf(i2), list, taskId, activeUrl, taskType, taskBehavior, str4, progressLottieUrl, completeLottieUrl, progressColor, bubbleIcon, bubbleFrontIcon, bubbleText, Integer.valueOf(i3), searchId, bubbleArrow, bubbleBgColor, bubbleTextColor, taskPolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(taskFrom, "taskFrom");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(activeUrl, "activeUrl");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(taskBehavior, "taskBehavior");
        Intrinsics.checkNotNullParameter(progressLottieUrl, "progressLottieUrl");
        Intrinsics.checkNotNullParameter(completeLottieUrl, "completeLottieUrl");
        Intrinsics.checkNotNullParameter(progressColor, "progressColor");
        Intrinsics.checkNotNullParameter(bubbleIcon, "bubbleIcon");
        Intrinsics.checkNotNullParameter(bubbleFrontIcon, "bubbleFrontIcon");
        Intrinsics.checkNotNullParameter(bubbleText, "bubbleText");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(bubbleArrow, "bubbleArrow");
        Intrinsics.checkNotNullParameter(bubbleBgColor, "bubbleBgColor");
        Intrinsics.checkNotNullParameter(bubbleTextColor, "bubbleTextColor");
        Intrinsics.checkNotNullParameter(taskPolicy, "taskPolicy");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = taskFrom;
        this.f = token;
        this.g = uniqueId;
        this.h = i2;
        this.i = list;
        this.j = taskId;
        this.k = activeUrl;
        this.l = taskType;
        this.m = taskBehavior;
        this.n = str4;
        this.o = progressLottieUrl;
        this.p = completeLottieUrl;
        this.q = progressColor;
        this.r = bubbleIcon;
        this.s = bubbleFrontIcon;
        this.t = bubbleText;
        this.u = i3;
        this.v = searchId;
        this.w = bubbleArrow;
        this.x = bubbleBgColor;
        this.y = bubbleTextColor;
        this.z = taskPolicy;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof rn0) {
                    rn0 rn0Var = (rn0) obj;
                    return this.a == rn0Var.a && Intrinsics.areEqual(this.b, rn0Var.b) && Intrinsics.areEqual(this.c, rn0Var.c) && Intrinsics.areEqual(this.d, rn0Var.d) && Intrinsics.areEqual(this.e, rn0Var.e) && Intrinsics.areEqual(this.f, rn0Var.f) && Intrinsics.areEqual(this.g, rn0Var.g) && this.h == rn0Var.h && Intrinsics.areEqual(this.i, rn0Var.i) && Intrinsics.areEqual(this.j, rn0Var.j) && Intrinsics.areEqual(this.k, rn0Var.k) && Intrinsics.areEqual(this.l, rn0Var.l) && Intrinsics.areEqual(this.m, rn0Var.m) && Intrinsics.areEqual(this.n, rn0Var.n) && Intrinsics.areEqual(this.o, rn0Var.o) && Intrinsics.areEqual(this.p, rn0Var.p) && Intrinsics.areEqual(this.q, rn0Var.q) && Intrinsics.areEqual(this.r, rn0Var.r) && Intrinsics.areEqual(this.s, rn0Var.s) && Intrinsics.areEqual(this.t, rn0Var.t) && this.u == rn0Var.u && Intrinsics.areEqual(this.v, rn0Var.v) && Intrinsics.areEqual(this.w, rn0Var.w) && Intrinsics.areEqual(this.x, rn0Var.x) && Intrinsics.areEqual(this.y, rn0Var.y) && Intrinsics.areEqual(this.z, rn0Var.z);
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
            int i = this.a * 31;
            String str = this.b;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.d;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.e;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.g;
            int hashCode6 = (((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.h) * 31;
            List<MonitorUrl> list = this.i;
            int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
            String str7 = this.j;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.k;
            int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.l;
            int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.m;
            int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.n;
            int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
            String str12 = this.o;
            int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
            String str13 = this.p;
            int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
            String str14 = this.q;
            int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
            String str15 = this.r;
            int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
            String str16 = this.s;
            int hashCode17 = (hashCode16 + (str16 != null ? str16.hashCode() : 0)) * 31;
            String str17 = this.t;
            int hashCode18 = (((hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31) + this.u) * 31;
            String str18 = this.v;
            int hashCode19 = (hashCode18 + (str18 != null ? str18.hashCode() : 0)) * 31;
            String str19 = this.w;
            int hashCode20 = (hashCode19 + (str19 != null ? str19.hashCode() : 0)) * 31;
            String str20 = this.x;
            int hashCode21 = (hashCode20 + (str20 != null ? str20.hashCode() : 0)) * 31;
            String str21 = this.y;
            int hashCode22 = (hashCode21 + (str21 != null ? str21.hashCode() : 0)) * 31;
            String str22 = this.z;
            return hashCode22 + (str22 != null ? str22.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "RewardData(rewardSwitch=" + this.a + ", activityCmd=" + this.b + ", stayCmd=" + this.c + ", rewardCmd=" + this.d + ", taskFrom=" + this.e + ", token=" + this.f + ", uniqueId=" + this.g + ", rewardLogType=" + this.h + ", adMonitorUrlList=" + this.i + ", taskId=" + this.j + ", activeUrl=" + this.k + ", taskType=" + this.l + ", taskBehavior=" + this.m + ", receiveUrl=" + this.n + ", progressLottieUrl=" + this.o + ", completeLottieUrl=" + this.p + ", progressColor=" + this.q + ", bubbleIcon=" + this.r + ", bubbleFrontIcon=" + this.s + ", bubbleText=" + this.t + ", taskDuration=" + this.u + ", searchId=" + this.v + ", bubbleArrow=" + this.w + ", bubbleBgColor=" + this.x + ", bubbleTextColor=" + this.y + ", taskPolicy=" + this.z + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
