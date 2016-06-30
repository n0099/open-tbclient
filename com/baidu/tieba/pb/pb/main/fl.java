package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fl implements Runnable {
    final /* synthetic */ fk dVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(fk fkVar) {
        this.dVV = fkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        es esVar;
        PbActivity pbActivity;
        es esVar2;
        PbActivity pbActivity2;
        es esVar3;
        RelativeLayout relativeLayout;
        esVar = this.dVV.dVR;
        pbActivity = esVar.dOg;
        esVar2 = this.dVV.dVR;
        pbActivity2 = esVar2.dOg;
        esVar3 = this.dVV.dVR;
        relativeLayout = esVar3.dHM;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
