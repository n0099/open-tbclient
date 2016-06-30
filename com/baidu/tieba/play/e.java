package com.baidu.tieba.play;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class e {
    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PLAY_STATISTICS_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void k(String str, String str2, String str3, String str4) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
        httpMessage.addParam("video_md5", str);
        httpMessage.addParam("thread_id", str2);
        httpMessage.addParam("forum_id", str3);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("obj_locate", str4);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
