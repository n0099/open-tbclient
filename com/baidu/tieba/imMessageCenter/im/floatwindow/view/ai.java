package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView bMM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FloatingPersonalChatView floatingPersonalChatView) {
        this.bMM = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bMM.Za();
    }
}
