package com.baidu.tieba.plugins;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.a.i;
        linearLayout.setVisibility(8);
        linearLayout2 = this.a.b;
        linearLayout2.setVisibility(0);
    }
}
