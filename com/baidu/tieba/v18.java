package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(vu7 vu7Var, PostData postData, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65536, null, vu7Var, postData, i, i2) == null) {
            c(vu7Var, postData, postData != null ? postData.L() : null, i, i2);
        }
    }

    public static void b(vu7 vu7Var, PostData postData, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{vu7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || vu7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, vu7Var, postData, i, i2, false, postData != null ? postData.L() : null);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(vu7 vu7Var, PostData postData, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vu7Var, postData, str, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || vu7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, vu7Var, postData, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static void d(BdUniqueId bdUniqueId, vu7 vu7Var, PostData postData, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bdUniqueId, vu7Var, postData, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            String L = postData != null ? postData.L() : null;
            f(bdUniqueId, vu7Var, postData, L, L, i, i2);
        }
    }

    public static void e(BdUniqueId bdUniqueId, vu7 vu7Var, PostData postData, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bdUniqueId, vu7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            String L = postData != null ? postData.L() : null;
            g(bdUniqueId, vu7Var, postData, L, L, i, i2, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, vu7 vu7Var, PostData postData, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bdUniqueId, vu7Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || bdUniqueId == null || vu7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        h(statisticItem, vu7Var, postData, i, i2, false, str);
        wk8.g().d(bdUniqueId, str2, statisticItem);
    }

    public static void g(BdUniqueId bdUniqueId, vu7 vu7Var, PostData postData, String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, vu7Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) || bdUniqueId == null || vu7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        h(statisticItem, vu7Var, postData, i, i2, false, str);
        statisticItem.param("common_exp_source_pb_comment", str3);
        wk8.g().d(bdUniqueId, str2, statisticItem);
    }

    public static StatisticItem h(StatisticItem statisticItem, vu7 vu7Var, PostData postData, int i, int i2, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{statisticItem, vu7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str})) == null) {
            if (vu7Var == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", vu7Var.m() + "");
            StatisticItem param3 = param2.param("tid", vu7Var.Q() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
            if (postData != null) {
                statisticItem.param("pid", postData.L() + "");
            }
            if (vu7Var.O() != null) {
                statisticItem.param("thread_type", vu7Var.O().threadType);
                BaijiahaoData baijiahaoData = vu7Var.O().getBaijiahaoData();
                if (baijiahaoData != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, baijiahaoData.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, baijiahaoData.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
                }
            }
            statisticItem.param(TiebaStatic.Params.IS_UP, vu7Var.U() == null ? 0 : 1);
            if (vu7Var.O().isGoods()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (postData.P() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else if (uk5.u(postData)) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 4);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (!vu7Var.i0()) {
                int i3 = vu7Var.g;
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i3 != 2 ? i3 == 1 ? 3 : 2 : 1);
            }
            if (vu7Var.O() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, vu7Var.O().isWorksInfo() ? 1 : 0);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem i(vu7 vu7Var, PostData postData, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{vu7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (vu7Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            h(statisticItem, vu7Var, postData, i, i2, false, postData != null ? postData.L() : null);
            statisticItem.param("obj_locate", i3);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if ("游戏".equals(str)) {
                return 1;
            }
            if ("动漫".equals(str)) {
                return 2;
            }
            return "电脑数码".equals(str) ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public static String k(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) ? (tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getIntent() == null) ? "" : tbPageContext.getPageActivity().getIntent().getStringExtra("thread_id") : (String) invokeL.objValue;
    }

    public static int l(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && (tbPageContext.getPageActivity() instanceof AbsPbActivity)) {
                AbsPbActivity absPbActivity = (AbsPbActivity) tbPageContext.getPageActivity();
                if (absPbActivity.j1() != null && absPbActivity.j1().S1() != null) {
                    return absPbActivity.j1().S1().H();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void m(lq4 lq4Var, int i, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, null, lq4Var, i, tbPageContext) == null) || lq4Var == null || lq4Var.getThreadData() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        if (lq4Var.getThreadData().getForumData() != null) {
            statisticItem.param("obj_type", j(lq4Var.getThreadData().getForumData().j));
        }
        statisticItem.param("obj_locate", lq4Var.getThreadData().floorNum);
        statisticItem.param("tid", lq4Var.getThreadData().getTid());
        statisticItem.param("fid", lq4Var.getThreadData().getFid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_source", i);
        statisticItem.param("page_type", "a005");
        statisticItem.param(TiebaStatic.Params.IS_REC, "1");
        statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
        statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
        TiebaStatic.log(statisticItem);
    }

    public static void n(lq4 lq4Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, lq4Var, tbPageContext) == null) || lq4Var == null || lq4Var.getThreadData() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        if (lq4Var.getThreadData().getForumData() != null) {
            statisticItem.param("obj_type", j(lq4Var.getThreadData().getForumData().j));
        }
        statisticItem.param("tid", lq4Var.getThreadData().getTid());
        statisticItem.param("fid", lq4Var.getThreadData().getFid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("page_type", "a005");
        statisticItem.param(TiebaStatic.Params.IS_REC, "1");
        statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
        statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, lq4Var.position + 1);
        TiebaStatic.log(statisticItem);
    }

    public static void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c14888");
            statisticItem.addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            TiebaStatic.log(new StatisticItem(str));
        }
    }
}
