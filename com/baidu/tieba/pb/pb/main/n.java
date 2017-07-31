package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class n {
    public long VZ;
    public long eKo;
    public long eKp;
    public int eKq;
    public long mForumId;

    public n() {
        Eo();
    }

    public void aRo() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_SET_DECLARE);
        httpMessage.addParam("tid", this.VZ);
        httpMessage.addParam("author_uid", this.eKo);
        httpMessage.addParam("declare_id", this.eKp);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("operation", this.eKq);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void Eo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_SET_DECLARE, TbConfig.SERVER_ADDRESS + TbConfig.PB_SET_DECLARE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
