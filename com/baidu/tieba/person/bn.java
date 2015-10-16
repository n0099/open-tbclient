package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements View.OnClickListener {
    final /* synthetic */ PersonListActivity cqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PersonListActivity personListActivity) {
        this.cqN = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        bsVar = this.cqN.cqI;
        if (bsVar != null) {
            bsVar2 = this.cqN.cqI;
            if (bsVar2.getItemViewType(intValue) == 0) {
                bsVar3 = this.cqN.cqI;
                UserData userData = (UserData) bsVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cqN.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                }
            }
        }
    }
}
