package com.baidu.tieba.view;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ an f2661a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.f2661a = anVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2661a.dismiss();
            return false;
        }
        return false;
    }
}
