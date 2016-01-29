package com.baidu.tieba.recommendfrs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p dDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.dDT = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        this.dDT.hideTip();
        i = this.dDT.dDF;
        if (i == 1) {
            bdTypeListView = this.dDT.aXu;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.dDT.aXu;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.dDT.aXu;
                bdTypeListView3.ns();
            }
        }
    }
}
