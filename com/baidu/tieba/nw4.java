package com.baidu.tieba;

import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes5.dex */
public interface nw4 {
    IconPopData getIconPopData();

    LevePopData getLevePopData();

    List<AlaLiveInfo> getLiveFollowSecondFloor();

    List<AlaLiveInfo> getLiveIndexSecondFloor();

    LiveRemindData getLiveRemindData();
}
