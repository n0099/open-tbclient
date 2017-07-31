package com.baidu.tieba.vote;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class VoteStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.c(309006, AddVoteSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_VOTE, com.baidu.tieba.tbadkCore.a.a.az(TbConfig.VOTE_ADD, 309006));
        tbHttpMessageTask.setResponsedClass(AddVoteHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
