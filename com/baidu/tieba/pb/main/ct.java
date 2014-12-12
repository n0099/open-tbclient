package com.baidu.tieba.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements com.baidu.tieba.b.e {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // com.baidu.tieba.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        this.bCR.dQ(false);
        this.bCR.M(view);
        this.bCR.dQ(true);
        return true;
    }

    @Override // com.baidu.tieba.b.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        this.bCR.XH();
        this.bCR.YE();
        return false;
    }
}
