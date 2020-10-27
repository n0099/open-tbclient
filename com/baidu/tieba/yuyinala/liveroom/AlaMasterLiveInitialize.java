package com.baidu.tieba.yuyinala.liveroom;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaMasterLiveRoomActivityConfig;
import com.baidu.tieba.yuyinala.liveroom.master.YuyinAlaCreateLiveRoomActivity;
/* loaded from: classes4.dex */
public class AlaMasterLiveInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(YuyinAlaMasterLiveRoomActivityConfig.class, YuyinAlaCreateLiveRoomActivity.class);
    }
}
