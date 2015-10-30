package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bb implements AdapterView.OnItemClickListener {
    final /* synthetic */ aw cqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(aw awVar) {
        this.cqq = awVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        be beVar;
        be beVar2;
        be beVar3;
        PersonFriendActivity aiC;
        beVar = this.cqq.cqi;
        if (beVar != null) {
            beVar2 = this.cqq.cqi;
            if (beVar2.getItemViewType(i) == 0) {
                beVar3 = this.cqq.cqi;
                UserData userData = (UserData) beVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    aw awVar = this.cqq;
                    aiC = this.cqq.aiC();
                    awVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aiC.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
