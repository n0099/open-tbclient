package com.baidu.tieba.play;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class h {
    static {
        dBN();
        dBO();
    }

    private static void dBN() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001804, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private static void dBO() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003359, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_DURATION_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void a(String str, String str2, String str3, o oVar, int i) {
        HttpMessage httpMessage = new HttpMessage(1001804);
        httpMessage.addParam("video_md5", str);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam(TiebaInitialize.Params.OBJ_PARAM2, str2);
        httpMessage.addParam("obj_type", str3);
        if (TbSingleton.getInstance().getPcdnConfigData() != null && TbSingleton.getInstance().getPcdnConfigData().dCc()) {
            httpMessage.addParam("pcdn_state", i);
        }
        a(httpMessage, oVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(long j, String str, o oVar, String str2, long j2) {
        HttpMessage httpMessage = new HttpMessage(1003359);
        httpMessage.addParam("obj_duration", j);
        httpMessage.addParam("obj_type", str);
        httpMessage.addParam("playduration", j2);
        if (oVar != null) {
            httpMessage.addParam("video_md5", oVar.myv);
        }
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam(TiebaInitialize.Params.OBJ_PARAM2, str2);
        a(httpMessage, oVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void a(HttpMessage httpMessage, o oVar) {
        if (httpMessage != null && oVar != null) {
            httpMessage.addParam("tid", oVar.amY);
            httpMessage.addParam("fid", oVar.fFV);
            httpMessage.addParam(TiebaInitialize.Params.OBJ_TO, oVar.myq);
            httpMessage.addParam("obj_id", oVar.eGn);
            httpMessage.addParam(TiebaInitialize.Params.OBJ_PARAM3, oVar.myr);
            httpMessage.addParam("obj_source", oVar.mSource);
            httpMessage.addParam("obj_locate", oVar.mLocate);
            httpMessage.addParam("obj_param1", oVar.mys);
            if (!StringUtils.isNull(oVar.myw)) {
                httpMessage.addParam("topic_type", oVar.myw);
            }
            if (!StringUtils.isNull(oVar.myx)) {
                httpMessage.addParam("is_vertical", oVar.myx);
            }
        }
    }
}
