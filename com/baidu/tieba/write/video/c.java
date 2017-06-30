package com.baidu.tieba.write.video;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ WriteLocationView gij;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WriteLocationView writeLocationView) {
        this.gij = writeLocationView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        i = this.gij.aBL;
        switch (i) {
            case 0:
                this.gij.Dj();
                return;
            case 1:
            default:
                return;
            case 2:
                this.gij.Di();
                return;
        }
    }
}
