package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class gq implements Runnable {
    final /* synthetic */ gp evk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gq(gp gpVar) {
        this.evk = gpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        fx fxVar;
        PbActivity pbActivity;
        fx fxVar2;
        PbActivity pbActivity2;
        fx fxVar3;
        RelativeLayout relativeLayout;
        fxVar = this.evk.evi;
        pbActivity = fxVar.elf;
        fxVar2 = this.evk.evi;
        pbActivity2 = fxVar2.elf;
        fxVar3 = this.evk.evi;
        relativeLayout = fxVar3.bMv;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
