package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bzj.aIX != null) {
            this.bzj.aIX.dismiss();
            this.bzj.aIX = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.bzj.getPageContext().getPageActivity(), 23007)));
    }
}
