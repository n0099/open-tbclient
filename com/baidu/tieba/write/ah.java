package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cft.acy();
        this.cft.ajZ();
    }
}
