package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i) {
        int videoAutoPlayReal;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65536, null, i) == null) {
            if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() == -1) {
                videoAutoPlayReal = TbadkCoreApplication.getInst().getAutoPlaySwitch();
            } else {
                videoAutoPlayReal = TbadkCoreApplication.getInst().getVideoAutoPlayReal();
            }
            StatisticItem.make(CommonStatisticKey.KEY_VIDEO_AD_PLAY_SWITCH).param("obj_type", i).param(TiebaStatic.Params.OBJ_PARAM2, videoAutoPlayReal).eventStat();
        }
    }
}
