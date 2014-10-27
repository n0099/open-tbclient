package com.baidu.tieba.shareSDK;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements PopupWindow.OnDismissListener {
    final /* synthetic */ o bJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.bJI = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        View view;
        view = this.bJI.bJA;
        view.setSelected(false);
    }
}
