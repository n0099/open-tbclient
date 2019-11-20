package com.baidu.tieba.pb.chosen.net.zan;

import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
/* loaded from: classes5.dex */
public class a {
    public a() {
        bQm();
        bQl();
    }

    private void bQm() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003007, com.baidu.tieba.tbadkCore.a.a.bl(TbConfig.FINE_PB_PRAISE, CmdConfigSocket.CMD_CHOSEN_PB_PRAISE));
        tbHttpMessageTask.setResponsedClass(ChosenPbZanHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void bQl() {
        b bVar = new b(CmdConfigSocket.CMD_CHOSEN_PB_PRAISE);
        bVar.setResponsedClass(ChosenPbZanSocketResponse.class);
        bVar.setNeedAck(true);
        bVar.setNeedCompress(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void a(PbChosenActivity pbChosenActivity, long j, long j2, long j3, int i) {
        ChosenZanNetMessage chosenZanNetMessage = new ChosenZanNetMessage();
        chosenZanNetMessage.setExcId(j);
        chosenZanNetMessage.setAction(i);
        chosenZanNetMessage.setThreadId(j2);
        chosenZanNetMessage.setPostId(j3);
        pbChosenActivity.sendMessage(chosenZanNetMessage);
    }
}
