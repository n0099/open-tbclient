package com.baidu.tieba.tblauncher;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnTouchListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        if (motionEvent.getAction() == 4) {
            popupWindow = this.this$0.cUm;
            com.baidu.adp.lib.g.j.a(popupWindow);
            return false;
        }
        return false;
    }
}
