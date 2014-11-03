package com.baidu.tieba.plugins;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ g bHt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bHt = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.bHt.adm;
        linearLayout.setVisibility(8);
        linearLayout2 = this.bHt.bHk;
        linearLayout2.setVisibility(0);
    }
}
