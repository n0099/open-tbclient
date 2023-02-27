package com.baidu.tieba;

import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tbadk.data.SubscribeGroupUnreadMsgData;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes5.dex */
public interface m45 {
    ChatRoomEntranceData getChatRoomEntranceData();

    xb5 getFestivalConfigData();

    IconPopData getIconPopData();

    LevePopData getLevePopData();

    List<AlaLiveInfo> getLiveFollowSecondFloor();

    List<AlaLiveInfo> getLiveIndexSecondFloor();

    List<AlaLiveInfo> getLivePicSecondFloor();

    LiveRemindData getLiveRemindData();

    MemberBroadcastData getMemberBroadcastData();

    SubscribeGroupUnreadMsgData getSubscribeChatHaveUnReadMsg();

    String getUniqueId();
}
