package com.baidu.tieba.shareSDK;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements PopupWindow.OnDismissListener {
    final /* synthetic */ q bOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.bOn = qVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        View view;
        view = this.bOn.bOf;
        view.setSelected(false);
    }
}
