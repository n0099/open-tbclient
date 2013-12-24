package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.a = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.cancel();
    }
}
