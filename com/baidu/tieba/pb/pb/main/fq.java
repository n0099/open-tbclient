package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fq implements Runnable {
    final /* synthetic */ fp euF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(fp fpVar) {
        this.euF = fpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ex exVar;
        PbActivity pbActivity;
        ex exVar2;
        PbActivity pbActivity2;
        ex exVar3;
        RelativeLayout relativeLayout;
        exVar = this.euF.euB;
        pbActivity = exVar.emy;
        exVar2 = this.euF.euB;
        pbActivity2 = exVar2.emy;
        exVar3 = this.euF.euB;
        relativeLayout = exVar3.dXV;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
