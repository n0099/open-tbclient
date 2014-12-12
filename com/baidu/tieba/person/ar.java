package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ar implements AdapterView.OnItemClickListener {
    final /* synthetic */ am bGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(am amVar) {
        this.bGm = amVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        au auVar;
        au auVar2;
        au auVar3;
        PersonFriendActivity aas;
        auVar = this.bGm.bGf;
        if (auVar != null) {
            auVar2 = this.bGm.bGf;
            if (auVar2.getItemViewType(i) == 0) {
                auVar3 = this.bGm.bGf;
                UserData userData = (UserData) auVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    am amVar = this.bGm;
                    aas = this.bGm.aas();
                    amVar.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(aas.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
