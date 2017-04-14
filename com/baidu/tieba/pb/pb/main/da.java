package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class da {
    public long Vf;
    public long ekW;
    public long ekX;
    public int ekY;
    public long mForumId;

    public da() {
        EC();
    }

    public void aLj() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_SET_DECLARE);
        httpMessage.addParam("tid", this.Vf);
        httpMessage.addParam("author_uid", this.ekW);
        httpMessage.addParam("declare_id", this.ekX);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("operation", this.ekY);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void EC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_SET_DECLARE, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PB_SET_DECLARE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
