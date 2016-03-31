package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView cvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FloatingPersonalChatView floatingPersonalChatView) {
        this.cvr = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            i = this.cvr.currentIndex;
            if (i == intValue) {
                this.cvr.akj();
            } else {
                this.cvr.kq(intValue);
            }
        }
    }
}
