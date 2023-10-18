package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, str, obj, i, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            if (obj instanceof zx4) {
                statisticItem.param("fid", ((zx4) obj).f());
            } else if (obj instanceof ca9) {
                ca9 ca9Var = (ca9) obj;
                ThreadData threadData = ca9Var.h;
                if (threadData != null) {
                    statisticItem.param("tid", threadData.getTid());
                }
                statisticItem.param("obj_locate", ca9Var.a());
            }
            statisticItem.param("topic_id", str2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }

    public static void b(o99 o99Var, jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, o99Var, jv4Var) == null) {
            d(o99Var, jv4Var, true);
        }
    }

    public static void c(o99 o99Var, jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, o99Var, jv4Var) == null) {
            d(o99Var, jv4Var, false);
        }
    }

    public static void d(o99 o99Var, jv4 jv4Var, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65539, null, o99Var, jv4Var, z) == null) && jv4Var != null && jv4Var.getThreadData() != null) {
            ThreadData threadData = jv4Var.getThreadData();
            boolean s = o99Var.s();
            if (z) {
                if (s) {
                    str = "c13823";
                } else {
                    str = "c13822";
                }
            } else if (s) {
                str = "c13824";
            } else {
                str = "c13821";
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("fid", threadData.getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (o99Var.t().getOrignalPage() instanceof HotTopicDetailActivity) {
                statisticItem.param("topic_id", ((HotTopicDetailActivity) o99Var.t().getOrignalPage()).Q0());
            }
            statisticItem.eventStat();
        }
    }

    public static void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData) != null) || threadData == null) {
            return;
        }
        new StatisticItem("c13022").addParam("tid", threadData.getTid()).addParam("fid", threadData.getFid()).addParam("fname", threadData.getForum_name()).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam(TiebaStatic.Params.OBJ_TO, 2).eventStat();
    }

    public static void f(TbPageContext<HotTopicDetailActivity> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, tbPageContext, str) == null) && tbPageContext != null && !StringUtils.isNull(str)) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("topic_id", tbPageContext.getOrignalPage().Q0());
            statisticItem.eventStat();
        }
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("topic_id", str2);
            statisticItem.eventStat();
        }
    }

    public static void h(TbPageContext<HotTopicDetailActivity> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, tbPageContext, str) == null) && tbPageContext != null && !StringUtils.isNull(str)) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("topic_id", tbPageContext.getOrignalPage().Q0());
            statisticItem.eventStat();
        }
    }
}
