package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class cj implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2097a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(bt btVar) {
        this.f2097a = btVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 0;
    }
}
