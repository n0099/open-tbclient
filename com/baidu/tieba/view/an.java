package com.baidu.tieba.view;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class an implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f1977a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.f1977a = amVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1977a.dismiss();
            return false;
        }
        return false;
    }
}
