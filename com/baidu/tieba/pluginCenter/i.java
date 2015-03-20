package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ g bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bUI = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.bUI.atV;
        linearLayout.setVisibility(8);
        linearLayout2 = this.bUI.bUz;
        linearLayout2.setVisibility(0);
    }
}
