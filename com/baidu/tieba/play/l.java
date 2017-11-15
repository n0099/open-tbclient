package com.baidu.tieba.play;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class l {
    static {
        bhw();
        bhx();
    }

    private static void bhw() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PLAY_STATISTICS_CMD, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private static void bhx() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_DURATION_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void a(String str, String str2, String str3, x xVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
        httpMessage.addParam("video_md5", str);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("obj_param2", str2);
        httpMessage.addParam("obj_type", str3);
        a(httpMessage, xVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(long j, String str, x xVar, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS);
        httpMessage.addParam("obj_duration", j);
        httpMessage.addParam("obj_type", str);
        if (xVar != null) {
            httpMessage.addParam("video_md5", xVar.fHn);
        }
        httpMessage.addParam(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("obj_param2", str2);
        a(httpMessage, xVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void a(HttpMessage httpMessage, x xVar) {
        if (httpMessage != null && xVar != null) {
            httpMessage.addParam("tid", xVar.aMq);
            httpMessage.addParam(ImageViewerConfig.FORUM_ID, xVar.azM);
            httpMessage.addParam("obj_to", xVar.fHj);
            httpMessage.addParam("obj_id", xVar.Wo);
            httpMessage.addParam("obj_param3", xVar.fHk);
            httpMessage.addParam(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, xVar.mSource);
            httpMessage.addParam("obj_locate", xVar.mLocate);
            httpMessage.addParam("obj_param1", xVar.fHl);
        }
    }
}
