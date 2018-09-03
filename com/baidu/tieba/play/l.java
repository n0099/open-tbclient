package com.baidu.tieba.play;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class l {
    static {
        bkl();
        bkm();
    }

    private static void bkl() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PLAY_STATISTICS_CMD, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private static void bkm() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_DURATION_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void a(String str, String str2, String str3, y yVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
        httpMessage.addParam("video_md5", str);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("obj_param2", str2);
        httpMessage.addParam("obj_type", str3);
        a(httpMessage, yVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(long j, String str, y yVar, String str2, long j2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS);
        httpMessage.addParam("obj_duration", j);
        httpMessage.addParam("obj_type", str);
        httpMessage.addParam("playduration", j2);
        if (yVar != null) {
            httpMessage.addParam("video_md5", yVar.ghF);
        }
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("obj_param2", str2);
        a(httpMessage, yVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void a(HttpMessage httpMessage, y yVar) {
        if (httpMessage != null && yVar != null) {
            httpMessage.addParam("tid", yVar.aWq);
            httpMessage.addParam(ImageViewerConfig.FORUM_ID, yVar.cBR);
            httpMessage.addParam("obj_to", yVar.ghB);
            httpMessage.addParam(VideoPlayActivityConfig.OBJ_ID, yVar.afx);
            httpMessage.addParam("obj_param3", yVar.ghC);
            httpMessage.addParam(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, yVar.mSource);
            httpMessage.addParam("obj_locate", yVar.mLocate);
            httpMessage.addParam("obj_param1", yVar.ghD);
            if (!StringUtils.isNull(yVar.ghG)) {
                httpMessage.addParam("topic_type", yVar.ghG);
            }
            if (!StringUtils.isNull(yVar.ghH)) {
                httpMessage.addParam("is_vertical", yVar.ghH);
            }
        }
    }
}
