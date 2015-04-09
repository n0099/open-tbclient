package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ba implements com.baidu.tieba.pb.b.e {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        cjVar = this.bIJ.bIl;
        cjVar.dR(false);
        cjVar2 = this.bIJ.bIl;
        cjVar2.L(view);
        cjVar3 = this.bIJ.bIl;
        cjVar3.dR(true);
        this.bIJ.Zw();
        return true;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        cj cjVar;
        cj cjVar2;
        cjVar = this.bIJ.bIl;
        cjVar.aaF();
        this.bIJ.Zw();
        cjVar2 = this.bIJ.bIl;
        cjVar2.abC();
        return false;
    }
}
