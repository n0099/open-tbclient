package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView cvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FloatingPersonalChatView floatingPersonalChatView) {
        this.cvr = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cvr.akj();
    }
}
