package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class bh implements AdapterView.OnItemClickListener {
    final /* synthetic */ bc bSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bc bcVar) {
        this.bSZ = bcVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        PersonFriendActivity aey;
        bkVar = this.bSZ.bSS;
        if (bkVar != null) {
            bkVar2 = this.bSZ.bSS;
            if (bkVar2.getItemViewType(i) == 0) {
                bkVar3 = this.bSZ.bSS;
                UserData userData = (UserData) bkVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    bc bcVar = this.bSZ;
                    aey = this.bSZ.aey();
                    bcVar.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(aey.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
