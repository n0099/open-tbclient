package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(GroupInfoData groupInfoData, MetaData metaData, int i) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65536, null, groupInfoData, metaData, i) != null) || !GroupInfoData.isValidGroup(groupInfoData)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
        statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.addParam("room_id", groupInfoData.getGroupId());
        statisticItem.addParam("fid", groupInfoData.getForumId());
        statisticItem.addParam("fname", groupInfoData.getForumName());
        if (metaData != null) {
            str = metaData.getUserId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            statisticItem.addParam(TiebaStatic.Params.FRIEND_UID, str);
        }
        statisticItem.addParam("obj_type", i);
        statisticItem.addParam("obj_source", 100);
        TiebaStatic.log(statisticItem);
    }

    public static void c(GroupInfoData groupInfoData, MetaData metaData, int i) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65538, null, groupInfoData, metaData, i) != null) || !GroupInfoData.isValidGroup(groupInfoData)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_GROUP_SHARE_SUCCESS);
        statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.addParam("room_id", groupInfoData.getGroupId());
        statisticItem.addParam("fid", groupInfoData.getForumId());
        statisticItem.addParam("fname", groupInfoData.getForumName());
        if (metaData != null) {
            str = metaData.getUserId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            statisticItem.addParam(TiebaStatic.Params.FRIEND_UID, str);
        }
        statisticItem.addParam("obj_type", i);
        statisticItem.addParam("obj_source", 1);
        TiebaStatic.log(statisticItem);
    }

    public static void b(GroupInfoData groupInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, groupInfoData) != null) || !GroupInfoData.isValidGroup(groupInfoData)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_GROUP_SHARE_PANEL_SHOW);
        statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.addParam("room_id", groupInfoData.getGroupId());
        statisticItem.addParam("fid", groupInfoData.getForumId());
        statisticItem.addParam("fname", groupInfoData.getForumName());
        statisticItem.addParam("obj_source", 1);
        TiebaStatic.log(statisticItem);
    }
}
