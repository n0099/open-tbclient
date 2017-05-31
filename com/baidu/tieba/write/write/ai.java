package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gaR.bdV();
        this.gaR.bpb();
    }
}
