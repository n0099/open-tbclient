package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fq implements Runnable {
    final /* synthetic */ fp ewL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(fp fpVar) {
        this.ewL = fpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ex exVar;
        PbActivity pbActivity;
        ex exVar2;
        PbActivity pbActivity2;
        ex exVar3;
        RelativeLayout relativeLayout;
        exVar = this.ewL.ewH;
        pbActivity = exVar.eow;
        exVar2 = this.ewL.ewH;
        pbActivity2 = exVar2.eow;
        exVar3 = this.ewL.ewH;
        relativeLayout = exVar3.dZP;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
