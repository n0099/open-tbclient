package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class az implements com.baidu.tieba.pb.b.e {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        chVar = this.bKU.bKA;
        chVar.ee(false);
        chVar2 = this.bKU.bKA;
        chVar2.O(view);
        chVar3 = this.bKU.bKA;
        chVar3.ee(true);
        this.bKU.aaO();
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
        chVar = this.bKU.bKA;
        chVar.abU();
        this.bKU.aaO();
        chVar2 = this.bKU.bKA;
        chVar2.acx();
        return false;
    }
}
