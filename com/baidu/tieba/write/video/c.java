package com.baidu.tieba.write.video;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ WriteLocationView fNk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WriteLocationView writeLocationView) {
        this.fNk = writeLocationView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        i = this.fNk.aAG;
        switch (i) {
            case 0:
                this.fNk.Dt();
                return;
            case 1:
            default:
                return;
            case 2:
                this.fNk.Ds();
                return;
        }
    }
}
