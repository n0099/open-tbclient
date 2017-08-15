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
public class k {
    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PLAY_STATISTICS_CMD, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void a(String str, String str2, String str3, w wVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
        httpMessage.addParam("video_md5", str);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("obj_param2", str2);
        httpMessage.addParam("obj_type", str3);
        if (wVar != null) {
            httpMessage.addParam("tid", wVar.bDM);
            httpMessage.addParam("fid", wVar.aAC);
            httpMessage.addParam("obj_to", wVar.fCq);
            httpMessage.addParam("obj_id", wVar.WK);
            httpMessage.addParam("obj_param3", wVar.fCr);
            httpMessage.addParam(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, wVar.mSource);
            httpMessage.addParam("obj_locate", wVar.mLocate);
            httpMessage.addParam("obj_param1", wVar.fCs);
        }
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
