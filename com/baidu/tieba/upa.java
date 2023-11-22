package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class upa {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948220067, "Lcom/baidu/tieba/upa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948220067, "Lcom/baidu/tieba/upa;");
                return;
            }
        }
        a = Arrays.asList("a006", "a005", "a008", "a002");
    }

    public static void a(StatisticItem statisticItem, AlaInfoData alaInfoData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, statisticItem, alaInfoData) == null) && alaInfoData != null && alaInfoData.mYyExtData != null) {
            if (alaInfoData.live_status == 1) {
                str = "1";
            } else {
                str = "2";
            }
            statisticItem.addParam("obj_source", str).addParam(TiebaStatic.Params.OBJ_TO, alaInfoData.mPageFrom.intValue()).addParam("obj_type", YYLiveUtil.calculateLiveType(alaInfoData)).addParam(TiebaStatic.Params.OBJ_PARAM3, l(alaInfoData)).addParam("hdid", TbadkCoreApplication.getInst().getHdid()).addParam(TiebaStatic.YYParams.YYSID, alaInfoData.mYyExtData.mSid).addParam(TiebaStatic.YYParams.YYSSID, alaInfoData.mYyExtData.mSsid).addParam("yyuid", alaInfoData.mYyExtData.mYyUid).addParam(TiebaStatic.YYParams.YYLIVEID, r(alaInfoData.mYyExtData)).addParam("template_id", alaInfoData.mYyExtData.mTemplateId);
        }
    }

    public static void b(StatisticItem statisticItem, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, statisticItem, threadData) == null) && threadData != null && threadData.getThreadType() == 74) {
            statisticItem.addParam("obj_name", "1").addParam("fid", threadData.getFid()).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("tid", threadData.getTid());
            if (!TextUtils.isEmpty(threadData.getForum_name())) {
                statisticItem.addParam("fname", threadData.getForum_name());
                return;
            }
            OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
            if (originalThreadInfo != null && !TextUtils.isEmpty(originalThreadInfo.d)) {
                statisticItem.addParam("fname", threadData.originalThreadData.d);
            }
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return "enterfourm_att_" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String l(@NonNull AlaInfoData alaInfoData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, alaInfoData)) == null) {
            if (!StringUtils.isNull(alaInfoData.appId)) {
                str = alaInfoData.appId;
            } else {
                str = null;
            }
            if (alaInfoData.mYyExtData != null) {
                return TiebaStatic.YYValues.YY_LIVE;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static int p(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, mediaData)) == null) {
            if (mediaData == null) {
                return 0;
            }
            if (mediaData.getLottieType() == 1) {
                return 1;
            }
            if (mediaData.getType() == 3) {
                return 2;
            }
            if (mediaData.getType() != 5) {
                return 0;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public static String r(YyExtData yyExtData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, yyExtData)) == null) {
            if (s(yyExtData)) {
                return "1";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean s(YyExtData yyExtData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, yyExtData)) == null) {
            if (yyExtData != null && !TextUtils.isEmpty(yyExtData.mSid)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String d(String str, String str2, String str3, BaijiahaoData baijiahaoData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, baijiahaoData)) == null) {
            String str4 = "_tid_" + str;
            if (!TextUtils.isEmpty(str2)) {
                str4 = str4 + "_adid_" + str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str4 = str4 + "_appid_" + str3;
            }
            if (baijiahaoData != null) {
                return str4 + "_nid_" + baijiahaoData.oriUgcNid;
            }
            return str4;
        }
        return (String) invokeLLLL.objValue;
    }

    public static StatisticItem o(String str, ThreadData threadData, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65551, null, str, threadData, i, i2)) == null) {
            if (threadData == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", threadData.getTid()).param("fid", threadData.getFid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", threadData.isWorksInfo() ? 1 : 0);
            if (i != 0) {
                statisticItem.param("obj_locate", i);
            }
            if (i2 != 0) {
                statisticItem.param("obj_type", i2);
            }
            if (str == "c13696" && threadData.getAuthor() != null) {
                statisticItem.param(TiebaStatic.Params.IS_FOLLOW, threadData.getAuthor().getIsLike() ? 1 : 0);
            }
            if (BdLog.isDebugMode()) {
                Log.d("CardSimpleStatisticItem", statisticItem.toString());
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLLII.objValue;
    }

    public static StatisticItem e(ThreadData threadData, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{threadData, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str3, str4, Integer.valueOf(i3)})) == null) {
            if (threadData == null) {
                return null;
            }
            return v(true, threadData, str, str2, i, i2, z, str3, str4, false, "", i3);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem f(ThreadData threadData, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{threadData, str, str2, Integer.valueOf(i), Boolean.valueOf(z), str3, str4, Integer.valueOf(i2)})) == null) {
            if (threadData == null) {
                return null;
            }
            return v(false, threadData, str, str2, -1, i, z, str3, str4, false, "", i2);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem g(String str, String str2, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return h(str, str2, z, i, 0);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void u(String str, ThreadData threadData, AlaInfoData alaInfoData, Long l) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65557, null, str, threadData, alaInfoData, l) == null) && threadData != null && !TextUtils.isEmpty(str) && threadData.getThreadType() == 74) {
            StatisticItem statisticItem = new StatisticItem(str);
            if (l.longValue() > 0) {
                statisticItem.addParam(TiebaStatic.Params.OBJ_DURATION, l.longValue());
            }
            b(statisticItem, threadData);
            a(statisticItem, alaInfoData);
            statisticItem.eventStat();
        }
    }

    public static StatisticItem h(String str, String str2, boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str2);
            statisticItem.param("page_type", str).param("ad_exp", z ? 1 : 0).param("ad_exp_cnt", i).param(TiebaStatic.Params.OBJ_FLOOR, 0).param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            if (str != null && a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem i(ThreadData threadData, String str, String str2, int i, int i2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{threadData, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3})) == null) {
            if (threadData == null) {
                return null;
            }
            return v(true, threadData, str, str2, i, i2, false, "", null, true, str3, 0);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static String q(boolean z, String str, boolean z2, String str2, String str3, BaijiahaoData baijiahaoData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2), str2, str3, baijiahaoData})) == null) {
            if (!z) {
                if (z2) {
                    return str2;
                }
                if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                    return baijiahaoData.oriUgcNid;
                }
                return str3;
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    public static StatisticItem j(ThreadData threadData, String str, String str2, int i, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{threadData, str, str2, Integer.valueOf(i), str3})) == null) {
            if (threadData == null) {
                return null;
            }
            return v(false, threadData, str, str2, -1, i, false, "", null, true, str3, 0);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem k(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2), str3, str4, Integer.valueOf(i3)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str2);
            StatisticItem param = statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i2).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0);
            if (!z2) {
                str3 = str4;
            }
            param.param("obj_id", str3).param(TiebaStatic.Params.OBJ_AD_LOCATE, i3);
            if (str != null && a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (z) {
                statisticItem.param("obj_locate", i);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem m(String str, ThreadData threadData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, threadData)) == null) {
            return o(str, threadData, 0, 0);
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem n(String str, ThreadData threadData, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, str, threadData, i)) == null) {
            return o(str, threadData, i, 0);
        }
        return (StatisticItem) invokeLLI.objValue;
    }

    public static void t(String str, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65556, null, str, threadData, i) == null) && threadData != null && !TextUtils.isEmpty(str) && threadData.getThreadType() == 74) {
            StatisticItem statisticItem = new StatisticItem(str);
            if (CommonStatisticKey.KEY_LIVE_MERGE_CARD_CLICK.equals(str)) {
                statisticItem.addParam("obj_locate", i);
            }
            b(statisticItem, threadData);
            a(statisticItem, threadData.getThreadAlaInfo());
            statisticItem.eventStat();
        }
    }

    public static StatisticItem v(boolean z, ThreadData threadData, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        InterceptResult invokeCommon;
        int threadType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Boolean.valueOf(z), threadData, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2), str3, str4, Boolean.valueOf(z3), str5, Integer.valueOf(i3)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str2);
            StatisticItem param = statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i2).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0).param("obj_id", q(z2, str3, z3, str5, threadData.getId(), threadData.getBaijiahaoData())).param("tid", threadData.getTid());
            if (z2) {
                threadType = -1;
            } else {
                threadType = threadData.getThreadType();
            }
            param.param("thread_type", threadType).param(TiebaStatic.Params.OBJ_AD_LOCATE, i3).param("nid", threadData.getNid());
            if (!qd.isEmpty(threadData.getRecomSource())) {
                statisticItem.param("list_strategy", threadData.getRecomSource());
            }
            if (str != null && a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().k)) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            } else if (!qd.isEmpty(threadData.mRecomAbTag)) {
                statisticItem.param("ab_tag", threadData.mRecomAbTag);
            }
            if (z) {
                statisticItem.param("obj_locate", i);
            }
            if (threadData.getFid() > 0) {
                statisticItem.param("fid", threadData.getFid());
            }
            if (threadData.getForum_name() != null) {
                statisticItem.param("fname", threadData.getForum_name());
            }
            if (!StringUtils.isNull(threadData.getFirstClassName())) {
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, threadData.getFirstClassName());
            }
            if (!StringUtils.isNull(threadData.getSecondClassName())) {
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, threadData.getSecondClassName());
            }
            if (threadData.getBaijiahaoData() != null) {
                statisticItem.param(TiebaStatic.Params.UGC_VID, threadData.getBaijiahaoData().oriUgcVid);
                statisticItem.param(TiebaStatic.Params.UGC_NID, threadData.getBaijiahaoData().oriUgcNid);
            }
            if (!StringUtils.isNull(str4)) {
                statisticItem.param("pid", str4);
            }
            statisticItem.param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void w(ThreadData threadData, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65559, null, threadData, i, i2) == null) && threadData != null && !ListUtils.isEmpty(threadData.getThreadRecommendInfoDataList())) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_REASON);
            ThreadRecommendInfoData threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0);
            if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
                statisticItem.param("obj_type", i);
                statisticItem.param("obj_locate", i2);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("obj_param1", threadRecommendInfoData.businessId);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadRecommendInfoData.businessType);
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
