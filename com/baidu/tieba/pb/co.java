package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements View.OnTouchListener {
    final /* synthetic */ com.baidu.tieba.editortool.h a;
    final /* synthetic */ PbEditorToolView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.h hVar) {
        this.b = pbEditorToolView;
        this.a = hVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.b.h();
            this.b.d.requestFocus();
            this.a.a(12, null);
        }
        return false;
    }
}
