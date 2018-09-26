package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
/* loaded from: classes3.dex */
public class b {
    public b() {
        bbw();
        bbx();
    }

    private void bbw() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309093);
        bVar.setResponsedClass(ChosenPbSocketResponse.class);
        bVar.x(true);
        bVar.y(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void bbx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FINE_PB, com.baidu.tieba.tbadkCore.a.a.aP(TbConfig.FINE_PB_PAGE, 309093));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(PbChosenActivity pbChosenActivity, long j, long j2, long j3) {
        ChosenPbNetMessage chosenPbNetMessage = new ChosenPbNetMessage();
        int aO = l.aO(pbChosenActivity.getPageContext().getPageActivity());
        int aQ = l.aQ(pbChosenActivity.getPageContext().getPageActivity());
        float aR = l.aR(pbChosenActivity.getPageContext().getPageActivity());
        chosenPbNetMessage.setQ_type(45L);
        chosenPbNetMessage.setScrH(aQ);
        chosenPbNetMessage.setScrW(aO);
        chosenPbNetMessage.setScr_dip(aR);
        chosenPbNetMessage.setExcId(j);
        chosenPbNetMessage.setTagCode(j2);
        chosenPbNetMessage.setThreadId(j3);
        pbChosenActivity.sendMessage(chosenPbNetMessage);
    }
}
