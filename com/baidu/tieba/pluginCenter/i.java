package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ g bUY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bUY = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.bUY.aud;
        linearLayout.setVisibility(8);
        linearLayout2 = this.bUY.bUP;
        linearLayout2.setVisibility(0);
    }
}
