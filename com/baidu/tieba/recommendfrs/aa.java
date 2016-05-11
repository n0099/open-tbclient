package com.baidu.tieba.recommendfrs;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.dYM = rVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        com.baidu.tieba.c.a aVar;
        com.baidu.tieba.c.a aVar2;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.dYM.dYx;
        if (onTouchListener != null) {
            onTouchListener2 = this.dYM.dYx;
            onTouchListener2.onTouch(view, motionEvent);
        }
        aVar = this.dYM.dYy;
        if (aVar != null) {
            aVar2 = this.dYM.dYy;
            aVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
