package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class az implements com.baidu.tieba.pb.b.e {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        ciVar = this.bIv.bHY;
        ciVar.dT(false);
        ciVar2 = this.bIv.bHY;
        ciVar2.L(view);
        ciVar3 = this.bIv.bHY;
        ciVar3.dT(true);
        this.bIv.Zj();
        return true;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        ci ciVar;
        ci ciVar2;
        ciVar = this.bIv.bHY;
        ciVar.aas();
        this.bIv.Zj();
        ciVar2 = this.bIv.bHY;
        ciVar2.abo();
        return false;
    }
}
