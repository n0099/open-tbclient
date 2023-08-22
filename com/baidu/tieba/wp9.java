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
/* loaded from: classes8.dex */
public class wp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65536, null, str, j) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("forum_id", j);
        TiebaStatic.log(statisticItem);
    }

    public static void q(w05 w05Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, w05Var, tbPageContext) == null) {
            r(w05Var, tbPageContext, "1");
        }
    }

    public static void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65562, null, str, str2) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("forum_id", str2);
        TiebaStatic.log(statisticItem);
    }

    public static void a(yh9 yh9Var, zfa zfaVar, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65537, null, yh9Var, zfaVar, i, i2) == null) {
            if (zfaVar != null) {
                str = zfaVar.S();
            } else {
                str = null;
            }
            c(yh9Var, zfaVar, str, i, i2);
        }
    }

    public static void s(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(65555, null, str, str2, str3, i) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", str2);
        statisticItem.param("obj_source", str3);
        statisticItem.param("obj_type", i);
        TiebaStatic.log(statisticItem);
    }

    public static void y(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65561, null, str, str2, str3, str4) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("fid", str2);
        statisticItem.param("tid", str3);
        statisticItem.param("uid", str4);
        TiebaStatic.log(statisticItem);
    }

    public static void b(yh9 yh9Var, zfa zfaVar, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{yh9Var, zfaVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) != null) || yh9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        String str = null;
        if (zfaVar != null) {
            str = zfaVar.S();
        }
        i(statisticItem, yh9Var, zfaVar, i, i2, false, str);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(yh9 yh9Var, zfa zfaVar, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{yh9Var, zfaVar, str, Integer.valueOf(i), Integer.valueOf(i2)}) != null) || yh9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        i(statisticItem, yh9Var, zfaVar, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static StatisticItem k(yh9 yh9Var, zfa zfaVar, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{yh9Var, zfaVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str = null;
            if (yh9Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (zfaVar != null) {
                str = zfaVar.S();
            }
            i(statisticItem, yh9Var, zfaVar, i, i2, false, str);
            statisticItem.param("obj_locate", i3);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void d(BdUniqueId bdUniqueId, yh9 yh9Var, zfa zfaVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bdUniqueId, yh9Var, zfaVar, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            f(bdUniqueId, yh9Var, zfaVar, i, i2, "", "");
        }
    }

    public static void e(BdUniqueId bdUniqueId, yh9 yh9Var, zfa zfaVar, int i, int i2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bdUniqueId, yh9Var, zfaVar, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            if (zfaVar != null) {
                str2 = zfaVar.S();
            } else {
                str2 = null;
            }
            String str3 = str2;
            g(bdUniqueId, yh9Var, zfaVar, str3, str3, i, i2, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, yh9 yh9Var, zfa zfaVar, int i, int i2, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, yh9Var, zfaVar, Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            if (zfaVar != null) {
                str3 = zfaVar.S();
            } else {
                str3 = null;
            }
            String str4 = str3;
            h(bdUniqueId, yh9Var, zfaVar, str4, str4, i, i2, str, str2);
        }
    }

    public static StatisticItem i(StatisticItem statisticItem, yh9 yh9Var, zfa zfaVar, int i, int i2, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{statisticItem, yh9Var, zfaVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str})) == null) {
            j(statisticItem, yh9Var, zfaVar, i, i2, z, str, "", "");
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void g(BdUniqueId bdUniqueId, yh9 yh9Var, zfa zfaVar, String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{bdUniqueId, yh9Var, zfaVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) && bdUniqueId != null && yh9Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            i(statisticItem, yh9Var, zfaVar, i, i2, false, str);
            statisticItem.param("common_exp_source_pb_comment", str3);
            cea.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static void h(BdUniqueId bdUniqueId, yh9 yh9Var, zfa zfaVar, String str, String str2, int i, int i2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{bdUniqueId, yh9Var, zfaVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, str4}) == null) && bdUniqueId != null && yh9Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            j(statisticItem, yh9Var, zfaVar, i, i2, false, str, str3, str4);
            cea.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static StatisticItem j(StatisticItem statisticItem, yh9 yh9Var, zfa zfaVar, int i, int i2, boolean z, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{statisticItem, yh9Var, zfaVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, str2, str3})) == null) {
            if (yh9Var == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", yh9Var.l() + "");
            StatisticItem param3 = param2.param("tid", yh9Var.Q() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
            if (zfaVar != null) {
                statisticItem.param("pid", zfaVar.S() + "");
            }
            if (yh9Var.O() != null) {
                statisticItem.param("thread_type", yh9Var.O().threadType);
                BaijiahaoData baijiahaoData = yh9Var.O().getBaijiahaoData();
                if (baijiahaoData != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, baijiahaoData.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, baijiahaoData.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
                }
            }
            if (yh9Var.U() == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            statisticItem.param(TiebaStatic.Params.IS_UP, i3);
            int i4 = 2;
            if (yh9Var.O().isGoods()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (zfaVar.W() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else if (g16.x(zfaVar)) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 4);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (!yh9Var.j0()) {
                int i5 = yh9Var.g;
                if (i5 == 2) {
                    i4 = 1;
                } else if (i5 == 1) {
                    i4 = 3;
                }
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i4);
            }
            if (yh9Var.O() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, yh9Var.O().isWorksInfo() ? 1 : 0);
            }
            if (PermissionUtil.isBrowseMode()) {
                statisticItem.param(TiebaStatic.Params.PURE_BROWSING, 1);
            }
            if (zfaVar != null && zfaVar.a0() != null) {
                if (str3 == null) {
                    str3 = "";
                }
                statisticItem.addParam("obj_id", str3);
                if (str2 == null) {
                    str2 = "";
                }
                statisticItem.addParam("obj_name", str2);
                statisticItem.addParam("resource_id", zfaVar.a0().h());
                statisticItem.addParam(TiebaStatic.Params.OBJ_TO, zfaVar.a0().d());
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
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

    public static String m(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getIntent() != null) {
                return tbPageContext.getPageActivity().getIntent().getStringExtra("thread_id");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static int n(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && (tbPageContext.getPageActivity() instanceof AbsPbActivity)) {
                AbsPbActivity absPbActivity = (AbsPbActivity) tbPageContext.getPageActivity();
                if (absPbActivity.I1() != null && absPbActivity.I1().s1() != null) {
                    return absPbActivity.I1().s1().G();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void o(w05 w05Var, int i, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65551, null, w05Var, i, tbPageContext) == null) {
            p(w05Var, i, tbPageContext, "1");
        }
    }

    public static void u(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(65557, null, str, i, i2) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    public static void v(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65558, null, str, str2, i) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("fid", str2);
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    public static void p(w05 w05Var, int i, TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65552, null, w05Var, i, tbPageContext, str) == null) && w05Var != null && w05Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (w05Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", l(w05Var.getThreadData().getForumData().l));
            }
            statisticItem.param("obj_locate", w05Var.getThreadData().floorNum);
            statisticItem.param("tid", w05Var.getThreadData().getTid());
            statisticItem.param("fid", w05Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i);
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, str);
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, m(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, n(tbPageContext));
            TiebaStatic.log(statisticItem);
        }
    }

    public static void r(w05 w05Var, TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65554, null, w05Var, tbPageContext, str) == null) && w05Var != null && w05Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            if (w05Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", l(w05Var.getThreadData().getForumData().l));
            }
            statisticItem.param("tid", w05Var.getThreadData().getTid());
            statisticItem.param("fid", w05Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, str);
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, m(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, n(tbPageContext));
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, w05Var.position + 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void t(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65556, null, str, str2, str3) != null) || StringUtils.isNull(str)) {
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

    public static void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, null, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c14888");
            statisticItem.addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, str) == null) {
            TiebaStatic.log(new StatisticItem(str));
        }
    }
}
