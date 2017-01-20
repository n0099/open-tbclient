package com.baidu.tieba.write.video;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ WriteLocationView fIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WriteLocationView writeLocationView) {
        this.fIQ = writeLocationView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        i = this.fIQ.avl;
        switch (i) {
            case 0:
                this.fIQ.Da();
                return;
            case 1:
            default:
                return;
            case 2:
                this.fIQ.CZ();
                return;
        }
    }
}
