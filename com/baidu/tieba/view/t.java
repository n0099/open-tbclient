package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q fIZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.fIZ = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.adp.lib.util.i.gY()) {
            this.fIZ.JR();
            this.fIZ.lu(true);
            if (this.fIZ.fIR != null) {
                this.fIZ.fIR.NA();
            }
        }
    }
}
