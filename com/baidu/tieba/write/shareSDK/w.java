package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements PopupWindow.OnDismissListener {
    final /* synthetic */ q cAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar) {
        this.cAL = qVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        View view;
        view = this.cAL.cAD;
        view.setSelected(false);
    }
}
