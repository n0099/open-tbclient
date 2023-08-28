package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p1b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context instanceof Activity) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("from");
                if ("main_tab".equals(stringExtra)) {
                    return 0;
                }
                if ("frs".equals(stringExtra)) {
                    return 1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, context, i) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", i).param("obj_source", a(context)));
        }
    }

    public static void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(65538, null, i, i2) != null) || i == -1) {
            return;
        }
        new StatisticItem("c14823").addParam("obj_source", i).addParam("obj_locate", i2).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
    }

    public static void d(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, context, i) == null) {
            new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_locate", 14).addParam("obj_type", i).addParam("obj_source", a(context)).eventStat();
        }
    }

    public static void e(WriteData writeData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, writeData) == null) && writeData != null && writeData.isFromGameRank()) {
            int i2 = 1;
            if (writeData.getXiuxiuOriginalContent() != null && !writeData.getXiuxiuOriginalContent().equals(writeData.getContent())) {
                i = 1;
            } else {
                i = 0;
            }
            new StatisticItem("c15065").addParam("obj_id", writeData.getGameId()).addParam("obj_name", writeData.getGameName()).addParam("obj_param1", i).addParam(TiebaStatic.Params.OBJ_PARAM2, (writeData.getXiuxiuOriginalFname() == null || writeData.getXiuxiuOriginalFname().equals(writeData.getForumName())) ? 0 : 0).eventStat();
        }
    }

    public static void f(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, writeData) == null) && writeData != null && writeData.isFromGameRank()) {
            int i = 6;
            String rewardsType = writeData.getRewardsType();
            if (!TextUtils.isEmpty(rewardsType)) {
                if (rewardsType.equals("gift")) {
                    i = 1;
                } else if (rewardsType.equals("coupon")) {
                    i = 2;
                } else if (rewardsType.equals("imprint")) {
                    i = 3;
                } else if (rewardsType.equals("memberCard")) {
                    i = 4;
                } else if (rewardsType.equals("experience")) {
                    i = 5;
                }
            }
            new StatisticItem("c15064").addParam("obj_id", writeData.getGameId()).addParam("obj_name", writeData.getGameName()).addParam("obj_param1", i).eventStat();
        }
    }
}
