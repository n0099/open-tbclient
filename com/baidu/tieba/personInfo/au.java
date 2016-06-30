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
class au implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ at epy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.epy = atVar;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        f fVar;
        BaseFragmentActivity baseFragmentActivity;
        f fVar2;
        bp bpVar;
        f fVar3;
        BaseFragmentActivity baseFragmentActivity2;
        f fVar4;
        bp bpVar2;
        f fVar5;
        BaseFragmentActivity baseFragmentActivity3;
        f fVar6;
        if (bdUniqueId == com.baidu.tieba.person.data.g.ehV) {
            fVar3 = this.epy.this$0;
            baseFragmentActivity2 = fVar3.aMU;
            if (com.baidu.tbadk.core.util.bn.ab(baseFragmentActivity2.getPageContext().getPageActivity())) {
                fVar4 = this.epy.this$0;
                bpVar2 = fVar4.eht;
                UserData userData = bpVar2.getUserData();
                if (userData != null) {
                    int like_bars = userData.getLike_bars();
                    fVar5 = this.epy.this$0;
                    baseFragmentActivity3 = fVar5.aMU;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(baseFragmentActivity3.getPageContext().getPageActivity(), like_bars, userData.getUserId(), userData.getSex()));
                    fVar6 = this.epy.this$0;
                    fVar6.sendMessage(customMessage);
                }
            }
        } else if (bdUniqueId == com.baidu.tieba.person.data.k.Op && (vVar instanceof com.baidu.tieba.person.data.k)) {
            long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            fVar = this.epy.this$0;
            baseFragmentActivity = fVar.aMU;
            Activity pageActivity = baseFragmentActivity.getPageContext().getPageActivity();
            int i2 = ((com.baidu.tieba.person.data.k) vVar).eic;
            fVar2 = this.epy.this$0;
            bpVar = fVar2.eht;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodThreadListActivityConfig(pageActivity, c, i2, bpVar.getAuthor())));
        }
    }
}
