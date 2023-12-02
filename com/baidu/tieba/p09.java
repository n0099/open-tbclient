package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, w09 w09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, statisticItem, w09Var) == null) {
            int i = 5;
            String str = "";
            if (w09Var != null) {
                YyExtData g = w09Var.g();
                if (g != null) {
                    if (g.isYyGame) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                if (!TextUtils.isEmpty(w09Var.e())) {
                    statisticItem.param("obj_param1", w09Var.e());
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
    }

    public static void b(StatisticItem statisticItem, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65537, null, statisticItem, str, str2, str3, str4) == null) && statisticItem != null) {
            if (!TextUtils.isEmpty(str)) {
                statisticItem.param("fid", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                statisticItem.param("fname", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                statisticItem.param("uid", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                statisticItem.param("tid", str4);
            }
        }
    }

    public static void c(int i, String str, String str2, String str3, String str4, w09 w09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, str2, str3, str4, w09Var}) == null) {
            StatisticItem statisticItem = new StatisticItem("c15008");
            statisticItem.param("obj_locate", i);
            b(statisticItem, str, str2, str3, str4);
            if (w09Var != null) {
                a(statisticItem, w09Var);
                TiebaStaticHelper.addYYParam(statisticItem, w09Var.g());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void d(String str, String str2, String str3, String str4, w09 w09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, str, str2, str3, str4, w09Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c15007");
            b(statisticItem, str, str2, str3, str4);
            if (w09Var != null) {
                a(statisticItem, w09Var);
                TiebaStaticHelper.addYYParam(statisticItem, w09Var.g());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void e(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str, str2) == null) {
            TiebaStatic.log(new StatisticItem("c13857").param("obj_type", i).param("post_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", str2));
        }
    }
}
