package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
/* loaded from: classes.dex */
public class b {
    public b() {
        acz();
        acA();
    }

    private void acz() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(307003);
        bVar.setResponsedClass(ChosenPbSocketResponse.class);
        bVar.i(true);
        bVar.j(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void acA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FINE_PB, com.baidu.tieba.tbadkCore.a.a.Z(TbConfig.FINE_PB_PAGE, 307003));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(PbChosenActivity pbChosenActivity, long j) {
        ChosenPbNetMessage chosenPbNetMessage = new ChosenPbNetMessage();
        int K = k.K(pbChosenActivity.getPageContext().getPageActivity());
        int L = k.L(pbChosenActivity.getPageContext().getPageActivity());
        chosenPbNetMessage.setQ_type(45L);
        chosenPbNetMessage.setScrH(L);
        chosenPbNetMessage.setScrW(K);
        chosenPbNetMessage.setScr_dip(K / 320.0f);
        chosenPbNetMessage.setTid(j);
        pbChosenActivity.sendMessage(chosenPbNetMessage);
    }
}
