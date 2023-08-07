package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ts8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948191888, "Lcom/baidu/tieba/ts8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948191888, "Lcom/baidu/tieba/ts8;");
        }
    }

    @JvmStatic
    public static final void a(ImMessageCenterShowItemData imMessageCenterShowItemData, Context context, BdUniqueId uniqueId) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, imMessageCenterShowItemData, context, uniqueId) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", "1");
            Intrinsics.checkNotNull(imMessageCenterShowItemData);
            TiebaStatic.log(param.param("obj_param1", imMessageCenterShowItemData.getUnReadCount()).param(TiebaStatic.Params.FRIEND_UID, imMessageCenterShowItemData.getFriendId()));
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                be5.p0().i0(be5.p0().x() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                String friendId = imMessageCenterShowItemData.getFriendId();
                Intrinsics.checkNotNullExpressionValue(friendId, "data.friendId");
                long parseLong = Long.parseLong(friendId);
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                if (imMessageCenterShowItemData.getRelation() == 1) {
                    i = 1;
                } else {
                    i = 0;
                }
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(context, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0, i);
                personalChatActivityConfig.setFrom(3);
                personalChatActivityConfig.setLastUniqueId(uniqueId.getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
