package com.baidu.tieba.videoplay;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
/* loaded from: classes2.dex */
public class VideoPlayActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(VideoPlayActivityConfig.class, VideoPlayActivity.class);
    }
}
