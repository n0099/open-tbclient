package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class da {
    public long Vh;
    public long eno;
    public long enp;
    public int enq;
    public long mForumId;

    public da() {
        EC();
    }

    public void aMk() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_SET_DECLARE);
        httpMessage.addParam("tid", this.Vh);
        httpMessage.addParam("author_uid", this.eno);
        httpMessage.addParam("declare_id", this.enp);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("operation", this.enq);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void EC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_SET_DECLARE, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PB_SET_DECLARE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
