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
class as implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ ar eBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.eBk = arVar;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        h hVar;
        BaseFragmentActivity baseFragmentActivity;
        h hVar2;
        bn bnVar;
        h hVar3;
        BaseFragmentActivity baseFragmentActivity2;
        h hVar4;
        bn bnVar2;
        h hVar5;
        BaseFragmentActivity baseFragmentActivity3;
        h hVar6;
        if (bdUniqueId == com.baidu.tieba.person.data.h.esb) {
            hVar3 = this.eBk.this$0;
            baseFragmentActivity2 = hVar3.aNO;
            if (com.baidu.tbadk.core.util.bn.ab(baseFragmentActivity2.getPageContext().getPageActivity())) {
                hVar4 = this.eBk.this$0;
                bnVar2 = hVar4.ers;
                UserData userData = bnVar2.getUserData();
                if (userData != null) {
                    int like_bars = userData.getLike_bars();
                    hVar5 = this.eBk.this$0;
                    baseFragmentActivity3 = hVar5.aNO;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(baseFragmentActivity3.getPageContext().getPageActivity(), like_bars, userData.getUserId(), userData.getSex()));
                    hVar6 = this.eBk.this$0;
                    hVar6.sendMessage(customMessage);
                }
            }
        } else if (bdUniqueId == com.baidu.tieba.person.data.j.OB && (vVar instanceof com.baidu.tieba.person.data.j)) {
            long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            hVar = this.eBk.this$0;
            baseFragmentActivity = hVar.aNO;
            Activity pageActivity = baseFragmentActivity.getPageContext().getPageActivity();
            int i2 = ((com.baidu.tieba.person.data.j) vVar).esg;
            hVar2 = this.eBk.this$0;
            bnVar = hVar2.ers;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodThreadListActivityConfig(pageActivity, c, i2, bnVar.getAuthor())));
        }
    }
}
