package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class aq implements AdapterView.OnItemClickListener {
    final /* synthetic */ al bHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(al alVar) {
        this.bHX = alVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        at atVar;
        at atVar2;
        at atVar3;
        PersonFriendActivity aaX;
        atVar = this.bHX.bHQ;
        if (atVar != null) {
            atVar2 = this.bHX.bHQ;
            if (atVar2.getItemViewType(i) == 0) {
                atVar3 = this.bHX.bHQ;
                UserData userData = (UserData) atVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    al alVar = this.bHX;
                    aaX = this.bHX.aaX();
                    alVar.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(aaX.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
