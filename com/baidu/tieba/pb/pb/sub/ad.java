package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements Runnable {
    private final /* synthetic */ int Sg;
    final /* synthetic */ y dqN;
    private final /* synthetic */ View py;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(y yVar, View view, int i) {
        this.dqN = yVar;
        this.py = view;
        this.Sg = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.py != null) {
            int[] iArr = new int[2];
            pVar = this.dqN.czd;
            pVar.Bb().getLocationInWindow(iArr);
            bdListView = this.dqN.zu;
            bdListView.setSelectionFromTop(this.Sg + 1, iArr[1] - this.py.getHeight());
            bdListView2 = this.dqN.zu;
            bdListView2.invalidate();
        }
    }
}
