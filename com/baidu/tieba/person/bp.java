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
public class bp implements View.OnClickListener {
    final /* synthetic */ PersonListActivity dtT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonListActivity personListActivity) {
        this.dtT = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        buVar = this.dtT.dtO;
        if (buVar != null) {
            buVar2 = this.dtT.dtO;
            if (buVar2.getItemViewType(intValue) == 0) {
                buVar3 = this.dtT.dtO;
                UserData userData = (UserData) buVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.dtT.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                }
            }
        }
    }
}
