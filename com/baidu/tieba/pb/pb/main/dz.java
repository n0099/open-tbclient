package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class dz implements Runnable {
    final /* synthetic */ dy cKi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dy dyVar) {
        this.cKi = dyVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dk dkVar;
        PbActivity pbActivity;
        dk dkVar2;
        PbActivity pbActivity2;
        dk dkVar3;
        RelativeLayout relativeLayout;
        dkVar = this.cKi.cKg;
        pbActivity = dkVar.cGj;
        dkVar2 = this.cKi.cKg;
        pbActivity2 = dkVar2.cGj;
        dkVar3 = this.cKi.cKg;
        relativeLayout = dkVar3.cyP;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
