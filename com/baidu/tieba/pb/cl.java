package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(br brVar) {
        this.f1583a = brVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 0;
    }
}
