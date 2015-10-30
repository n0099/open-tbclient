package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ t cmX;
    private final /* synthetic */ int val$position;
    private final /* synthetic */ View yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, View view, int i) {
        this.cmX = tVar;
        this.yG = view;
        this.val$position = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.c.n nVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.yG != null) {
            int[] iArr = new int[2];
            nVar = this.cmX.caU;
            nVar.Au().getLocationInWindow(iArr);
            bdListView = this.cmX.mListView;
            bdListView.setSelectionFromTop(this.val$position + 1, iArr[1] - this.yG.getHeight());
            bdListView2 = this.cmX.mListView;
            bdListView2.invalidate();
        }
    }
}
