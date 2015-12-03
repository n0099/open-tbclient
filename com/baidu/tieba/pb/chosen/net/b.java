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
        ajo();
        ajp();
    }

    private void ajo() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309093);
        bVar.setResponsedClass(ChosenPbSocketResponse.class);
        bVar.i(true);
        bVar.j(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void ajp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FINE_PB, com.baidu.tieba.tbadkCore.a.a.aj(TbConfig.FINE_PB_PAGE, 309093));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(PbChosenActivity pbChosenActivity, long j, long j2, long j3) {
        ChosenPbNetMessage chosenPbNetMessage = new ChosenPbNetMessage();
        int K = k.K(pbChosenActivity.getPageContext().getPageActivity());
        int L = k.L(pbChosenActivity.getPageContext().getPageActivity());
        float M = k.M(pbChosenActivity.getPageContext().getPageActivity());
        chosenPbNetMessage.setQ_type(45L);
        chosenPbNetMessage.setScrH(L);
        chosenPbNetMessage.setScrW(K);
        chosenPbNetMessage.setScr_dip(M);
        chosenPbNetMessage.setExcId(j);
        chosenPbNetMessage.setTagCode(j2);
        chosenPbNetMessage.setThreadId(j3);
        pbChosenActivity.sendMessage(chosenPbNetMessage);
    }
}
