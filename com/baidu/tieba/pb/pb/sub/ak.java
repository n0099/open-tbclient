package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    private final /* synthetic */ int Sx;
    final /* synthetic */ af dXy;
    private final /* synthetic */ View py;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(af afVar, View view, int i) {
        this.dXy = afVar;
        this.py = view;
        this.Sx = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.py != null) {
            int[] iArr = new int[2];
            pVar = this.dXy.deA;
            pVar.Bl().getLocationInWindow(iArr);
            bdListView = this.dXy.zt;
            bdListView.setSelectionFromTop(this.Sx + 1, iArr[1] - this.py.getHeight());
            bdListView2 = this.dXy.zt;
            bdListView2.invalidate();
        }
    }
}
