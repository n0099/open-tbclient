package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bKT.sendMessage(new CustomMessage(2001284));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.bKT.getPageContext().getPageActivity(), 23003)));
    }
}
