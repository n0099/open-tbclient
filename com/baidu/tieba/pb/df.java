package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2138a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(cp cpVar) {
        this.f2138a = cpVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 0;
    }
}
