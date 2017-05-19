package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class gi implements Runnable {
    final /* synthetic */ gh epv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gi(gh ghVar) {
        this.epv = ghVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        fm fmVar;
        PbActivity pbActivity;
        fm fmVar2;
        PbActivity pbActivity2;
        fm fmVar3;
        RelativeLayout relativeLayout;
        fmVar = this.epv.epr;
        pbActivity = fmVar.efF;
        fmVar2 = this.epv.epr;
        pbActivity2 = fmVar2.efF;
        fmVar3 = this.epv.epr;
        relativeLayout = fmVar3.bGH;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
