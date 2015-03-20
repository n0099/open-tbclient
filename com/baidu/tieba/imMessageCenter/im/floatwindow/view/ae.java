package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView brW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FloatingPersonalChatView floatingPersonalChatView) {
        this.brW = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            i = this.brW.currentIndex;
            if (i == intValue) {
                this.brW.Ve();
            } else {
                this.brW.gz(intValue);
            }
        }
    }
}
