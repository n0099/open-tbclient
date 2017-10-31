package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class p {
    public long Vz;
    public long eNr;
    public long eNs;
    public int eNt;
    public long mForumId;

    public p() {
        DY();
    }

    public void aSp() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_SET_DECLARE);
        httpMessage.addParam("tid", this.Vz);
        httpMessage.addParam("author_uid", this.eNr);
        httpMessage.addParam("declare_id", this.eNs);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("operation", this.eNt);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void DY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_SET_DECLARE, TbConfig.SERVER_ADDRESS + TbConfig.PB_SET_DECLARE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
