package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class dx {
    public long Uk;
    public long exR;
    public long exS;
    public int exT;
    public long mForumId;

    public dx() {
        DU();
    }

    public void aOA() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_SET_DECLARE);
        httpMessage.addParam("tid", this.Uk);
        httpMessage.addParam("author_uid", this.exR);
        httpMessage.addParam("declare_id", this.exS);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("operation", this.exT);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void DU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_SET_DECLARE, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PB_SET_DECLARE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
