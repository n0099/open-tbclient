package com.baidu.tieba.pb;

import android.view.View;
/* renamed from: com.baidu.tieba.pb.do  reason: invalid class name */
/* loaded from: classes.dex */
class Cdo implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.c.canGoBack()) {
            this.a.c.goBack();
        }
    }
}
