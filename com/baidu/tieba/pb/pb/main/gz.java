package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class gz implements Runnable {
    final /* synthetic */ gy eEx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(gy gyVar) {
        this.eEx = gyVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        gg ggVar;
        PbActivity pbActivity;
        gg ggVar2;
        PbActivity pbActivity2;
        gg ggVar3;
        RelativeLayout relativeLayout;
        ggVar = this.eEx.eEv;
        pbActivity = ggVar.euf;
        ggVar2 = this.eEx.eEv;
        pbActivity2 = ggVar2.euf;
        ggVar3 = this.eEx.eEv;
        relativeLayout = ggVar3.bSW;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
