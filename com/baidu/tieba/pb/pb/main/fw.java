package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fw implements Runnable {
    final /* synthetic */ fv eql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(fv fvVar) {
        this.eql = fvVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ez ezVar;
        PbActivity pbActivity;
        ez ezVar2;
        PbActivity pbActivity2;
        ez ezVar3;
        RelativeLayout relativeLayout;
        ezVar = this.eql.eqf;
        pbActivity = ezVar.ehi;
        ezVar2 = this.eql.eqf;
        pbActivity2 = ezVar2.ehi;
        ezVar3 = this.eql.eqf;
        relativeLayout = ezVar3.dTs;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
