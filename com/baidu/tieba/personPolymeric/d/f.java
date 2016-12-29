package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.evi = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TbPageContext tbPageContext;
        if (view != null) {
            z = this.evi.bfj;
            if (!z) {
                TiebaStatic.log(new at("c11595"));
            }
            if (view.getTag() instanceof UserData) {
                UserData userData = (UserData) view.getTag();
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext = this.evi.GO;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
            }
        }
    }
}
