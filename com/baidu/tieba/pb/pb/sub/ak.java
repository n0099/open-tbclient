package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    private final /* synthetic */ int Tf;
    final /* synthetic */ af eka;
    private final /* synthetic */ View qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(af afVar, View view, int i) {
        this.eka = afVar;
        this.qa = view;
        this.Tf = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.qa != null) {
            int[] iArr = new int[2];
            pVar = this.eka.dhw;
            pVar.Bl().getLocationInWindow(iArr);
            bdListView = this.eka.zU;
            bdListView.setSelectionFromTop(this.Tf + 1, iArr[1] - this.qa.getHeight());
            bdListView2 = this.eka.zU;
            bdListView2.invalidate();
        }
    }
}
