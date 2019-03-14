package com.baidu.tieba.videoEasterEgg;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
/* loaded from: classes4.dex */
public class VideoEasterEggActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(VideoEasterEggActivityConfig.class, VideoEasterEggActivity.class);
    }
}
