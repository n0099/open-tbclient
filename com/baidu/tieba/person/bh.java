package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonListActivity personListActivity) {
        this.bGG = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            bkVar = this.bGG.bGB;
            if (bkVar != null) {
                bkVar2 = this.bGG.bGB;
                if (bkVar2.getItemViewType(this.bGG.bGg) == 0) {
                    bkVar3 = this.bGG.bGB;
                    UserData userData = (UserData) bkVar3.getItem(intValue);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.bGG.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FOCUS_RECOM)));
                }
            }
        }
    }
}
