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
    final /* synthetic */ PersonListActivity bTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(PersonListActivity personListActivity) {
        this.bTv = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ca caVar;
        ca caVar2;
        ca caVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        caVar = this.bTv.bTq;
        if (caVar != null) {
            caVar2 = this.bTv.bTq;
            if (caVar2.getItemViewType(intValue) == 0) {
                caVar3 = this.bTv.bTq;
                UserData userData = (UserData) caVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bTv.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                }
            }
        }
    }
}
