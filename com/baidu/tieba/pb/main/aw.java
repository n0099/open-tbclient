package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bzj.aIX != null) {
            this.bzj.aIX.dismiss();
            this.bzj.aIX = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.bzj.getPageContext().getPageActivity(), 23003)));
    }
}
