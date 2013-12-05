package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2230a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(cr crVar) {
        this.f2230a = crVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 0;
    }
}
