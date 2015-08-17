package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ba implements AdapterView.OnItemClickListener {
    final /* synthetic */ av cjG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(av avVar) {
        this.cjG = avVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        PersonFriendActivity agq;
        bdVar = this.cjG.cjy;
        if (bdVar != null) {
            bdVar2 = this.cjG.cjy;
            if (bdVar2.getItemViewType(i) == 0) {
                bdVar3 = this.cjG.cjy;
                UserData userData = (UserData) bdVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    av avVar = this.cjG;
                    agq = this.cjG.agq();
                    avVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(agq.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
