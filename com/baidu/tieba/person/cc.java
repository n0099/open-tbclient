package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        ciVar = this.a.g;
        if (ciVar != null) {
            ciVar2 = this.a.g;
            if (ciVar2.getItemViewType(intValue) == 0) {
                ciVar3 = this.a.g;
                UserData userData = (UserData) ciVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new com.baidu.tbadk.core.atomData.at(this.a, userData.getUserId(), userData.getName_show())));
                }
            }
        }
    }
}
