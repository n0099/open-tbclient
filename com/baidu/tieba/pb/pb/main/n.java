package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class n {
    public long Wc;
    public long eMk;
    public long eMl;
    public int eMm;
    public long mForumId;

    public n() {
        Eo();
    }

    public void aRQ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_SET_DECLARE);
        httpMessage.addParam("tid", this.Wc);
        httpMessage.addParam("author_uid", this.eMk);
        httpMessage.addParam("declare_id", this.eMl);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("operation", this.eMm);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void Eo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_SET_DECLARE, TbConfig.SERVER_ADDRESS + TbConfig.PB_SET_DECLARE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
