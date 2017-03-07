package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class dc {
    public long UL;
    public long emO;
    public long emP;
    public int emQ;
    public long mForumId;

    public dc() {
        Ee();
    }

    public void aLb() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_SET_DECLARE);
        httpMessage.addParam("tid", this.UL);
        httpMessage.addParam("author_uid", this.emO);
        httpMessage.addParam("declare_id", this.emP);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("operation", this.emQ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void Ee() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_SET_DECLARE, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PB_SET_DECLARE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
