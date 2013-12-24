package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ CommonWebviewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(CommonWebviewActivity commonWebviewActivity) {
        this.a = commonWebviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a();
    }
}
