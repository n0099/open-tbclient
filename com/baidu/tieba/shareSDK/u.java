package com.baidu.tieba.shareSDK;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements PopupWindow.OnDismissListener {
    final /* synthetic */ p bJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar) {
        this.bJX = pVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        View view;
        view = this.bJX.bJP;
        view.setSelected(false);
    }
}
