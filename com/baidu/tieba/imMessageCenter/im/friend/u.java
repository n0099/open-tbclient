package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t bvV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bvV = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteFriendListActivity inviteFriendListActivity;
        inviteFriendListActivity = this.bvV.bvI;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(inviteFriendListActivity.getPageContext().getPageActivity())));
    }
}
