package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bTX.showDialog(com.baidu.tieba.v.live_time_rel);
    }
}
