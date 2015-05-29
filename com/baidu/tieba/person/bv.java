package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bTu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(PersonListActivity personListActivity) {
        this.bTu = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ca caVar;
        ca caVar2;
        ca caVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        caVar = this.bTu.bTp;
        if (caVar != null) {
            caVar2 = this.bTu.bTp;
            if (caVar2.getItemViewType(intValue) == 0) {
                caVar3 = this.bTu.bTp;
                UserData userData = (UserData) caVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bTu.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                }
            }
        }
    }
}
