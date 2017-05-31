package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class dq {
    public long Ul;
    public long eoL;
    public long eoM;
    public int eoN;
    public long mForumId;

    public dq() {
        DA();
    }

    public void aKD() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_SET_DECLARE);
        httpMessage.addParam("tid", this.Ul);
        httpMessage.addParam("author_uid", this.eoL);
        httpMessage.addParam("declare_id", this.eoM);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("operation", this.eoN);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void DA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_SET_DECLARE, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PB_SET_DECLARE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
