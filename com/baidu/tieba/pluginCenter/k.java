package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ i bXC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bXC = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.bXC.avE;
        linearLayout.setVisibility(8);
        linearLayout2 = this.bXC.bXt;
        linearLayout2.setVisibility(0);
    }
}
