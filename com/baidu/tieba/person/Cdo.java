package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.person.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dr drVar;
        dr drVar2;
        dr drVar3;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            drVar = this.a.h;
            if (drVar != null) {
                drVar2 = this.a.h;
                if (drVar2.getItemViewType(this.a.a) == 0) {
                    drVar3 = this.a.h;
                    UserData userData = (UserData) drVar3.getItem(intValue);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.a(this.a, userData.getUserId(), userData.getName_show(), userData.getPortrait(), null, false, "focus_recom")));
                }
            }
        }
    }
}
