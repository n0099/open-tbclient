package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2622a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity) {
        this.f2622a = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        if (motionEvent.getAction() == 1) {
            gridView = this.f2622a.u;
            gridView.setVisibility(8);
            this.f2622a.f();
            this.f2622a.d(7);
            return false;
        }
        return false;
    }
}
