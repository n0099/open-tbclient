package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements PopupWindow.OnDismissListener {
    final /* synthetic */ q cwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar) {
        this.cwf = qVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        View view;
        view = this.cwf.cvX;
        view.setSelected(false);
    }
}
