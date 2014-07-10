package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class cg implements AdapterView.OnItemClickListener {
    final /* synthetic */ cb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cb cbVar) {
        this.a = cbVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        PersonFriendActivity f;
        cjVar = this.a.d;
        if (cjVar != null) {
            cjVar2 = this.a.d;
            if (cjVar2.getItemViewType(i) == 0) {
                cjVar3 = this.a.d;
                UserData userData = (UserData) cjVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    cb cbVar = this.a;
                    f = this.a.f();
                    cbVar.a(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bb(f, userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
