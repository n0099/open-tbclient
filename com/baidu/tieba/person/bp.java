package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ PersonListActivity cqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonListActivity personListActivity) {
        this.cqN = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            bsVar = this.cqN.cqI;
            if (bsVar != null) {
                bsVar2 = this.cqN.cqI;
                if (bsVar2.getItemViewType(this.cqN.cqj) == 0) {
                    bsVar3 = this.cqN.cqI;
                    UserData userData = (UserData) bsVar3.getItem(intValue);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(this.cqN.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FOCUS_RECOM)));
                }
            }
        }
    }
}
