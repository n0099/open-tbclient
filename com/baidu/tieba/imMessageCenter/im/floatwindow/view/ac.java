package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView bNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FloatingPersonalChatView floatingPersonalChatView) {
        this.bNh = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            i = this.bNh.currentIndex;
            if (i == intValue) {
                this.bNh.Zr();
            } else {
                this.bNh.hZ(intValue);
            }
        }
    }
}
