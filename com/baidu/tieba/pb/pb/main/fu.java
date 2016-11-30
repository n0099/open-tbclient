package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fu implements Runnable {
    final /* synthetic */ ft eCX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(ft ftVar) {
        this.eCX = ftVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ey eyVar;
        PbActivity pbActivity;
        ey eyVar2;
        PbActivity pbActivity2;
        ey eyVar3;
        RelativeLayout relativeLayout;
        eyVar = this.eCX.eCT;
        pbActivity = eyVar.eug;
        eyVar2 = this.eCX.eCT;
        pbActivity2 = eyVar2.eug;
        eyVar3 = this.eCX.eCT;
        relativeLayout = eyVar3.efO;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
