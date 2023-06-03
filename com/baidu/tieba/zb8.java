package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, gc8 gc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, statisticItem, gc8Var) == null) {
            int i = 5;
            String str = "";
            if (gc8Var != null) {
                YyExtData g = gc8Var.g();
                if (g != null) {
                    if (g.isYyGame) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                if (!TextUtils.isEmpty(gc8Var.e())) {
                    statisticItem.param("obj_param1", gc8Var.e());
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

    public static void c(int i, String str, String str2, String str3, String str4, gc8 gc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, str2, str3, str4, gc8Var}) == null) {
            StatisticItem statisticItem = new StatisticItem("c15008");
            statisticItem.param("obj_locate", i);
            b(statisticItem, str, str2, str3, str4);
            if (gc8Var != null) {
                a(statisticItem, gc8Var);
                TiebaStaticHelper.addYYParam(statisticItem, gc8Var.g());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void d(String str, String str2, String str3, @NonNull AlaInfoData alaInfoData) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, str, str2, str3, alaInfoData) == null) {
            StatisticItem param = new StatisticItem("c13711").param("fid", str).param("fname", str2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", str3);
            String str5 = "";
            if (alaInfoData.user_info == null) {
                str4 = "";
            } else {
                str4 = "" + alaInfoData.user_info.user_id;
            }
            StatisticItem param2 = param.param("obj_param1", str4);
            int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData);
            if (alaInfoData.isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, alaInfoData.mYyExtData);
                str5 = TiebaStatic.YYValues.YY_LIVE;
            }
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str5);
            TiebaStatic.log(param2);
        }
    }

    public static void e(String str, String str2, String str3, String str4, gc8 gc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, str4, gc8Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c15007");
            b(statisticItem, str, str2, str3, str4);
            if (gc8Var != null) {
                a(statisticItem, gc8Var);
                TiebaStaticHelper.addYYParam(statisticItem, gc8Var.g());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void f(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65541, null, i, str, str2) == null) {
            TiebaStatic.log(new StatisticItem("c13857").param("obj_type", i).param("post_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", str2));
        }
    }
}
