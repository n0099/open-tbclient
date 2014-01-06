package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements View.OnTouchListener {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(cs csVar) {
        this.a = csVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 0;
    }
}
