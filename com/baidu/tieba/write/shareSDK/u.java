package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements PopupWindow.OnDismissListener {
    final /* synthetic */ o dmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.dmr = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        View view;
        view = this.dmr.dmi;
        view.setSelected(false);
    }
}
