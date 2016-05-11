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
class ar implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ aq dGs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.dGs = aqVar;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        f fVar;
        BaseFragmentActivity baseFragmentActivity;
        f fVar2;
        bg bgVar;
        f fVar3;
        BaseFragmentActivity baseFragmentActivity2;
        f fVar4;
        bg bgVar2;
        f fVar5;
        BaseFragmentActivity baseFragmentActivity3;
        f fVar6;
        if (bdUniqueId == com.baidu.tieba.person.data.g.dzr) {
            fVar3 = this.dGs.this$0;
            baseFragmentActivity2 = fVar3.aJw;
            if (com.baidu.tbadk.core.util.bl.ac(baseFragmentActivity2.getPageContext().getPageActivity())) {
                fVar4 = this.dGs.this$0;
                bgVar2 = fVar4.dyP;
                UserData userData = bgVar2.getUserData();
                if (userData != null) {
                    int like_bars = userData.getLike_bars();
                    fVar5 = this.dGs.this$0;
                    baseFragmentActivity3 = fVar5.aJw;
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(baseFragmentActivity3.getPageContext().getPageActivity(), like_bars, userData.getUserId(), userData.getSex()));
                    fVar6 = this.dGs.this$0;
                    fVar6.sendMessage(customMessage);
                }
            }
        } else if (bdUniqueId == com.baidu.tieba.person.data.k.Oq && (vVar instanceof com.baidu.tieba.person.data.k)) {
            long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            fVar = this.dGs.this$0;
            baseFragmentActivity = fVar.aJw;
            Activity pageActivity = baseFragmentActivity.getPageContext().getPageActivity();
            int i2 = ((com.baidu.tieba.person.data.k) vVar).dzy;
            fVar2 = this.dGs.this$0;
            bgVar = fVar2.dyP;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodThreadListActivityConfig(pageActivity, c, i2, bgVar.getAuthor())));
        }
    }
}
