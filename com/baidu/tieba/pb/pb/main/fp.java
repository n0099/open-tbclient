package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class fp implements Runnable {
    final /* synthetic */ fo eiy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(fo foVar) {
        this.eiy = foVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ew ewVar;
        PbActivity pbActivity;
        ew ewVar2;
        PbActivity pbActivity2;
        ew ewVar3;
        RelativeLayout relativeLayout;
        ewVar = this.eiy.eiu;
        pbActivity = ewVar.eat;
        ewVar2 = this.eiy.eiu;
        pbActivity2 = ewVar2.eat;
        ewVar3 = this.eiy.eiu;
        relativeLayout = ewVar3.dLY;
        pbActivity2.HidenSoftKeyPad((InputMethodManager) pbActivity.getSystemService("input_method"), relativeLayout);
    }
}
