package com.baidu.tieba.view;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class an implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f2563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.f2563a = amVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2563a.dismiss();
            return false;
        }
        return false;
    }
}
