package com.baidu.tieba.pb.chosen.net.zan;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
/* loaded from: classes3.dex */
public class a {
    public a() {
        bah();
        bag();
    }

    private void bah() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, com.baidu.tieba.tbadkCore.a.a.aJ(TbConfig.FINE_PB_PRAISE, 309095));
        tbHttpMessageTask.setResponsedClass(ChosenPbZanHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void bag() {
        b bVar = new b(309095);
        bVar.setResponsedClass(ChosenPbZanSocketResponse.class);
        bVar.V(true);
        bVar.W(false);
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
