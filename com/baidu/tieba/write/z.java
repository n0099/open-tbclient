package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteActivity writeActivity) {
        this.f2133a = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        if (motionEvent.getAction() == 1) {
            gridView = this.f2133a.u;
            gridView.setVisibility(8);
            this.f2133a.m();
            this.f2133a.b(7);
            return false;
        }
        return false;
    }
}
