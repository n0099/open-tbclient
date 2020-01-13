package com.baidu.tieba.pb.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes7.dex */
public class n {
    private TbPageContext cRe;

    public n(TbPageContext tbPageContext) {
        this.cRe = tbPageContext;
        SocketMessageTask socketMessageTask = new SocketMessageTask(309644);
        socketMessageTask.setResponsedClass(ThreadPublishSocketResMessage.class);
        MessageManager.getInstance().registerTask(socketMessageTask);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, com.baidu.tieba.tbadkCore.a.a.bv(TbConfig.URL_THREAD_PUBLISH, 309644));
        tbHttpMessageTask.setResponsedClass(ThreadPublishHttpResMeesage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void D(long j, long j2) {
        ThreadPublishReqMessage threadPublishReqMessage = new ThreadPublishReqMessage();
        threadPublishReqMessage.tid = j;
        threadPublishReqMessage.fid = j2;
        threadPublishReqMessage.setTag(this.cRe.getUniqueId());
        MessageManager.getInstance().sendMessage(threadPublishReqMessage);
    }
}
