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
public class bm implements View.OnClickListener {
    final /* synthetic */ PersonListActivity ckd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PersonListActivity personListActivity) {
        this.ckd = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        br brVar;
        br brVar2;
        br brVar3;
        int intValue = ((Integer) view.getTag()).intValue();
        brVar = this.ckd.cjY;
        if (brVar != null) {
            brVar2 = this.ckd.cjY;
            if (brVar2.getItemViewType(intValue) == 0) {
                brVar3 = this.ckd.cjY;
                UserData userData = (UserData) brVar3.getItem(intValue);
                if (userData != null && userData.getUserId() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ckd.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                }
            }
        }
    }
}
