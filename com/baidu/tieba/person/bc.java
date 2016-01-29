package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bc implements AdapterView.OnItemClickListener {
    final /* synthetic */ ax cYT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ax axVar) {
        this.cYT = axVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        PersonFriendActivity atP;
        bfVar = this.cYT.cYL;
        if (bfVar != null) {
            bfVar2 = this.cYT.cYL;
            if (bfVar2.getItemViewType(i) == 0) {
                bfVar3 = this.cYT.cYL;
                UserData userData = (UserData) bfVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    ax axVar = this.cYT;
                    atP = this.cYT.atP();
                    axVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(atP.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
