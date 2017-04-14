package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fu implements Runnable {
    final /* synthetic */ ft erA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(ft ftVar) {
        this.erA = ftVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ey eyVar;
        PbActivity pbActivity;
        ey eyVar2;
        PbActivity pbActivity2;
        ey eyVar3;
        RelativeLayout relativeLayout;
        eyVar = this.erA.erv;
        pbActivity = eyVar.eig;
        eyVar2 = this.erA.erv;
        pbActivity2 = eyVar2.eig;
        eyVar3 = this.erA.erv;
        relativeLayout = eyVar3.dTF;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
