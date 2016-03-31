package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    private final /* synthetic */ int WS;
    final /* synthetic */ x dpf;
    private final /* synthetic */ View zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar, View view, int i) {
        this.dpf = xVar;
        this.zn = view;
        this.WS = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.zn != null) {
            int[] iArr = new int[2];
            pVar = this.dpf.cye;
            pVar.Dh().getLocationInWindow(iArr);
            bdListView = this.dpf.Je;
            bdListView.setSelectionFromTop(this.WS + 1, iArr[1] - this.zn.getHeight());
            bdListView2 = this.dpf.Je;
            bdListView2.invalidate();
        }
    }
}
