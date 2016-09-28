package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    private final /* synthetic */ int Wf;
    final /* synthetic */ ag eyq;
    private final /* synthetic */ View so;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar, View view, int i) {
        this.eyq = agVar;
        this.so = view;
        this.Wf = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.e.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.so != null) {
            int[] iArr = new int[2];
            pVar = this.eyq.duz;
            pVar.CG().getLocationInWindow(iArr);
            bdListView = this.eyq.Cj;
            bdListView.setSelectionFromTop(this.Wf + 1, iArr[1] - this.so.getHeight());
            bdListView2 = this.eyq.Cj;
            bdListView2.invalidate();
        }
    }
}
