package com.baidu.tieba.recommendfrs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n doE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.doE = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        this.doE.hideTip();
        i = this.doE.dos;
        if (i == 1) {
            bdTypeListView = this.doE.aVi;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.doE.aVi;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.doE.aVi;
                bdTypeListView3.nb();
            }
        }
    }
}
