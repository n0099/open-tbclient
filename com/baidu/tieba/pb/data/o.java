package com.baidu.tieba.pb.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes9.dex */
public class o {
    private TbPageContext dPv;

    public o(TbPageContext tbPageContext) {
        this.dPv = tbPageContext;
        SocketMessageTask socketMessageTask = new SocketMessageTask(309644);
        socketMessageTask.setResponsedClass(ThreadPublishSocketResMessage.class);
        MessageManager.getInstance().registerTask(socketMessageTask);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, com.baidu.tieba.tbadkCore.a.a.bE(TbConfig.URL_THREAD_PUBLISH, 309644));
        tbHttpMessageTask.setResponsedClass(ThreadPublishHttpResMeesage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void G(long j, long j2) {
        ThreadPublishReqMessage threadPublishReqMessage = new ThreadPublishReqMessage();
        threadPublishReqMessage.tid = j;
        threadPublishReqMessage.fid = j2;
        threadPublishReqMessage.setTag(this.dPv.getUniqueId());
        MessageManager.getInstance().sendMessage(threadPublishReqMessage);
    }
}
