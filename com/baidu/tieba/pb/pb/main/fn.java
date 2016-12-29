package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fn implements Runnable {
    final /* synthetic */ fm ehd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(fm fmVar) {
        this.ehd = fmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        er erVar;
        PbActivity pbActivity;
        er erVar2;
        PbActivity pbActivity2;
        er erVar3;
        RelativeLayout relativeLayout;
        erVar = this.ehd.egZ;
        pbActivity = erVar.dYB;
        erVar2 = this.ehd.egZ;
        pbActivity2 = erVar2.dYB;
        erVar3 = this.ehd.egZ;
        relativeLayout = erVar3.dKv;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
