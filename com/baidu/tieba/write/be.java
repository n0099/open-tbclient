package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class be implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.showDialog(com.baidu.tieba.v.live_time_rel);
    }
}
