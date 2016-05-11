package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fe implements Runnable {
    final /* synthetic */ fd dpy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(fd fdVar) {
        this.dpy = fdVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        el elVar;
        PbActivity pbActivity;
        el elVar2;
        PbActivity pbActivity2;
        el elVar3;
        RelativeLayout relativeLayout;
        elVar = this.dpy.dpu;
        pbActivity = elVar.dhY;
        elVar2 = this.dpy.dpu;
        pbActivity2 = elVar2.dhY;
        elVar3 = this.dpy.dpu;
        relativeLayout = elVar3.dbg;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
