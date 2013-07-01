package com.baidu.tieba.nearby;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1157a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(NewNearbyActivity newNearbyActivity) {
        this.f1157a = newNearbyActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1157a.A = true;
            return false;
        }
        return false;
    }
}
