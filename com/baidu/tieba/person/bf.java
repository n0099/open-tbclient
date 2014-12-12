package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonListActivity personListActivity) {
        this.bGG = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        bkVar = this.bGG.bGB;
        if (bkVar != null) {
            bkVar2 = this.bGG.bGB;
            if (bkVar2.getItemViewType(intValue) == 0) {
                bkVar3 = this.bGG.bGB;
                UserData userData = (UserData) bkVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bGG.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                }
            }
        }
    }
}
