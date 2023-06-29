package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(u89 u89Var, n4a n4aVar, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65536, null, u89Var, n4aVar, i, i2) == null) {
            if (n4aVar != null) {
                str = n4aVar.S();
            } else {
                str = null;
            }
            c(u89Var, n4aVar, str, i, i2);
        }
    }

    public static void q(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(65552, null, str, str2, str3, i) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", str2);
        statisticItem.param("obj_source", str3);
        statisticItem.param("obj_type", i);
        TiebaStatic.log(statisticItem);
    }

    public static void w(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65558, null, str, str2, str3, str4) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("fid", str2);
        statisticItem.param("tid", str3);
        statisticItem.param("uid", str4);
        TiebaStatic.log(statisticItem);
    }

    public static void b(u89 u89Var, n4a n4aVar, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{u89Var, n4aVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) != null) || u89Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        String str = null;
        if (n4aVar != null) {
            str = n4aVar.S();
        }
        h(statisticItem, u89Var, n4aVar, i, i2, false, str);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(u89 u89Var, n4a n4aVar, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{u89Var, n4aVar, str, Integer.valueOf(i), Integer.valueOf(i2)}) != null) || u89Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, u89Var, n4aVar, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static StatisticItem i(u89 u89Var, n4a n4aVar, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{u89Var, n4aVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str = null;
            if (u89Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (n4aVar != null) {
                str = n4aVar.S();
            }
            h(statisticItem, u89Var, n4aVar, i, i2, false, str);
            statisticItem.param("obj_locate", i3);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void d(BdUniqueId bdUniqueId, u89 u89Var, n4a n4aVar, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bdUniqueId, u89Var, n4aVar, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (n4aVar != null) {
                str = n4aVar.S();
            } else {
                str = null;
            }
            String str2 = str;
            f(bdUniqueId, u89Var, n4aVar, str2, str2, i, i2);
        }
    }

    public static void e(BdUniqueId bdUniqueId, u89 u89Var, n4a n4aVar, int i, int i2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bdUniqueId, u89Var, n4aVar, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            if (n4aVar != null) {
                str2 = n4aVar.S();
            } else {
                str2 = null;
            }
            String str3 = str2;
            g(bdUniqueId, u89Var, n4aVar, str3, str3, i, i2, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, u89 u89Var, n4a n4aVar, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bdUniqueId, u89Var, n4aVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) && bdUniqueId != null && u89Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            h(statisticItem, u89Var, n4aVar, i, i2, false, str);
            p2a.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static void g(BdUniqueId bdUniqueId, u89 u89Var, n4a n4aVar, String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, u89Var, n4aVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) && bdUniqueId != null && u89Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            h(statisticItem, u89Var, n4aVar, i, i2, false, str);
            statisticItem.param("common_exp_source_pb_comment", str3);
            p2a.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static StatisticItem h(StatisticItem statisticItem, u89 u89Var, n4a n4aVar, int i, int i2, boolean z, String str) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{statisticItem, u89Var, n4aVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str})) == null) {
            if (u89Var == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", u89Var.l() + "");
            StatisticItem param3 = param2.param("tid", u89Var.P() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
            if (n4aVar != null) {
                statisticItem.param("pid", n4aVar.S() + "");
            }
            if (u89Var.N() != null) {
                statisticItem.param("thread_type", u89Var.N().threadType);
                BaijiahaoData baijiahaoData = u89Var.N().getBaijiahaoData();
                if (baijiahaoData != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, baijiahaoData.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, baijiahaoData.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
                }
            }
            if (u89Var.T() == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            statisticItem.param(TiebaStatic.Params.IS_UP, i3);
            int i4 = 2;
            if (u89Var.N().isGoods()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (n4aVar.W() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else if (a26.x(n4aVar)) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 4);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (!u89Var.i0()) {
                int i5 = u89Var.g;
                if (i5 == 2) {
                    i4 = 1;
                } else if (i5 == 1) {
                    i4 = 3;
                }
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i4);
            }
            if (u89Var.N() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, u89Var.N().isWorksInfo() ? 1 : 0);
            }
            if (PermissionUtil.isBrowseMode()) {
                statisticItem.param(TiebaStatic.Params.PURE_BROWSING, 1);
            }
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
            if ("电脑数码".equals(str)) {
                return 3;
            }
            return 4;
        }
        return invokeL.intValue;
    }

    public static String k(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getIntent() != null) {
                return tbPageContext.getPageActivity().getIntent().getStringExtra("thread_id");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static int l(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && (tbPageContext.getPageActivity() instanceof AbsPbActivity)) {
                AbsPbActivity absPbActivity = (AbsPbActivity) tbPageContext.getPageActivity();
                if (absPbActivity.K1() != null && absPbActivity.K1().y1() != null) {
                    return absPbActivity.K1().y1().G();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void m(l15 l15Var, int i, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65548, null, l15Var, i, tbPageContext) == null) {
            n(l15Var, i, tbPageContext, "1");
        }
    }

    public static void s(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(65554, null, str, i, i2) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    public static void t(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65555, null, str, str2, i) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("fid", str2);
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    public static void n(l15 l15Var, int i, TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65549, null, l15Var, i, tbPageContext, str) == null) && l15Var != null && l15Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (l15Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", j(l15Var.getThreadData().getForumData().l));
            }
            statisticItem.param("obj_locate", l15Var.getThreadData().floorNum);
            statisticItem.param("tid", l15Var.getThreadData().getTid());
            statisticItem.param("fid", l15Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i);
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, str);
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
            TiebaStatic.log(statisticItem);
        }
    }

    public static void o(l15 l15Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, l15Var, tbPageContext) == null) {
            p(l15Var, tbPageContext, "1");
        }
    }

    public static void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65559, null, str, str2) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("forum_id", str2);
        TiebaStatic.log(statisticItem);
    }

    public static void y(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65560, null, str, j) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("forum_id", j);
        TiebaStatic.log(statisticItem);
    }

    public static void p(l15 l15Var, TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65551, null, l15Var, tbPageContext, str) == null) && l15Var != null && l15Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            if (l15Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", j(l15Var.getThreadData().getForumData().l));
            }
            statisticItem.param("tid", l15Var.getThreadData().getTid());
            statisticItem.param("fid", l15Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, str);
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, l15Var.position + 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void r(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65553, null, str, str2, str3) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (!StringUtils.isNull(str2)) {
            statisticItem.param("tid", str2);
        }
        if (!StringUtils.isNull(str3)) {
            statisticItem.param("post_id", str3);
        }
        TiebaStatic.log(statisticItem);
    }

    public static void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65556, null, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c14888");
            statisticItem.addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            TiebaStatic.log(new StatisticItem(str));
        }
    }
}
