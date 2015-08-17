package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView bIP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FloatingPersonalChatView floatingPersonalChatView) {
        this.bIP = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            i = this.bIP.currentIndex;
            if (i == intValue) {
                this.bIP.Yq();
            } else {
                this.bIP.hw(intValue);
            }
        }
    }
}
