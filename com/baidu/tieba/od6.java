package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class od6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, YyExtData yyExtData, int i, long j, int i2, long j2, long j3, int i3, String str2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, yyExtData, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), str2, Integer.valueOf(i4)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", i);
            statisticItem.param("tid", j);
            statisticItem.param("obj_type", i2);
            statisticItem.param(TiebaStatic.Params.STAR_ID, j2);
            statisticItem.param("liveid", j3);
            if (yyExtData != null) {
                b(statisticItem, yyExtData);
                if (yyExtData.isYyGame) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                str2 = TiebaStatic.YYValues.YY_LIVE;
            }
            statisticItem.param("obj_param1", i3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            statisticItem.param("obj_locate", i4);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(StatisticItem statisticItem, YyExtData yyExtData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, statisticItem, yyExtData) == null) && yyExtData != null) {
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
            statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
            statisticItem.param(TiebaStatic.YYParams.YYSSID, yyExtData.mSsid);
            statisticItem.param(TiebaStatic.YYParams.YYUID, yyExtData.mYyUid);
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.param("template_id", yyExtData.mTemplateId);
        }
    }

    public static StatisticItem c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            return d(str, i, -1, null, "0");
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public static StatisticItem d(String str, int i, int i2, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3})) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", str3);
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

    public static StatisticItem e(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, str2)) == null) {
            return d(str, i, -1, null, str2);
        }
        return (StatisticItem) invokeLIL.objValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if ("recommend".equals(str)) {
                return 1;
            }
            if (ImageViewerConfig.FROM_CONCERN.equals(str)) {
                return 2;
            }
            if ("ala_sub_tab".equals(str)) {
                return 3;
            }
            if ("ala_sub_list".equals(str)) {
                return 4;
            }
            if ("video_recommend".equals(str)) {
                return 5;
            }
            if ("video_concern".equals(str)) {
                return 6;
            }
            if ("big_pic".equals(str)) {
                return 7;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
