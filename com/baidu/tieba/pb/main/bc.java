package com.baidu.tieba.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class bc implements com.baidu.tieba.b.e {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tieba.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        bz bzVar;
        bz bzVar2;
        this.bAS.Xd();
        bzVar = this.bAS.bAw;
        bzVar.Yh();
        bzVar2 = this.bAS.bAw;
        bzVar2.Ze();
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
        bzVar = this.bAS.bAw;
        bzVar.dW(false);
        bzVar2 = this.bAS.bAw;
        bzVar2.O(view);
        bzVar3 = this.bAS.bAw;
        bzVar3.dW(true);
        return true;
    }
}
