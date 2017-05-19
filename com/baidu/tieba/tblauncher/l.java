package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    private final /* synthetic */ PopupWindow fyU;
    final /* synthetic */ MainTabActivity this$0;
    private final /* synthetic */ View zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MainTabActivity mainTabActivity, View view, PopupWindow popupWindow) {
        this.this$0 = mainTabActivity;
        this.zg = view;
        this.fyU = popupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zg.setVisibility(8);
        if (this.fyU != null && this.fyU.isShowing()) {
            this.fyU.dismiss();
        }
        this.this$0.fys = false;
    }
}
