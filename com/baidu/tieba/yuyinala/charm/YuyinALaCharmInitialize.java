package com.baidu.tieba.yuyinala.charm;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaCharmRankActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinBannedPostActivityConfig;
import com.baidu.tieba.yuyinala.charm.audiencelist.YuyinALaAudiencesActivity;
import com.baidu.tieba.yuyinala.charm.bannedpost.YuyinBannedPostListActivity;
import com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity;
/* loaded from: classes10.dex */
public class YuyinALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(YuyinAlaCharmCardActivityConfig.class, YuyinALaAudiencesActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(YuyinAlaCharmRankActivityConfig.class, YuyinCharmRankTotalActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(YuyinBannedPostActivityConfig.class, YuyinBannedPostListActivity.class);
    }
}
