package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class dp implements Runnable {
    final /* synthetic */ Cdo cGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(Cdo cdo) {
        this.cGj = cdo;
    }

    @Override // java.lang.Runnable
    public void run() {
        da daVar;
        PbActivity pbActivity;
        da daVar2;
        PbActivity pbActivity2;
        da daVar3;
        RelativeLayout relativeLayout;
        daVar = this.cGj.cGh;
        pbActivity = daVar.cCy;
        daVar2 = this.cGj.cGh;
        pbActivity2 = daVar2.cCy;
        daVar3 = this.cGj.cGh;
        relativeLayout = daVar3.cuP;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
