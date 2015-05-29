package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class az implements com.baidu.tieba.pb.b.e {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        chVar = this.bKT.bKz;
        chVar.ee(false);
        chVar2 = this.bKT.bKz;
        chVar2.O(view);
        chVar3 = this.bKT.bKz;
        chVar3.ee(true);
        this.bKT.aaN();
        return true;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        ch chVar;
        ch chVar2;
        chVar = this.bKT.bKz;
        chVar.abT();
        this.bKT.aaN();
        chVar2 = this.bKT.bKz;
        chVar2.acw();
        return false;
    }
}
