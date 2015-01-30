package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PersonListActivity personListActivity) {
        this.bIs = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        bjVar = this.bIs.bIn;
        if (bjVar != null) {
            bjVar2 = this.bIs.bIn;
            if (bjVar2.getItemViewType(intValue) == 0) {
                bjVar3 = this.bIs.bIn;
                UserData userData = (UserData) bjVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bIs.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                }
            }
        }
    }
}
