package com.baidu.tieba.view;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class am implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f1850a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.f1850a = alVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1850a.dismiss();
            return false;
        }
        return false;
    }
}
