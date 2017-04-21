package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fu implements Runnable {
    final /* synthetic */ ft etS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(ft ftVar) {
        this.etS = ftVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ey eyVar;
        PbActivity pbActivity;
        ey eyVar2;
        PbActivity pbActivity2;
        ey eyVar3;
        RelativeLayout relativeLayout;
        eyVar = this.etS.etN;
        pbActivity = eyVar.ekw;
        eyVar2 = this.etS.etN;
        pbActivity2 = eyVar2.ekw;
        eyVar3 = this.etS.etN;
        relativeLayout = eyVar3.dVV;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
