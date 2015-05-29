package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bTu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(PersonListActivity personListActivity) {
        this.bTu = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ca caVar;
        ca caVar2;
        ca caVar3;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            caVar = this.bTu.bTp;
            if (caVar != null) {
                caVar2 = this.bTu.bTp;
                if (caVar2.getItemViewType(this.bTu.bST) == 0) {
                    caVar3 = this.bTu.bTp;
                    UserData userData = (UserData) caVar3.getItem(intValue);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.bTu.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FOCUS_RECOM)));
                }
            }
        }
    }
}
