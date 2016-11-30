package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ b eDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.eDZ = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.d.c cVar;
        cVar = this.eDZ.bVF;
        cVar.onTouchEvent(motionEvent);
        return true;
    }
}
