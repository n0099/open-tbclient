package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class aq implements AdapterView.OnItemClickListener {
    final /* synthetic */ al bHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(al alVar) {
        this.bHW = alVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        at atVar;
        at atVar2;
        at atVar3;
        PersonFriendActivity aaS;
        atVar = this.bHW.bHP;
        if (atVar != null) {
            atVar2 = this.bHW.bHP;
            if (atVar2.getItemViewType(i) == 0) {
                atVar3 = this.bHW.bHP;
                UserData userData = (UserData) atVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    al alVar = this.bHW;
                    aaS = this.bHW.aaS();
                    alVar.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(aaS.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
