package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnTouchListener {
    final /* synthetic */ b ehZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.ehZ = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.d.c cVar;
        cVar = this.ehZ.bBN;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
