package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public class ji7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, fqa fqaVar, ForumData forumData, int i, String str2) {
        StatisticItem d;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{str, fqaVar, forumData, Integer.valueOf(i), str2}) != null) || (d = d(str, fqaVar, forumData, i, str2)) == null) {
            return;
        }
        if (fqaVar != null && YYLiveUtil.isYYLiveLink(fqaVar.q())) {
            d.param(TiebaStatic.YYParams.YYLIVEID, 1);
        } else {
            d.param(TiebaStatic.YYParams.YYLIVEID, "");
        }
        d.param("obj_locate", 3);
        TiebaStatic.log(d);
        if (fqaVar != null) {
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(fqaVar.l(), 1));
        }
    }

    public static void f(String str, fqa fqaVar, ForumData forumData, int i, String str2) {
        StatisticItem d;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65541, null, new Object[]{str, fqaVar, forumData, Integer.valueOf(i), str2}) != null) || (d = d(str, fqaVar, forumData, i, str2)) == null) {
            return;
        }
        if (fqaVar != null && YYLiveUtil.isYYLiveLink(fqaVar.q())) {
            d.param(TiebaStatic.YYParams.YYLIVEID, 1);
        } else {
            d.param(TiebaStatic.YYParams.YYLIVEID, "");
        }
        TiebaStatic.log(d);
        if (fqaVar != null) {
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(fqaVar.l(), 0));
        }
    }

    public static void b(TbPageContext<?> tbPageContext, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, tbPageContext, str, str2, str3) == null) && !UtilHelper.isMatchScheme(tbPageContext.getPageActivity().getBaseContext(), str, str3) && str2 != null) {
            m0b.a(tbPageContext, str2);
        }
    }

    public static void c(String str, fqa fqaVar, ForumData forumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, str, fqaVar, forumData) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (fqaVar != null) {
            int i = 11;
            if (fqaVar.p() != 1) {
                if (fqaVar.p() == 2) {
                    i = 12;
                } else if (fqaVar.p() == 3) {
                    i = 13;
                } else if (fqaVar.p() == 4) {
                    i = 22;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
            statisticItem.param("obj_id", fqaVar.c());
        }
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId()).param("fname", forumData.getName());
        }
        TiebaStatic.log(statisticItem);
    }

    public static StatisticItem d(String str, fqa fqaVar, ForumData forumData, int i, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, fqaVar, forumData, Integer.valueOf(i), str2})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            if (fqaVar != null) {
                int i2 = 11;
                if (fqaVar.p() != 1) {
                    if (fqaVar.p() == 2) {
                        i2 = 12;
                    } else if (fqaVar.p() == 3) {
                        i2 = 13;
                    } else if (fqaVar.p() == 4) {
                        i2 = 22;
                    }
                }
                statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
                statisticItem.param("obj_id", fqaVar.c());
                if (fqaVar.p() == 1) {
                    statisticItem.param("tid", fqaVar.m());
                    statisticItem.param("thread_type", fqaVar.n());
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param("fname", forumData.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
            statisticItem.param("obj_type", i);
            if (i == 2 && !StringUtils.isNull(str2)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static boolean e(fqa fqaVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fqaVar, str)) == null) {
            if (fqaVar != null && !StringUtils.isNull(fqaVar.r())) {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                long j = sharedPrefHelper.getLong("key_frs_video_ad_last_show_time" + str, 0L);
                if (j < 0) {
                    return true;
                }
                return !TimeHelper.isSameDay(new Date(j), new Date(System.currentTimeMillis()));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
