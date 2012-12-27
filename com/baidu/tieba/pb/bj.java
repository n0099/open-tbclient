package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnFocusChangeListener {
    final /* synthetic */ bi a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.a = biVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PbActivity pbActivity;
        if (z) {
            return;
        }
        pbActivity = this.a.a;
        com.baidu.tieba.c.ag.a(pbActivity, view);
    }
}
