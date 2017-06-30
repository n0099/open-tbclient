package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* loaded from: classes2.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ MessageCenterActivity duw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(MessageCenterActivity messageCenterActivity) {
        this.duw = messageCenterActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.duw.finish();
    }
}
