package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yua {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65536, null, i) != null) || i == -1) {
            return;
        }
        new StatisticItem("c14823").addParam("obj_source", i).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_locate", 14).addParam("obj_type", i).eventStat();
        }
    }

    public static void c(WriteData writeData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, writeData) == null) && writeData != null && writeData.isFromGameRank()) {
            int i2 = 1;
            if (writeData.getXiuxiuOriginalContent() != null && !writeData.getXiuxiuOriginalContent().equals(writeData.getContent())) {
                i = 1;
            } else {
                i = 0;
            }
            new StatisticItem("c15065").addParam("obj_id", writeData.getGameId()).addParam("obj_name", writeData.getGameName()).addParam("obj_param1", i).addParam(TiebaStatic.Params.OBJ_PARAM2, (writeData.getXiuxiuOriginalFname() == null || writeData.getXiuxiuOriginalFname().equals(writeData.getForumName())) ? 0 : 0).eventStat();
        }
    }

    public static void d(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, writeData) == null) && writeData != null && writeData.isFromGameRank()) {
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
