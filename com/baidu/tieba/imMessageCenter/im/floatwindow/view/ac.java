package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView ckL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FloatingPersonalChatView floatingPersonalChatView) {
        this.ckL = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            i = this.ckL.currentIndex;
            if (i == intValue) {
                this.ckL.agP();
            } else {
                this.ckL.jK(intValue);
            }
        }
    }
}
