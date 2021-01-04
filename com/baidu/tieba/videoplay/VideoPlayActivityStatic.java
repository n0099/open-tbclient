package com.baidu.tieba.videoplay;

import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes8.dex */
public class VideoPlayActivityStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(VideoPlayActivityConfig.class, VideoPlayActivity.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003399, TbConfig.SERVER_ADDRESS + Config.VIDEO_MIDDLE_AGGREGATION);
        tbHttpMessageTask.setResponsedClass(ResponseGetNaniVideoMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
