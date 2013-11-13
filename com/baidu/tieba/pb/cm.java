package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2118a;
    final /* synthetic */ PbEditorToolView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.h hVar) {
        this.b = pbEditorToolView;
        this.f2118a = hVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.b.h();
            this.b.d.setSelection(this.b.d.getText().length());
            this.b.d.requestFocus();
            this.f2118a.a(12, null);
        }
        return false;
    }
}
