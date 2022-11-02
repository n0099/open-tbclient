package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class is7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, str, obj, i, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            if (obj instanceof fu4) {
                statisticItem.param("fid", ((fu4) obj).j());
            } else if (obj instanceof zs7) {
                zs7 zs7Var = (zs7) obj;
                ThreadData threadData = zs7Var.h;
                if (threadData != null) {
                    statisticItem.param("tid", threadData.getTid());
                }
                statisticItem.param("obj_locate", zs7Var.a());
            }
            statisticItem.param("topic_id", str2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }

    public static void b(ls7 ls7Var, rr4 rr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ls7Var, rr4Var) == null) {
            d(ls7Var, rr4Var, true);
        }
    }

    public static void c(ls7 ls7Var, rr4 rr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ls7Var, rr4Var) == null) {
            d(ls7Var, rr4Var, false);
        }
    }

    public static void d(ls7 ls7Var, rr4 rr4Var, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65539, null, ls7Var, rr4Var, z) == null) && rr4Var != null && rr4Var.getThreadData() != null) {
            ThreadData threadData = rr4Var.getThreadData();
            boolean s = ls7Var.s();
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
            if (ls7Var.t().getOrignalPage() instanceof HotTopicDetailActivity) {
                statisticItem.param("topic_id", ((HotTopicDetailActivity) ls7Var.t().getOrignalPage()).z1());
            }
            statisticItem.eventStat();
        }
    }

    public static void e(ThreadData threadData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData) != null) || threadData == null) {
            return;
        }
        StatisticItem addParam = new StatisticItem("c13022").addParam("tid", threadData.getTid()).addParam("fid", threadData.getFid()).addParam("fname", threadData.getForum_name()).addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (UbsABTestHelper.isImgClickToPb()) {
            i = 1;
        } else {
            i = 2;
        }
        addParam.addParam(TiebaStatic.Params.OBJ_TO, i).eventStat();
    }

    public static void f(TbPageContext<HotTopicDetailActivity> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, tbPageContext, str) == null) && tbPageContext != null && !StringUtils.isNull(str)) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("topic_id", tbPageContext.getOrignalPage().z1());
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
            statisticItem.param("topic_id", tbPageContext.getOrignalPage().z1());
            statisticItem.eventStat();
        }
    }
}
