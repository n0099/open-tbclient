package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bb implements AdapterView.OnItemClickListener {
    final /* synthetic */ aw cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(aw awVar) {
        this.cqf = awVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        be beVar;
        be beVar2;
        be beVar3;
        PersonFriendActivity aiG;
        beVar = this.cqf.cpX;
        if (beVar != null) {
            beVar2 = this.cqf.cpX;
            if (beVar2.getItemViewType(i) == 0) {
                beVar3 = this.cqf.cpX;
                UserData userData = (UserData) beVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    aw awVar = this.cqf;
                    aiG = this.cqf.aiG();
                    awVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aiG.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
