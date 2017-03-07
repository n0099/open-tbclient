package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fw implements Runnable {
    final /* synthetic */ fv ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(fv fvVar) {
        this.ets = fvVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        fa faVar;
        PbActivity pbActivity;
        fa faVar2;
        PbActivity pbActivity2;
        fa faVar3;
        RelativeLayout relativeLayout;
        faVar = this.ets.etn;
        pbActivity = faVar.eka;
        faVar2 = this.ets.etn;
        pbActivity2 = faVar2.eka;
        faVar3 = this.ets.etn;
        relativeLayout = faVar3.dWm;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
