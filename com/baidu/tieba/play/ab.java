package com.baidu.tieba.play;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ab {
    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PLAY_STATISTICS_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void a(String str, String str2, String str3, bb bbVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
        httpMessage.addParam("video_md5", str);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("obj_param2", str2);
        httpMessage.addParam("obj_type", str3);
        if (bbVar != null) {
            httpMessage.addParam("tid", bbVar.bqu);
            httpMessage.addParam("fid", bbVar.bqv);
            httpMessage.addParam("obj_to", bbVar.eVd);
            httpMessage.addParam("obj_id", bbVar.VP);
            httpMessage.addParam("obj_param3", bbVar.eVe);
            httpMessage.addParam(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bbVar.mSource);
            httpMessage.addParam("obj_locate", bbVar.mLocate);
            httpMessage.addParam("obj_param1", bbVar.eVf);
        }
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
