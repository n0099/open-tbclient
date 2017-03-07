package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ b eux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.eux = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        cVar = this.eux.bQp;
        cVar.onTouchEvent(motionEvent);
        return true;
    }
}
