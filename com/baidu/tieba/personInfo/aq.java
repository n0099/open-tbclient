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
    final /* synthetic */ ap dDj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.dDj = apVar;
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
        if (bdUniqueId == com.baidu.tieba.person.data.f.dwn) {
            fVar3 = this.dDj.this$0;
            baseFragmentActivity2 = fVar3.aNm;
            if (com.baidu.tbadk.core.util.bl.ad(baseFragmentActivity2.getPageContext().getPageActivity())) {
                fVar4 = this.dDj.this$0;
                bfVar2 = fVar4.dvN;
                UserData userData = bfVar2.getUserData();
                if (userData != null) {
                    int like_bars = userData.getLike_bars();
                    fVar5 = this.dDj.this$0;
                    baseFragmentActivity3 = fVar5.aNm;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(baseFragmentActivity3.getPageContext().getPageActivity(), like_bars, userData.getUserId(), userData.getSex()));
                    fVar6 = this.dDj.this$0;
                    fVar6.sendMessage(customMessage);
                }
            }
        } else if (bdUniqueId == com.baidu.tieba.person.data.j.TC && (uVar instanceof com.baidu.tieba.person.data.j)) {
            long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            fVar = this.dDj.this$0;
            baseFragmentActivity = fVar.aNm;
            Activity pageActivity = baseFragmentActivity.getPageContext().getPageActivity();
            int i2 = ((com.baidu.tieba.person.data.j) uVar).dwu;
            fVar2 = this.dDj.this$0;
            bfVar = fVar2.dvN;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodThreadListActivityConfig(pageActivity, c, i2, bfVar.getAuthor())));
        }
    }
}
