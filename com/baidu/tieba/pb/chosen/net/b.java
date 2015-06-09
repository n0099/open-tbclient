package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
/* loaded from: classes.dex */
public class b {
    public b() {
        aal();
        aam();
    }

    private void aal() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(307003);
        bVar.setResponsedClass(ChosenPbSocketResponse.class);
        bVar.i(true);
        bVar.j(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void aam() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FINE_PB, com.baidu.tieba.tbadkCore.a.a.S(TbConfig.FINE_PB_PAGE, 307003));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(PbChosenActivity pbChosenActivity, long j) {
        ChosenPbNetMessage chosenPbNetMessage = new ChosenPbNetMessage();
        int M = n.M(pbChosenActivity.getPageContext().getPageActivity());
        int N = n.N(pbChosenActivity.getPageContext().getPageActivity());
        chosenPbNetMessage.setQ_type(45L);
        chosenPbNetMessage.setScrH(N);
        chosenPbNetMessage.setScrW(M);
        chosenPbNetMessage.setScr_dip(M / 320.0f);
        chosenPbNetMessage.setTid(j);
        pbChosenActivity.sendMessage(chosenPbNetMessage);
    }
}
