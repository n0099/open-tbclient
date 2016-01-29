package com.baidu.tieba.personInfo;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.person.god.GodThreadListActivityConfig;
/* loaded from: classes.dex */
class aq implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ ap diJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.diJ = apVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        f fVar;
        BaseFragmentActivity baseFragmentActivity;
        f fVar2;
        bf bfVar;
        f fVar3;
        BaseFragmentActivity baseFragmentActivity2;
        f fVar4;
        bf bfVar2;
        f fVar5;
        BaseFragmentActivity baseFragmentActivity3;
        f fVar6;
        if (bdUniqueId == com.baidu.tieba.person.data.f.dbK) {
            fVar3 = this.diJ.diG;
            baseFragmentActivity2 = fVar3.aKq;
            if (com.baidu.tbadk.core.util.bi.ah(baseFragmentActivity2.getPageContext().getPageActivity())) {
                fVar4 = this.diJ.diG;
                bfVar2 = fVar4.dbl;
                UserData userData = bfVar2.getUserData();
                if (userData != null) {
                    int like_bars = userData.getLike_bars();
                    fVar5 = this.diJ.diG;
                    baseFragmentActivity3 = fVar5.aKq;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(baseFragmentActivity3.getPageContext().getPageActivity(), like_bars, userData.getUserId(), userData.getSex()));
                    fVar6 = this.diJ.diG;
                    fVar6.sendMessage(customMessage);
                }
            }
        } else if (bdUniqueId == com.baidu.tieba.person.data.j.aRS && (uVar instanceof com.baidu.tieba.person.data.j)) {
            long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            fVar = this.diJ.diG;
            baseFragmentActivity = fVar.aKq;
            Activity pageActivity = baseFragmentActivity.getPageContext().getPageActivity();
            int i2 = ((com.baidu.tieba.person.data.j) uVar).dbR;
            fVar2 = this.diJ.diG;
            bfVar = fVar2.dbl;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodThreadListActivityConfig(pageActivity, c, i2, bfVar.getAuthor())));
        }
    }
}
