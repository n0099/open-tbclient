package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    private final /* synthetic */ int VV;
    final /* synthetic */ ag ewi;
    private final /* synthetic */ View so;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar, View view, int i) {
        this.ewi = agVar;
        this.so = view;
        this.VV = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.so != null) {
            int[] iArr = new int[2];
            pVar = this.ewi.dtc;
            pVar.CG().getLocationInWindow(iArr);
            bdListView = this.ewi.Cj;
            bdListView.setSelectionFromTop(this.VV + 1, iArr[1] - this.so.getHeight());
            bdListView2 = this.ewi.Cj;
            bdListView2.invalidate();
        }
    }
}
