package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements PopupWindow.OnDismissListener {
    final /* synthetic */ o faw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.faw = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        View view;
        view = this.faw.fan;
        view.setSelected(false);
    }
}
