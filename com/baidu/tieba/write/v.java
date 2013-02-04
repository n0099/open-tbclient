package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnTouchListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        if (motionEvent.getAction() == 1) {
            gridView = this.a.p;
            gridView.setVisibility(8);
            return false;
        }
        return false;
    }
}
