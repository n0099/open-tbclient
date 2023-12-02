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
public class kq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, str, obj, i, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            if (obj instanceof wy4) {
                statisticItem.param("fid", ((wy4) obj).f());
            } else if (obj instanceof cr9) {
                cr9 cr9Var = (cr9) obj;
                ThreadData threadData = cr9Var.h;
                if (threadData != null) {
                    statisticItem.param("tid", threadData.getTid());
                }
                statisticItem.param("obj_locate", cr9Var.a());
            }
            statisticItem.param("topic_id", str2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }

    public static void b(oq9 oq9Var, fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, oq9Var, fw4Var) == null) {
            d(oq9Var, fw4Var, true);
        }
    }

    public static void c(oq9 oq9Var, fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, oq9Var, fw4Var) == null) {
            d(oq9Var, fw4Var, false);
        }
    }

    public static void d(oq9 oq9Var, fw4 fw4Var, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65539, null, oq9Var, fw4Var, z) == null) && fw4Var != null && fw4Var.getThreadData() != null) {
            ThreadData threadData = fw4Var.getThreadData();
            boolean t = oq9Var.t();
            if (z) {
                if (t) {
                    str = "c13823";
                } else {
                    str = "c13822";
                }
            } else if (t) {
                str = "c13824";
            } else {
                str = "c13821";
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("fid", threadData.getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (oq9Var.u().getOrignalPage() instanceof HotTopicDetailActivity) {
                statisticItem.param("topic_id", ((HotTopicDetailActivity) oq9Var.u().getOrignalPage()).K0());
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
            statisticItem.param("topic_id", tbPageContext.getOrignalPage().K0());
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
            statisticItem.param("topic_id", tbPageContext.getOrignalPage().K0());
            statisticItem.eventStat();
        }
    }
}
