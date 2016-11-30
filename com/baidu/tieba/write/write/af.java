package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gpp.bhY();
        this.gpp.bvH();
    }
}
