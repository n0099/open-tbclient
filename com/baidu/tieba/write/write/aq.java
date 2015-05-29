package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cCP.showDialog(com.baidu.tieba.q.live_time_rel);
    }
}
