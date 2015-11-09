package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bb implements AdapterView.OnItemClickListener {
    final /* synthetic */ aw crM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(aw awVar) {
        this.crM = awVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        be beVar;
        be beVar2;
        be beVar3;
        PersonFriendActivity aji;
        beVar = this.crM.crE;
        if (beVar != null) {
            beVar2 = this.crM.crE;
            if (beVar2.getItemViewType(i) == 0) {
                beVar3 = this.crM.crE;
                UserData userData = (UserData) beVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    aw awVar = this.crM;
                    aji = this.crM.aji();
                    awVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aji.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
