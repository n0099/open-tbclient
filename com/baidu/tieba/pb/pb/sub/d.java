package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnTouchListener {
    final /* synthetic */ b erj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.erj = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.f.c cVar;
        cVar = this.erj.bJg;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
