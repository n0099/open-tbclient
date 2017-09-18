package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class n {
    public long Vf;
    public long eLv;
    public long eLw;
    public int eLx;
    public long mForumId;

    public n() {
        El();
    }

    public void aRs() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_SET_DECLARE);
        httpMessage.addParam("tid", this.Vf);
        httpMessage.addParam("author_uid", this.eLv);
        httpMessage.addParam("declare_id", this.eLw);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("operation", this.eLx);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void El() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_SET_DECLARE, TbConfig.SERVER_ADDRESS + TbConfig.PB_SET_DECLARE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
