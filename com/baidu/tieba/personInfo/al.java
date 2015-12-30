package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class al implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ ak cWY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.cWY = akVar;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        d dVar;
        BaseFragmentActivity baseFragmentActivity;
        d dVar2;
        bb bbVar;
        d dVar3;
        BaseFragmentActivity baseFragmentActivity2;
        d dVar4;
        dVar = this.cWY.cWV;
        baseFragmentActivity = dVar.aJl;
        if (com.baidu.tbadk.core.util.bj.ah(baseFragmentActivity.getPageContext().getPageActivity())) {
            dVar2 = this.cWY.cWV;
            bbVar = dVar2.cRx;
            UserData userData = bbVar.getUserData();
            if (bdUniqueId == com.baidu.tieba.person.data.f.cRW && userData != null) {
                int like_bars = userData.getLike_bars();
                dVar3 = this.cWY.cWV;
                baseFragmentActivity2 = dVar3.aJl;
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(baseFragmentActivity2.getPageContext().getPageActivity(), like_bars, userData.getUserId(), userData.getSex()));
                dVar4 = this.cWY.cWV;
                dVar4.sendMessage(customMessage);
            }
        }
    }
}
