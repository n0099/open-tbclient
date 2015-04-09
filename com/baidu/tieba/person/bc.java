package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PersonListActivity personListActivity) {
        this.bQP = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        bhVar = this.bQP.bQK;
        if (bhVar != null) {
            bhVar2 = this.bQP.bQK;
            if (bhVar2.getItemViewType(intValue) == 0) {
                bhVar3 = this.bQP.bQK;
                UserData userData = (UserData) bhVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bQP.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                }
            }
        }
    }
}
