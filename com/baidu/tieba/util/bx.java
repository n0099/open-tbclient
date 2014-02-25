package com.baidu.tieba.util;

import android.view.View;
/* loaded from: classes.dex */
class bx implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a();
    }
}
