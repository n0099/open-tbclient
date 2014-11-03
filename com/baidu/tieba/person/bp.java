package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ PersonListActivity bDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonListActivity personListActivity) {
        this.bDh = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            bsVar = this.bDh.bDc;
            if (bsVar != null) {
                bsVar2 = this.bDh.bDc;
                if (bsVar2.getItemViewType(this.bDh.bCG) == 0) {
                    bsVar3 = this.bDh.bDc;
                    UserData userData = (UserData) bsVar3.getItem(intValue);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.bDh, userData.getUserId(), userData.getName_show(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FOCUS_RECOM)));
                }
            }
        }
    }
}
