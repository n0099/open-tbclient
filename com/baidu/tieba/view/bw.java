package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class bw extends Dialog {
    public bw(Context context) {
        super(context, R.style.common_alert_dialog);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        super.setContentView(view);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (!dispatchTouchEvent && motionEvent.getAction() == 0) {
            dismiss();
        }
        return dispatchTouchEvent;
    }
}
