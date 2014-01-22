package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements View.OnTouchListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(cr crVar) {
        this.a = crVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 0;
    }
}
