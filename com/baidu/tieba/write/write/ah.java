package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ddQ.ayI();
        this.ddQ.azB();
    }
}
