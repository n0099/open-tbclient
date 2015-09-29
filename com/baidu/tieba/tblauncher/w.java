package com.baidu.tieba.tblauncher;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        PopupWindow popupWindow;
        popupWindow = this.this$0.dbT;
        com.baidu.adp.lib.g.j.a(popupWindow);
    }
}
