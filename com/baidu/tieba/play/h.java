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
        dwu();
        dwv();
    }

    private static void dwu() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001804, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private static void dwv() {
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
        if (TbSingleton.getInstance().getPcdnConfigData() != null && TbSingleton.getInstance().getPcdnConfigData().dwJ()) {
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
            httpMessage.addParam("video_md5", oVar.mkp);
        }
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam(TiebaInitialize.Params.OBJ_PARAM2, str2);
        a(httpMessage, oVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void a(HttpMessage httpMessage, o oVar) {
        if (httpMessage != null && oVar != null) {
            httpMessage.addParam("tid", oVar.alZ);
            httpMessage.addParam("fid", oVar.fyg);
            httpMessage.addParam(TiebaInitialize.Params.OBJ_TO, oVar.mkk);
            httpMessage.addParam("obj_id", oVar.ezo);
            httpMessage.addParam(TiebaInitialize.Params.OBJ_PARAM3, oVar.mkl);
            httpMessage.addParam("obj_source", oVar.mSource);
            httpMessage.addParam("obj_locate", oVar.mLocate);
            httpMessage.addParam("obj_param1", oVar.mkm);
            if (!StringUtils.isNull(oVar.mkq)) {
                httpMessage.addParam("topic_type", oVar.mkq);
            }
            if (!StringUtils.isNull(oVar.mkr)) {
                httpMessage.addParam("is_vertical", oVar.mkr);
            }
        }
    }
}
