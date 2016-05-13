package com.baidu.tieba.write.video;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ WriteLocationView faw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WriteLocationView writeLocationView) {
        this.faw = writeLocationView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        i = this.faw.arC;
        switch (i) {
            case 0:
                this.faw.BK();
                return;
            case 1:
            default:
                return;
            case 2:
                this.faw.BJ();
                return;
        }
    }
}
