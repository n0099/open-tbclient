package com.baidu.tieba.plugins;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ g bHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bHf = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.bHf.adh;
        linearLayout.setVisibility(8);
        linearLayout2 = this.bHf.bGW;
        linearLayout2.setVisibility(0);
    }
}
