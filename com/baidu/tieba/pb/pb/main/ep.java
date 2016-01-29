package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class ep implements Runnable {
    final /* synthetic */ eo cSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(eo eoVar) {
        this.cSz = eoVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dz dzVar;
        PbActivity pbActivity;
        dz dzVar2;
        PbActivity pbActivity2;
        dz dzVar3;
        RelativeLayout relativeLayout;
        dzVar = this.cSz.cSw;
        pbActivity = dzVar.cNL;
        dzVar2 = this.cSz.cSw;
        pbActivity2 = dzVar2.cNL;
        dzVar3 = this.cSz.cSw;
        relativeLayout = dzVar3.cFw;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
