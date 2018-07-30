package com.baidu.tieba.video;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.video.cloudmusic.CloudMusicActivity;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.tieba.video.record.ResponseGetStickersMessage;
/* loaded from: classes2.dex */
public class Static {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(RecordVideoActivityConfig.class, RecordVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EditVideoActivityConfig.class, EditVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CloudMusicActivityConfig.class, CloudMusicActivity.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
