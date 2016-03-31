package com.baidu.tieba.recommendfrs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar) {
        this.dVL = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        this.dVL.hideTip();
        i = this.dVL.dVu;
        if (i == 1) {
            bdTypeListView = this.dVL.bcd;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.dVL.bcd;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.dVL.bcd;
                bdTypeListView3.nk();
            }
        }
    }
}
