package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class li8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "2";
    public static final String b = "1";
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, String str3, int i, boolean z) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, str3, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem("c14740");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_id", str);
            statisticItem.addParam("obj_name", str2);
            if (z) {
                str4 = a;
            } else {
                str4 = b;
            }
            statisticItem.addParam("obj_type", str4);
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam(TiebaStatic.Params.FRIEND_UID, str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void e(String str, String str2, String str3, int i, boolean z) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem("c14739");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_id", str);
            statisticItem.addParam("obj_name", str2);
            if (z) {
                str4 = a;
            } else {
                str4 = b;
            }
            statisticItem.addParam("obj_type", str4);
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam(TiebaStatic.Params.FRIEND_UID, str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public static StatisticItem g(String str, String str2, String str3, int i, boolean z) {
        InterceptResult invokeCommon;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, str2, str3, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_id", str2);
            statisticItem.addParam("obj_name", str3);
            if (z) {
                str4 = a;
            } else {
                str4 = b;
            }
            statisticItem.addParam("obj_type", str4);
            statisticItem.addParam("obj_locate", i);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void h(String str, String str2, String str3, int i, boolean z) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem("c14738");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_id", str);
            statisticItem.addParam("obj_name", str2);
            if (z) {
                str4 = a;
            } else {
                str4 = b;
            }
            statisticItem.addParam("obj_type", str4);
            statisticItem.addParam("obj_locate", i);
            statisticItem.addParam(TiebaStatic.Params.FRIEND_UID, str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str, String str2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            TiebaStatic.log(g("c14742", str, str2, i, z));
        }
    }

    public static void d(String str, String str2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            TiebaStatic.log(g("c14744", str, str2, i, z));
        }
    }

    public static void c(String str, String str2, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            StatisticItem g = g("c14743", str, str2, i, z);
            g.addParam("obj_source", i2);
            TiebaStatic.log(g);
        }
    }

    public static void f(String str, String str2, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            StatisticItem g = g("c14741", str, str2, i, z);
            g.addParam("obj_source", i2);
            TiebaStatic.log(g);
        }
    }
}
