package com.baidu.tieba.view;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ag implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ af f1811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.f1811a = afVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1811a.dismiss();
            return false;
        }
        return false;
    }
}
