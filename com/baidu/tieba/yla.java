package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class yla {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ThreadData a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            ThreadData threadData = new ThreadData();
            threadData.tid = map.get("thread_id");
            threadData.setFid(JavaTypesHelper.toLong(map.get("forum_id"), 0L));
            threadData.threadType = JavaTypesHelper.toInt(map.get("thread_type"), 0);
            if (Intrinsics.areEqual(map.get("is_video_work"), "1")) {
                WorksInfoData worksInfoData = new WorksInfoData();
                worksInfoData.isWorks = true;
                threadData.worksInfoData = worksInfoData;
            }
            threadData.tiebaPlusOrderId = map.get("tie_plus_order_id");
            return threadData;
        }
        return (ThreadData) invokeL.objValue;
    }

    public static final void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            hi8.f("c15195", a(map));
        }
    }

    public static final void c(Map<String, String> map) {
        int i;
        int i2;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            String str = map.get("tie_plus_info");
            if (str != null) {
                if (Intrinsics.areEqual(map.get("is_video_work"), "1")) {
                    i = 3;
                } else if (!Intrinsics.areEqual(map.get("thread_type"), PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK) && !Intrinsics.areEqual(map.get("thread_type"), PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK)) {
                    i = 1;
                } else {
                    i = 2;
                }
                int i3 = 0;
                try {
                    jSONObject = new JSONObject(str);
                    i2 = jSONObject.optInt(GameGuideConfigInfo.KEY_TARGET_TYPE);
                } catch (Exception e) {
                    e = e;
                    i2 = 0;
                }
                try {
                    i3 = jSONObject.optInt("jump_type");
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_TIE_PLUS_RICH_TEXT_EXPOSE).param("obj_locate", 1).param("obj_type", i).param(TiePlusStat.RichTextType.STAT_KEY, 1).param("t_obj", i2).param(TiePlusStat.LandingType.STAT_KEY, i3).param("tid", map.get("thread_id")).param(TiebaStatic.Params.FID_1, map.get("forum_id")).param("order_id", map.get("tie_plus_order_id")));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_TIE_PLUS_RICH_TEXT_EXPOSE).param("obj_locate", 1).param("obj_type", i).param(TiePlusStat.RichTextType.STAT_KEY, 1).param("t_obj", i2).param(TiePlusStat.LandingType.STAT_KEY, i3).param("tid", map.get("thread_id")).param(TiebaStatic.Params.FID_1, map.get("forum_id")).param("order_id", map.get("tie_plus_order_id")));
            }
        }
    }

    public static final void d(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            ThreadData threadData = new ThreadData();
            threadData.tiePlusShowUrl = map.get("tie_plus_show_url");
            threadData.tid = map.get("thread_id");
            threadData.setFid(JavaTypesHelper.toLong(map.get("forum_id"), 0L));
            threadData.threadType = JavaTypesHelper.toInt(map.get("thread_type"), 0);
            if (Intrinsics.areEqual(map.get("is_video_work"), "1")) {
                WorksInfoData worksInfoData = new WorksInfoData();
                worksInfoData.isWorks = true;
                threadData.worksInfoData = worksInfoData;
            }
            threadData.tiePlusMonitorClickUrl = map.get("tie_plus_monitor_show_url");
            threadData.isTiebaPlusAdThread = true;
            threadData.tiebaPlusOrderId = map.get("tie_plus_order_id");
            threadData.tiebaPlusToken = map.get("tie_plus_token");
            threadData.tiebaPlusExtraParam = map.get("tie_plus_extra_param");
            hi8.o(threadData, map.get("source"), JavaTypesHelper.toInt(map.get("position_from_1"), 0));
        }
    }
}
