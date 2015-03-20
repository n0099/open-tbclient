package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PersonListActivity personListActivity) {
        this.bQz = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            bhVar = this.bQz.bQu;
            if (bhVar != null) {
                bhVar2 = this.bQz.bQu;
                if (bhVar2.getItemViewType(this.bQz.bPY) == 0) {
                    bhVar3 = this.bQz.bQu;
                    UserData userData = (UserData) bhVar3.getItem(intValue);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.bQz.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FOCUS_RECOM)));
                }
            }
        }
    }
}
