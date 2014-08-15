package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dr drVar;
        dr drVar2;
        dr drVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        drVar = this.a.h;
        if (drVar != null) {
            drVar2 = this.a.h;
            if (drVar2.getItemViewType(intValue) == 0) {
                drVar3 = this.a.h;
                UserData userData = (UserData) drVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(this.a, userData.getUserId(), userData.getName_show(), null, "focus")));
                }
            }
        }
    }
}
