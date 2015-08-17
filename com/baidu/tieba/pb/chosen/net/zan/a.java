package com.baidu.tieba.pb.chosen.net.zan;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
/* loaded from: classes.dex */
public class a {
    public a() {
        acA();
        acz();
    }

    private void acA() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, com.baidu.tieba.tbadkCore.a.a.Z(TbConfig.FINE_PB_PRAISE, 307005));
        tbHttpMessageTask.setResponsedClass(ChosenPbZanHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void acz() {
        b bVar = new b(307005);
        bVar.setResponsedClass(ChosenPbZanSocketResponse.class);
        bVar.i(true);
        bVar.j(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void a(PbChosenActivity pbChosenActivity, long j, String str) {
        ChosenZanNetMessage chosenZanNetMessage = new ChosenZanNetMessage();
        chosenZanNetMessage.setFtid(j);
        chosenZanNetMessage.setAction(str);
        pbChosenActivity.sendMessage(chosenZanNetMessage);
    }
}
