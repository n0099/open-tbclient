package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements View.OnTouchListener {
    final /* synthetic */ com.baidu.tieba.editortool.t a;
    final /* synthetic */ PbEditorToolView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.t tVar) {
        this.b = pbEditorToolView;
        this.a = tVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.b.c.requestFocus();
            this.a.a(12, null);
        }
        return false;
    }
}
