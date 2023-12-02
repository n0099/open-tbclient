package com.baidu.tieba;

import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tbadk.data.SubscribeGroupUnreadMsgData;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes7.dex */
public interface l45 {
    MemberBroadcastData getActivityBroadcastData();

    ChatRoomEntranceData getChatRoomEntranceData();

    xc5 getFestivalConfigData();

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
