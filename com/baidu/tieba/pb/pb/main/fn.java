package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fn implements Runnable {
    final /* synthetic */ fm dng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(fm fmVar) {
        this.dng = fmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        eu euVar;
        PbActivity pbActivity;
        eu euVar2;
        PbActivity pbActivity2;
        eu euVar3;
        RelativeLayout relativeLayout;
        euVar = this.dng.dnc;
        pbActivity = euVar.dfw;
        euVar2 = this.dng.dnc;
        pbActivity2 = euVar2.dfw;
        euVar3 = this.dng.dnc;
        relativeLayout = euVar3.cYO;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
