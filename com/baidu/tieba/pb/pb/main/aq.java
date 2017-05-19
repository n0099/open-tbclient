package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class aq implements View.OnTouchListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        cVar = this.ehy.bRf;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
