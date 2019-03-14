package com.baidu.tieba.videoplay;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes6.dex */
public class VideoPlayActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(VideoPlayActivityConfig.class, VideoPlayActivity.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_NANI_VIDEO, TbConfig.SERVER_ADDRESS + "c/f/video/getVideoMidPage");
        tbHttpMessageTask.setResponsedClass(ResponseGetNaniVideoMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
