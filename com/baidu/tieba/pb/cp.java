package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements View.OnTouchListener {
    final /* synthetic */ PbEditorToolView a;
    private final /* synthetic */ com.baidu.tieba.editortool.z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.z zVar) {
        this.a = pbEditorToolView;
        this.b = zVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.c.requestFocus();
            this.b.a(12, null);
        }
        return false;
    }
}
