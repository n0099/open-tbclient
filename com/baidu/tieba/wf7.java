package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class wf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, statisticItem, threadData, tbPageTag) == null) {
            if (!hi.isEmpty(threadData.mRecomWeight)) {
                statisticItem.param(TiebaStatic.Params.RECOM_WEIGHT, threadData.mRecomWeight);
            }
            if (!hi.isEmpty(threadData.mRecomExtra)) {
                statisticItem.param(TiebaStatic.Params.RECOM_EXTRA, threadData.mRecomExtra);
            }
            if (!hi.isEmpty(threadData.mRecomSource)) {
                statisticItem.param("recom_source", threadData.mRecomSource);
            }
            if (!hi.isEmpty(threadData.mRecomAbTag)) {
                statisticItem.param(TiebaStatic.Params.RECOM_AB_TAG, threadData.mRecomAbTag);
            }
            statisticItem.param(TiebaStatic.Params.RECOM_TYPE, threadData.getRecomCardType());
            kl5.a(statisticItem, tbPageTag);
        }
    }

    public static void b(ThreadData threadData, TbPageTag tbPageTag, String str) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65537, null, threadData, tbPageTag, str) != null) || threadData == null) {
            return;
        }
        int i2 = 2;
        if ("a070".equals(tbPageTag.locatePage)) {
            i = 1;
        } else if ("a071".equals(tbPageTag.locatePage)) {
            i = 2;
        } else {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", threadData.tid);
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("fname", threadData.getForum_name());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo()));
            if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, threadData.getAuthor().getAlaInfo().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, (threadData.getAuthor().getAlaInfo().live_status == 1 || threadData.getAuthor().getAlaInfo().friendRoomStatus == 2) ? 1 : 1);
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.getYYStaticticType());
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    public static void d(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65539, null, threadData, str, i) != null) || threadData == null) {
            return;
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", threadData.tiePlusFrsStaticLocate);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i);
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            es4.a(es4.e, es4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (threadData.getRecomSource() != null && threadData.getRecomSource().startsWith("manual")) {
            es4.a(es4.l, es4.b, threadData.getRecomSource(), threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (!TextUtils.isEmpty(threadData.tiePlusMonitorClickUrl)) {
            ThirdStatisticHelper.sendReq(threadData.tiePlusMonitorClickUrl);
        }
    }

    public static void k(StatisticItem statisticItem, TbPageTag tbPageTag, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65546, null, statisticItem, tbPageTag, z) == null) && statisticItem != null && tbPageTag != null) {
            int i3 = 0;
            if ("a070".equals(tbPageTag.locatePage)) {
                i = 1;
            } else if ("a071".equals(tbPageTag.locatePage)) {
                i = 2;
            } else if ("a072".equals(tbPageTag.locatePage)) {
                i = 3;
            } else {
                int i4 = tbPageTag.tabType;
                if (92 != i4 && 49 != (i2 = tbPageTag.tabId) && 1120 != i2) {
                    if (16 == i4) {
                        i = 7;
                    } else if (3 == i4) {
                        i = 8;
                    } else if (90 == i2) {
                        i = 9;
                    } else if (505 == i2) {
                        i = 10;
                    } else if (100 == i4) {
                        i = 11;
                    } else if (tbPageTag.isGeneralTab == 1) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                } else {
                    i = 6;
                }
            }
            if (z) {
                if (i > 0) {
                    statisticItem.delete("obj_name");
                    statisticItem.param("obj_name", i);
                }
            } else if (i > 0) {
                statisticItem.delete("obj_locate");
                statisticItem.param("obj_locate", i);
            }
            int i5 = tbPageTag.sortType;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            i3 = 4;
                        }
                    } else {
                        i3 = 2;
                    }
                } else {
                    i3 = 1;
                }
            } else {
                i3 = 3;
            }
            if (i3 > 0) {
                if (i == 1 || i == 2) {
                    statisticItem.delete(TiebaStatic.Params.LIST_ORDER);
                    statisticItem.param(TiebaStatic.Params.LIST_ORDER, i3);
                }
            }
        }
    }

    @Deprecated
    public static void c(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, threadData, str) == null) {
            d(threadData, str, 1);
        }
    }

    public static void j(ThreadData threadData, int i) {
        StatisticItem k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, threadData, i) == null) {
            if (i != 2) {
                k = null;
            } else {
                k = sj9.k("c13692", threadData, 2);
            }
            TiebaStatic.log(k);
        }
    }

    public static void r(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65553, null, threadData, tbPageTag) != null) || threadData == null) {
            return;
        }
        b(threadData, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_SHOW);
    }

    public static void e(ThreadData threadData, int i, BdUniqueId bdUniqueId, xf7 xf7Var, TbPageTag tbPageTag) {
        boolean z;
        boolean z2;
        int i2;
        String str;
        boolean z3;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{threadData, Integer.valueOf(i), bdUniqueId, xf7Var, tbPageTag}) != null) || threadData == null) {
            return;
        }
        String str2 = null;
        if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z && threadData.getThreadAlaInfo().frsLiveStageType == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str2 = String.valueOf(threadData.getThreadAlaInfo().live_id);
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!z2) {
            if (threadData.getThreadType() == 41) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (threadData.getTaskInfoData() != null) {
                    str2 = threadData.getTaskInfoData().g();
                }
                i2 = 2;
            }
        }
        if (threadData.isHeadLinePost) {
            str2 = threadData.getId();
            i2 = 14;
            z2 = true;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z3 = true;
            i3 = 17;
        } else {
            str = str2;
            z3 = z2;
            i3 = i2;
        }
        StatisticItem c = sj9.c(threadData, "a006", "common_click", i, threadData.statFloor, z3, str, null, i3);
        if (c == null) {
            return;
        }
        c.param(TiebaStatic.Params.LIST_ORDER, yf7.k().l(xf7Var));
        df7.a(c);
        if (threadData.isGoods()) {
            c.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            c.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = c.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i4 = indexOf + 1;
                c.getParams().remove(i4);
                c.getParams().add(i4, 16);
            } else {
                c.param("obj_locate", 16);
            }
        } else if (av5.w(threadData)) {
            c.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            c.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(c, threadData, tbPageTag);
        if (threadData.isGoods()) {
            c.param(TiebaStatic.Params.GUA_TYPE, 1);
        }
        if (z) {
            c.param(TiebaStatic.Params.IS_OFFICIAL, threadData.getThreadAlaInfo().user_info.is_official);
        }
        if (z || threadData.isHeadLinePost || threadData.isSCard) {
            c.delete("thread_type");
            c.param("thread_type", threadData.getThreadType());
        }
        k(c, tbPageTag, true);
        uj9.g().c(bdUniqueId, c);
        j(threadData, i);
        q(threadData, tbPageTag, i);
    }

    public static void f(@NonNull PrivateForumPopInfoData privateForumPopInfoData, boolean z, @NonNull String str, @NonNull String str2, @NonNull boolean z2) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{privateForumPopInfoData, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2)}) == null) {
            StatisticItem statisticItem = new StatisticItem();
            String T = privateForumPopInfoData.T();
            int hashCode = T.hashCode();
            if (hashCode != 1348979648) {
                if (hashCode == 1741969413 && T.equals("left_time")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (T.equals("create_success")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c == 1) {
                    if (z) {
                        if (z2) {
                            statisticItem.key("c14682");
                        } else {
                            statisticItem.key("c14681");
                        }
                    } else if (z2) {
                        statisticItem.key("c14680");
                    } else {
                        statisticItem.key("c14679");
                    }
                }
            } else if (z) {
                if (z2) {
                    statisticItem.key("c14678");
                } else {
                    statisticItem.key("c14677");
                }
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.eventStat();
        }
    }

    public static void h(BdUniqueId bdUniqueId, int i, ForumData forumData, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{bdUniqueId, Integer.valueOf(i), forumData, Integer.valueOf(i2), Integer.valueOf(i3)}) != null) || i <= 0) {
            return;
        }
        StatisticItem f = sj9.f("a006", "common_fill", true, i, i3);
        if (forumData != null) {
            if (!hi.isEmpty(forumData.getId())) {
                f.param("fid", forumData.getId());
            }
            if (!hi.isEmpty(forumData.getName())) {
                f.param("fname", forumData.getName());
            }
            if (!hi.isEmpty(forumData.getFirst_class())) {
                f.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
            }
            if (!hi.isEmpty(forumData.getSecond_class())) {
                f.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
        }
        f.param(TiebaStatic.Params.LIST_ORDER, i2);
        uj9.g().c(bdUniqueId, f);
    }

    public static void g(ThreadData threadData, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, null, threadData, bdUniqueId, tbPageTag) == null) && threadData != null && bdUniqueId != null && threadData.isHeadLinePost) {
            if (threadData.getAuthor() != null && threadData.getAuthor().getUserId() != null && threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            } else {
                z = false;
            }
            if (threadData.isSmartFrsThread() && threadData.getFeedBackReasonMap() != null && !z) {
                StatisticItem param = new StatisticItem("common_exp").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", threadData.getId()).param(TiebaStatic.Params.OBJ_FLOOR, threadData.statFloor).param("fid", threadData.getFid()).param("thread_type", threadData.getThreadType()).param("tid", threadData.getId()).param(TiebaStatic.Params.FIRST_DIR, threadData.getFirstClassName()).param(TiebaStatic.Params.SECOND_DIR, threadData.getSecondClassName());
                a(param, threadData, tbPageTag);
                String b = sj9.b(threadData.getTid(), "", "", threadData.getBaijiahaoData());
                uj9 g = uj9.g();
                g.d(bdUniqueId, b + "_15", param);
            }
        }
    }

    public static void i(BdUniqueId bdUniqueId, List<hn> list, ForumData forumData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(65544, null, bdUniqueId, list, forumData, i) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) instanceof bx5) {
                i2++;
            }
            if (i2 <= 0) {
                return;
            }
            h(bdUniqueId, i2, forumData, i, 0);
        }
    }

    public static void l(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, threadData, tbPageTag) != null) || threadData == null) {
            return;
        }
        StatisticItem param = new StatisticItem("common_click").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", threadData.getId()).param("fid", threadData.getFid()).param(TiebaStatic.Params.OBJ_FLOOR, threadData.statFloor).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.FIRST_DIR, threadData.getFirstClassName()).param(TiebaStatic.Params.SECOND_DIR, threadData.getSecondClassName()).param("nid", threadData.getNid()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0);
        a(param, threadData, tbPageTag);
        TiebaStatic.log(param);
    }

    public static void m(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, threadData, tbPageTag) == null) && threadData != null && tbPageTag != null && threadData.isTiebaPlusAdThread) {
            int i = 2;
            if ("a071".equals(tbPageTag.locatePage)) {
                i = 3;
            } else if ("a072".equals(tbPageTag.locatePage)) {
                i = 5;
            } else if (tbPageTag.isGeneralTab == 1) {
                i = 4;
            }
            threadData.tiePlusFrsStaticLocate = i;
        }
    }

    public static void n(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65549, null, threadData, str) != null) || threadData == null) {
            return;
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", threadData.tiePlusFrsStaticLocate);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            es4.a(es4.d, es4.b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (threadData.getRecomSource() != null && threadData.getRecomSource().startsWith("manual")) {
            es4.a(es4.k, es4.b, threadData.getRecomSource(), threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (!TextUtils.isEmpty(threadData.tiePlusMonitorShowUrl)) {
            ThirdStatisticHelper.sendReq(threadData.tiePlusMonitorShowUrl);
        }
    }

    public static void o(ThreadData threadData, BdUniqueId bdUniqueId, xf7 xf7Var, TbPageTag tbPageTag) {
        boolean z;
        boolean z2;
        int i;
        String str;
        boolean z3;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65550, null, threadData, bdUniqueId, xf7Var, tbPageTag) != null) || threadData == null) {
            return;
        }
        String str2 = null;
        if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z && threadData.getThreadAlaInfo().frsLiveStageType == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str2 = String.valueOf(threadData.getThreadAlaInfo().live_id);
            i = 4;
        } else {
            i = 0;
        }
        if (!z2) {
            if (threadData.getThreadType() == 41) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (threadData.getTaskInfoData() != null) {
                    str2 = threadData.getTaskInfoData().g();
                }
                i = 2;
            }
        }
        if (threadData.isHeadLinePost) {
            str2 = threadData.getId();
            i = 14;
            z2 = true;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z3 = true;
            i2 = 17;
        } else {
            str = str2;
            z3 = z2;
            i2 = i;
        }
        String str3 = str;
        StatisticItem d = sj9.d(threadData, "a006", "common_exp", threadData.statFloor, z3, str, null, i2);
        if (d == null) {
            return;
        }
        df7.a(d);
        d.param(TiebaStatic.Params.LIST_ORDER, yf7.k().l(xf7Var));
        if (threadData.isGoods()) {
            d.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            d.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (av5.w(threadData)) {
            d.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            d.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(d, threadData, tbPageTag);
        if (z) {
            d.param(TiebaStatic.Params.IS_OFFICIAL, threadData.getThreadAlaInfo().user_info.is_official);
        }
        if (z || threadData.isHeadLinePost || threadData.isSCard) {
            d.delete("thread_type");
            d.param("thread_type", threadData.getThreadType());
        }
        if (PermissionUtil.isBrowseMode()) {
            d.param(TiebaStatic.Params.PURE_BROWSING, 1);
        }
        k(d, tbPageTag, false);
        uj9.g().d(bdUniqueId, sj9.b(threadData.getTid(), str3, "", threadData.getBaijiahaoData()), d);
        if (threadData.isHeadLinePost) {
            g(threadData, bdUniqueId, tbPageTag);
        }
        r(threadData, tbPageTag);
        p(threadData);
    }

    public static void p(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, threadData) == null) && threadData != null && threadData.isXiuXiuThread()) {
            int i = 0;
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(threadData.getForum_name());
            if (itemInfo != null) {
                i = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem(CommonStatisticKey.KEY_XIUXIU_THREAD_SHOW).addParam("obj_locate", 1).addParam("fid", threadData.getFid()).addParam("fname", threadData.getForum_name()).addParam("post_id", threadData.getTid()).addParam("obj_id", i).addParam("obj_name", str).eventStat();
        }
    }

    public static void q(ThreadData threadData, TbPageTag tbPageTag, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65552, null, threadData, tbPageTag, i) != null) || threadData == null || 2 != i) {
            return;
        }
        b(threadData, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_CLICK);
    }
}
