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
/* loaded from: classes7.dex */
public class md9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, str, obj, i, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            if (obj instanceof r35) {
                statisticItem.param("fid", ((r35) obj).f());
            } else if (obj instanceof ee9) {
                ee9 ee9Var = (ee9) obj;
                ThreadData threadData = ee9Var.h;
                if (threadData != null) {
                    statisticItem.param("tid", threadData.getTid());
                }
                statisticItem.param("obj_locate", ee9Var.a());
            }
            statisticItem.param("topic_id", str2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }

    public static void b(qd9 qd9Var, b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qd9Var, b15Var) == null) {
            d(qd9Var, b15Var, true);
        }
    }

    public static void c(qd9 qd9Var, b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, qd9Var, b15Var) == null) {
            d(qd9Var, b15Var, false);
        }
    }

    public static void d(qd9 qd9Var, b15 b15Var, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65539, null, qd9Var, b15Var, z) == null) && b15Var != null && b15Var.getThreadData() != null) {
            ThreadData threadData = b15Var.getThreadData();
            boolean s = qd9Var.s();
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
            if (qd9Var.t().getOrignalPage() instanceof HotTopicDetailActivity) {
                statisticItem.param("topic_id", ((HotTopicDetailActivity) qd9Var.t().getOrignalPage()).q1());
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
            statisticItem.param("topic_id", tbPageContext.getOrignalPage().q1());
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
            statisticItem.param("topic_id", tbPageContext.getOrignalPage().q1());
            statisticItem.eventStat();
        }
    }
}
