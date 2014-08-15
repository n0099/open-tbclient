package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.d != null) {
            this.a.d.b();
            this.a.d = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bt(this.a, 23007)));
    }
}
