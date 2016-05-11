package com.baidu.tieba.recommendfrs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(r rVar) {
        this.dYM = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        this.dYM.hideTip();
        i = this.dYM.dYp;
        if (i == 1) {
            bdTypeListView = this.dYM.bej;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.dYM.bej;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.dYM.bej;
                bdTypeListView3.jy();
            }
        }
    }
}
