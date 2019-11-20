package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
/* loaded from: classes5.dex */
public class b {
    public b() {
        bQl();
        bQm();
    }

    private void bQl() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_GET_FINE_PB);
        bVar.setResponsedClass(ChosenPbSocketResponse.class);
        bVar.setNeedAck(true);
        bVar.setNeedCompress(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void bQm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003006, com.baidu.tieba.tbadkCore.a.a.bl(TbConfig.FINE_PB_PAGE, CmdConfigSocket.CMD_GET_FINE_PB));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(PbChosenActivity pbChosenActivity, long j, long j2, long j3) {
        ChosenPbNetMessage chosenPbNetMessage = new ChosenPbNetMessage();
        int equipmentWidth = l.getEquipmentWidth(pbChosenActivity.getPageContext().getPageActivity());
        int equipmentHeight = l.getEquipmentHeight(pbChosenActivity.getPageContext().getPageActivity());
        float equipmentDensity = l.getEquipmentDensity(pbChosenActivity.getPageContext().getPageActivity());
        chosenPbNetMessage.setQ_type(45L);
        chosenPbNetMessage.setScrH(equipmentHeight);
        chosenPbNetMessage.setScrW(equipmentWidth);
        chosenPbNetMessage.setScr_dip(equipmentDensity);
        chosenPbNetMessage.setExcId(j);
        chosenPbNetMessage.setTagCode(j2);
        chosenPbNetMessage.setThreadId(j3);
        pbChosenActivity.sendMessage(chosenPbNetMessage);
    }
}
