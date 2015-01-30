package com.baidu.tieba.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class bc implements com.baidu.tieba.b.e {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tieba.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        bz bzVar;
        bz bzVar2;
        this.bAT.Xi();
        bzVar = this.bAT.bAx;
        bzVar.Ym();
        bzVar2 = this.bAT.bAx;
        bzVar2.Zj();
        return false;
    }

    @Override // com.baidu.tieba.b.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bAT.bAx;
        bzVar.dW(false);
        bzVar2 = this.bAT.bAx;
        bzVar2.O(view);
        bzVar3 = this.bAT.bAx;
        bzVar3.dW(true);
        return true;
    }
}
