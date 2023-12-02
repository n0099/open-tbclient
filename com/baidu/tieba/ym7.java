package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.forum.statistic.ForumStatConstant$TabType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes9.dex */
public final class ym7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948335046, "Lcom/baidu/tieba/ym7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948335046, "Lcom/baidu/tieba/ym7;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.ym7$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public /* synthetic */ class C0544a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-992315572, "Lcom/baidu/tieba/ym7$a$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-992315572, "Lcom/baidu/tieba/ym7$a$a;");
                        return;
                    }
                }
                int[] iArr = new int[ForumStatConstant$TabType.values().length];
                iArr[ForumStatConstant$TabType.TAB_TYPE_NEW.ordinal()] = 1;
                iArr[ForumStatConstant$TabType.TAB_TYPE_GOOD.ordinal()] = 2;
                iArr[ForumStatConstant$TabType.TAB_TYPE_GENERAL.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final void a(String str, String str2, Map<String, String> map, ForumStatConstant$TabType forumStatConstant$TabType, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, map, forumStatConstant$TabType, str3, Boolean.valueOf(z)}) == null) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.addParam("obj_locate", d(forumStatConstant$TabType));
                if (Intrinsics.areEqual(map.get("is_video_work"), "1")) {
                    statisticItem.addParam("obj_type", 3);
                } else if (Intrinsics.areEqual(map.get("thread_type"), PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK)) {
                    statisticItem.addParam("obj_type", 2);
                } else {
                    statisticItem.addParam("obj_type", 1);
                }
                if (!z) {
                    statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, c(str2));
                }
                statisticItem.addParam("tid", map.get("thread_id"));
                statisticItem.addParam(TiebaStatic.Params.FID_1, map.get("forum_id"));
                statisticItem.addParam(TiebaStatic.Params.FID_2, str3);
                statisticItem.addParam("order_id", map.get("tie_plus_order_id"));
                TiebaStatic.log(statisticItem);
            }
        }

        public final void b(String id, Map<String, String> map, ForumStatConstant$TabType tabType, String dispatchForumId, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{id, map, tabType, dispatchForumId, Integer.valueOf(i)}) == null) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(tabType, "tabType");
                Intrinsics.checkNotNullParameter(dispatchForumId, "dispatchForumId");
                if (Intrinsics.areEqual(map.get("is_tie_plus_ad_thread"), "1")) {
                    a(CommonStatisticKey.KEY_HEATING_THREAD_CLICK, id, map, tabType, dispatchForumId, false);
                    pq4.a(pq4.e, pq4.b, map.get("tie_plus_order_id"), map.get("tie_plus_token"), map.get("tie_plus_extra_param"), i + 1);
                }
                String str = map.get("source");
                if (str == null) {
                    str = "";
                }
                String str2 = str;
                if (StringsKt__StringsJVMKt.startsWith$default(str2, "manual", false, 2, null)) {
                    pq4.a(pq4.l, pq4.b, str2, map.get("tie_plus_token"), map.get("tie_plus_extra_param"), i + 1);
                }
                String str3 = map.get("tie_plus_monitor_click_url");
                if (str3 != null) {
                    ThirdStatisticHelper.sendReq(str3);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0032 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                switch (str.hashCode()) {
                    case -1929596901:
                        if (str.equals("comment_button_click")) {
                            return 1;
                        }
                        return 0;
                    case -1791942236:
                        if (str.equals("image_click")) {
                            return 2;
                        }
                        break;
                    case 76992922:
                        if (str.equals("video_area_click")) {
                            return 2;
                        }
                        break;
                    case 1185358570:
                        if (str.equals("card_click_other")) {
                        }
                        break;
                }
            } else {
                return invokeL.intValue;
            }
        }

        public final int d(ForumStatConstant$TabType forumStatConstant$TabType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, forumStatConstant$TabType)) == null) {
                int i = C0544a.$EnumSwitchMapping$0[forumStatConstant$TabType.ordinal()];
                if (i == 1) {
                    return 3;
                }
                if (i != 2) {
                    if (i != 3) {
                        return 2;
                    }
                    return 4;
                }
                return 5;
            }
            return invokeL.intValue;
        }

        public final void e(Map<String, String> map, ForumStatConstant$TabType tabType, String dispatchForumId, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048580, this, map, tabType, dispatchForumId, i) == null) {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(tabType, "tabType");
                Intrinsics.checkNotNullParameter(dispatchForumId, "dispatchForumId");
                if (Intrinsics.areEqual(map.get("is_tie_plus_ad_thread"), "1")) {
                    a(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE, "", map, tabType, dispatchForumId, true);
                    pq4.a(pq4.d, pq4.b, map.get("tie_plus_order_id"), map.get("tie_plus_token"), map.get("tie_plus_extra_param"), i + 1);
                }
                String str = map.get("source");
                if (str == null) {
                    str = "";
                }
                String str2 = str;
                if (StringsKt__StringsJVMKt.startsWith$default(str2, "manual", false, 2, null)) {
                    pq4.a(pq4.k, pq4.b, str2, map.get("tie_plus_token"), map.get("tie_plus_extra_param"), i + 1);
                }
                String str3 = map.get("tie_plus_monitor_show_url");
                if (str3 != null) {
                    ThirdStatisticHelper.sendReq(str3);
                }
            }
        }
    }
}
