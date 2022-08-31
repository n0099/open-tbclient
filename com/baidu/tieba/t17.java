package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class t17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, str, obj, i, str2) == null) {
            if (obj instanceof xx6) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", i);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("topic_id", ((xx6) obj).a);
                statisticItem.param("obj_source", str2);
                statisticItem.eventStat();
            }
            if (obj instanceof SpecialColumnItemData) {
                SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
                StatisticItem statisticItem2 = new StatisticItem(str);
                statisticItem2.param("obj_type", 2);
                statisticItem2.param("obj_locate", i);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", specialColumnItemData.threadId);
                statisticItem2.param("obj_id", specialColumnItemData.liveId);
                statisticItem2.eventStat();
            } else if (obj instanceof MetaData) {
                StatisticItem statisticItem3 = new StatisticItem(str);
                statisticItem3.param("obj_type", 2);
                statisticItem3.param("obj_locate", i);
                statisticItem3.param("uid", ((MetaData) obj).getUserIdLong());
                statisticItem3.eventStat();
            } else if (obj instanceof vq4) {
                StatisticItem statisticItem4 = new StatisticItem(str);
                statisticItem4.param("obj_type", 2);
                statisticItem4.param("obj_locate", i);
                statisticItem4.param("fid", ((vq4) obj).j());
                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem4.eventStat();
            } else if (obj instanceof to4) {
                to4 to4Var = (to4) obj;
                StatisticItem statisticItem5 = new StatisticItem(str);
                statisticItem5.param("obj_type", 2);
                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem5.param("obj_locate", i);
                statisticItem5.param("obj_param1", to4Var.c());
                statisticItem5.param("obj_source", str2);
                d(statisticItem5, to4Var.c());
                statisticItem5.eventStat();
            } else if (obj instanceof Boolean) {
                StatisticItem statisticItem6 = new StatisticItem(str);
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", i);
                statisticItem6.eventStat();
            }
        }
    }

    public static void b(String str, Object obj, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, str, obj, i, str2) == null) {
            if (obj instanceof SpecialColumnItemData) {
                SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", i);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", specialColumnItemData.threadId);
                statisticItem.param("obj_id", specialColumnItemData.liveId);
                a06.b().a(statisticItem);
            } else if (obj instanceof MetaData) {
                StatisticItem statisticItem2 = new StatisticItem(str);
                statisticItem2.param("obj_type", 1);
                statisticItem2.param("obj_locate", i);
                statisticItem2.param("uid", ((MetaData) obj).getUserIdLong());
                a06.b().a(statisticItem2);
            } else if (obj instanceof vq4) {
                StatisticItem statisticItem3 = new StatisticItem(str);
                statisticItem3.param("obj_type", 1);
                statisticItem3.param("obj_locate", i);
                statisticItem3.param("fid", ((vq4) obj).j());
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                a06.b().a(statisticItem3);
            } else if (obj instanceof to4) {
                to4 to4Var = (to4) obj;
                StatisticItem statisticItem4 = new StatisticItem(str);
                statisticItem4.param("obj_type", 1);
                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem4.param("obj_locate", i);
                statisticItem4.param("obj_param1", to4Var.c());
                statisticItem4.param("obj_source", str2);
                d(statisticItem4, to4Var.c());
                a06.b().a(statisticItem4);
            }
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", 1);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_source", str2);
            a06.b().a(statisticItem);
        }
    }

    public static void d(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c14826");
            if ("游戏".equals(str)) {
                statisticItem.param("obj_locate", 1);
            }
            if ("数码".equals(str)) {
                statisticItem.param("obj_locate", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14472");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            TiebaStatic.log(new StatisticItem("c14521"));
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14486");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void i(int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            StatisticItem statisticItem = new StatisticItem("c14490");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i);
            statisticItem.param("obj_source", i2);
            statisticItem.param("obj_param1", i3);
            statisticItem.param("obj_id", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14492");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static StatisticItem k(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) ? l(str, i, -1, null) : (StatisticItem) invokeLI.objValue;
    }

    public static StatisticItem l(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", 0);
            statisticItem.param("obj_locate", i);
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            if (i2 >= 0) {
                statisticItem.param("obj_param1", i2);
            }
            if (!StringUtils.isNull(str2)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void m(View view2, go4 go4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65548, null, view2, go4Var, str) == null) || go4Var == null || go4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = go4Var.getThreadData();
        int id = view2.getId();
        if (view2.getId() == R.id.obfuscated_res_0x7f09212d || id == R.id.obfuscated_res_0x7f092141) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f09242b) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f092459) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f090a75 || id == R.id.obfuscated_res_0x7f090a4d) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f092141) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (view2 instanceof TbImageView) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f091711 || id == R.id.obfuscated_res_0x7f0906d7) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c14825");
            if ("游戏".equals(str)) {
                statisticItem.param("obj_locate", 1);
            }
            if ("数码".equals(str)) {
                statisticItem.param("obj_locate", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14479");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            TiebaStatic.log(new StatisticItem("c14520"));
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14485");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void r(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65553, null, i, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c14489");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i);
            statisticItem.param("obj_source", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14491");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void t(go4 go4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, go4Var, str) == null) || go4Var == null || go4Var.getThreadData() == null) {
            return;
        }
        if (go4Var.getThreadData().isVideoThreadType()) {
            a06.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(go4Var.getThreadData(), str));
        } else {
            a06.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(go4Var.getThreadData(), str));
        }
    }
}
