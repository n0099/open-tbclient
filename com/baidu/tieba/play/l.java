package com.baidu.tieba.play;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class l {
    static {
        cQC();
        cQD();
    }

    private static void cQC() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001804, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private static void cQD() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003359, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_DURATION_STATISTICS);
        tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void a(String str, String str2, String str3, y yVar) {
        HttpMessage httpMessage = new HttpMessage(1001804);
        httpMessage.addParam("video_md5", str);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam(TiebaInitialize.Params.OBJ_PARAM2, str2);
        httpMessage.addParam("obj_type", str3);
        a(httpMessage, yVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(long j, String str, y yVar, String str2, long j2) {
        HttpMessage httpMessage = new HttpMessage(1003359);
        httpMessage.addParam("obj_duration", j);
        httpMessage.addParam("obj_type", str);
        httpMessage.addParam("playduration", j2);
        if (yVar != null) {
            httpMessage.addParam("video_md5", yVar.kAq);
        }
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam(TiebaInitialize.Params.OBJ_PARAM2, str2);
        a(httpMessage, yVar);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void a(HttpMessage httpMessage, y yVar) {
        if (httpMessage != null && yVar != null) {
            httpMessage.addParam("tid", yVar.ais);
            httpMessage.addParam("fid", yVar.evm);
            httpMessage.addParam(TiebaInitialize.Params.OBJ_TO, yVar.kAl);
            httpMessage.addParam("obj_id", yVar.dCp);
            httpMessage.addParam(TiebaInitialize.Params.OBJ_PARAM3, yVar.kAm);
            httpMessage.addParam("obj_source", yVar.mSource);
            httpMessage.addParam("obj_locate", yVar.mLocate);
            httpMessage.addParam("obj_param1", yVar.kAn);
            if (!StringUtils.isNull(yVar.kAr)) {
                httpMessage.addParam("topic_type", yVar.kAr);
            }
            if (!StringUtils.isNull(yVar.kAs)) {
                httpMessage.addParam("is_vertical", yVar.kAs);
            }
        }
    }
}
