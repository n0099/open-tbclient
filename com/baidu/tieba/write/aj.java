package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bUm.showDialog(com.baidu.tieba.v.live_time_rel);
    }
}
