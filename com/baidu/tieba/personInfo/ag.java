package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bj;
/* loaded from: classes.dex */
class ag implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ af cSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.cSq = afVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        d dVar;
        BaseFragmentActivity baseFragmentActivity;
        d dVar2;
        aw awVar;
        d dVar3;
        BaseFragmentActivity baseFragmentActivity2;
        d dVar4;
        dVar = this.cSq.cSn;
        baseFragmentActivity = dVar.aHN;
        if (bj.ah(baseFragmentActivity.getPageContext().getPageActivity())) {
            dVar2 = this.cSq.cSn;
            awVar = dVar2.cMT;
            UserData userData = awVar.getUserData();
            if (bdUniqueId == com.baidu.tieba.person.data.f.cNs && userData != null) {
                int like_bars = userData.getLike_bars();
                dVar3 = this.cSq.cSn;
                baseFragmentActivity2 = dVar3.aHN;
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(baseFragmentActivity2.getPageContext().getPageActivity(), like_bars, userData.getUserId(), userData.getSex()));
                dVar4 = this.cSq.cSn;
                dVar4.sendMessage(customMessage);
            }
        }
    }
}
