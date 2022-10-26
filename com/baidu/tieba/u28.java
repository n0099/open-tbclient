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
public class u28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(uv7 uv7Var, PostData postData, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65536, null, uv7Var, postData, i, i2) == null) {
            if (postData != null) {
                str = postData.M();
            } else {
                str = null;
            }
            c(uv7Var, postData, str, i, i2);
        }
    }

    public static void b(uv7 uv7Var, PostData postData, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{uv7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) != null) || uv7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        String str = null;
        if (postData != null) {
            str = postData.M();
        }
        h(statisticItem, uv7Var, postData, i, i2, false, str);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(uv7 uv7Var, PostData postData, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{uv7Var, postData, str, Integer.valueOf(i), Integer.valueOf(i2)}) != null) || uv7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, uv7Var, postData, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static StatisticItem i(uv7 uv7Var, PostData postData, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{uv7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str = null;
            if (uv7Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (postData != null) {
                str = postData.M();
            }
            h(statisticItem, uv7Var, postData, i, i2, false, str);
            statisticItem.param("obj_locate", i3);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void d(BdUniqueId bdUniqueId, uv7 uv7Var, PostData postData, int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bdUniqueId, uv7Var, postData, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (postData != null) {
                str = postData.M();
            } else {
                str = null;
            }
            String str2 = str;
            f(bdUniqueId, uv7Var, postData, str2, str2, i, i2);
        }
    }

    public static void e(BdUniqueId bdUniqueId, uv7 uv7Var, PostData postData, int i, int i2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bdUniqueId, uv7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            if (postData != null) {
                str2 = postData.M();
            } else {
                str2 = null;
            }
            String str3 = str2;
            g(bdUniqueId, uv7Var, postData, str3, str3, i, i2, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, uv7 uv7Var, PostData postData, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bdUniqueId, uv7Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) && bdUniqueId != null && uv7Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            h(statisticItem, uv7Var, postData, i, i2, false, str);
            sl8.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static void g(BdUniqueId bdUniqueId, uv7 uv7Var, PostData postData, String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, uv7Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) && bdUniqueId != null && uv7Var != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            h(statisticItem, uv7Var, postData, i, i2, false, str);
            statisticItem.param("common_exp_source_pb_comment", str3);
            sl8.g().d(bdUniqueId, str2, statisticItem);
        }
    }

    public static StatisticItem h(StatisticItem statisticItem, uv7 uv7Var, PostData postData, int i, int i2, boolean z, String str) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{statisticItem, uv7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str})) == null) {
            if (uv7Var == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", uv7Var.m() + "");
            StatisticItem param3 = param2.param("tid", uv7Var.R() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
            if (postData != null) {
                statisticItem.param("pid", postData.M() + "");
            }
            if (uv7Var.P() != null) {
                statisticItem.param("thread_type", uv7Var.P().threadType);
                BaijiahaoData baijiahaoData = uv7Var.P().getBaijiahaoData();
                if (baijiahaoData != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, baijiahaoData.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, baijiahaoData.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
                }
            }
            int i4 = 1;
            if (uv7Var.V() == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            statisticItem.param(TiebaStatic.Params.IS_UP, i3);
            if (uv7Var.P().isGoods()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (postData.Q() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else if (ol5.u(postData)) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 4);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (!uv7Var.k0()) {
                int i5 = uv7Var.g;
                if (i5 != 2) {
                    if (i5 == 1) {
                        i4 = 3;
                    } else {
                        i4 = 2;
                    }
                }
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i4);
            }
            if (uv7Var.P() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, uv7Var.P().isWorksInfo() ? 1 : 0);
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
                if (absPbActivity.i1() != null && absPbActivity.i1().S1() != null) {
                    return absPbActivity.i1().S1().I();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void m(ar4 ar4Var, int i, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65548, null, ar4Var, i, tbPageContext) == null) && ar4Var != null && ar4Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_click");
            if (ar4Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", j(ar4Var.getThreadData().getForumData().i));
            }
            statisticItem.param("obj_locate", ar4Var.getThreadData().floorNum);
            statisticItem.param("tid", ar4Var.getThreadData().getTid());
            statisticItem.param("fid", ar4Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i);
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, "1");
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
            TiebaStatic.log(statisticItem);
        }
    }

    public static void n(ar4 ar4Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, ar4Var, tbPageContext) == null) && ar4Var != null && ar4Var.getThreadData() != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            if (ar4Var.getThreadData().getForumData() != null) {
                statisticItem.param("obj_type", j(ar4Var.getThreadData().getForumData().i));
            }
            statisticItem.param("tid", ar4Var.getThreadData().getTid());
            statisticItem.param("fid", ar4Var.getThreadData().getFid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("page_type", "a005");
            statisticItem.param(TiebaStatic.Params.IS_REC, "1");
            statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
            statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, ar4Var.position + 1);
            TiebaStatic.log(statisticItem);
        }
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
