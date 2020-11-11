package com.baidu.tieba.pb.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes22.dex */
public class q {
    private TbPageContext eIc;

    public q(TbPageContext tbPageContext) {
        this.eIc = tbPageContext;
        SocketMessageTask socketMessageTask = new SocketMessageTask(309644);
        socketMessageTask.setResponsedClass(ThreadPublishSocketResMessage.class);
        MessageManager.getInstance().registerTask(socketMessageTask);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, com.baidu.tieba.tbadkCore.a.a.bL(TbConfig.URL_THREAD_PUBLISH, 309644));
        tbHttpMessageTask.setResponsedClass(ThreadPublishHttpResMeesage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void G(long j, long j2) {
        ThreadPublishReqMessage threadPublishReqMessage = new ThreadPublishReqMessage();
        threadPublishReqMessage.tid = j;
        threadPublishReqMessage.fid = j2;
        threadPublishReqMessage.setTag(this.eIc.getUniqueId());
        MessageManager.getInstance().sendMessage(threadPublishReqMessage);
    }
}
