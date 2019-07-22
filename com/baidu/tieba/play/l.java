package com.baidu.tieba.play;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class l {
    static {
        ceb();
        cec();
    }

    private static void ceb() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PLAY_STATISTICS_CMD, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private static void cec() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_DURATION_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void a(String str, String str2, String str3, z zVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
        httpMessage.addParam("video_md5", str);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("obj_param2", str2);
        httpMessage.addParam("obj_type", str3);
        a(httpMessage, zVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(long j, String str, z zVar, String str2, long j2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS);
        httpMessage.addParam("obj_duration", j);
        httpMessage.addParam("obj_type", str);
        httpMessage.addParam("playduration", j2);
        if (zVar != null) {
            httpMessage.addParam("video_md5", zVar.ixC);
        }
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("obj_param2", str2);
        a(httpMessage, zVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void a(HttpMessage httpMessage, z zVar) {
        if (httpMessage != null && zVar != null) {
            httpMessage.addParam("tid", zVar.bWO);
            httpMessage.addParam("fid", zVar.eFy);
            httpMessage.addParam("obj_to", zVar.ixy);
            httpMessage.addParam(VideoPlayActivityConfig.OBJ_ID, zVar.bGR);
            httpMessage.addParam("obj_param3", zVar.ixz);
            httpMessage.addParam(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, zVar.mSource);
            httpMessage.addParam("obj_locate", zVar.mLocate);
            httpMessage.addParam("obj_param1", zVar.ixA);
            if (!StringUtils.isNull(zVar.ixD)) {
                httpMessage.addParam("topic_type", zVar.ixD);
            }
            if (!StringUtils.isNull(zVar.ixE)) {
                httpMessage.addParam("is_vertical", zVar.ixE);
            }
        }
    }
}
