package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ci implements AdapterView.OnItemClickListener {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cd cdVar) {
        this.a = cdVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        cl clVar;
        cl clVar2;
        cl clVar3;
        PersonFriendActivity f;
        clVar = this.a.d;
        if (clVar != null) {
            clVar2 = this.a.d;
            if (clVar2.getItemViewType(i) == 0) {
                clVar3 = this.a.d;
                UserData userData = (UserData) clVar3.getItem(i);
                if (userData != null && userData.getUserId() != null) {
                    cd cdVar = this.a;
                    f = this.a.f();
                    cdVar.a(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(f, userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
