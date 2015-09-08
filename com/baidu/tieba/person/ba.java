package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ba implements AdapterView.OnItemClickListener {
    final /* synthetic */ av ckB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(av avVar) {
        this.ckB = avVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        PersonFriendActivity agG;
        bdVar = this.ckB.ckt;
        if (bdVar != null) {
            bdVar2 = this.ckB.ckt;
            if (bdVar2.getItemViewType(i) == 0) {
                bdVar3 = this.ckB.ckt;
                UserData userData = (UserData) bdVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    av avVar = this.ckB;
                    agG = this.ckB.agG();
                    avVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(agG.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
