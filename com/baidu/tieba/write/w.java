package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WriteActivity writeActivity) {
        this.f1916a = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GridView gridView;
        if (motionEvent.getAction() == 1) {
            gridView = this.f1916a.r;
            gridView.setVisibility(8);
            return false;
        }
        return false;
    }
}
