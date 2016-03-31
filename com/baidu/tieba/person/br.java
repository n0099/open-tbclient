package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ PersonListActivity dtT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonListActivity personListActivity) {
        this.dtT = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            buVar = this.dtT.dtO;
            if (buVar != null) {
                buVar2 = this.dtT.dtO;
                if (buVar2.getItemViewType(this.dtT.dto) == 0) {
                    buVar3 = this.dtT.dtO;
                    UserData userData = (UserData) buVar3.getItem(intValue);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.dtT.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FOCUS_RECOM)));
                }
            }
        }
    }
}
