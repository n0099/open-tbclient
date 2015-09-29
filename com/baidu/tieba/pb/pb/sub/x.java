package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ t cmM;
    private final /* synthetic */ int val$position;
    private final /* synthetic */ View yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, View view, int i) {
        this.cmM = tVar;
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
            nVar = this.cmM.caJ;
            nVar.Ax().getLocationInWindow(iArr);
            bdListView = this.cmM.mListView;
            bdListView.setSelectionFromTop(this.val$position + 1, iArr[1] - this.yG.getHeight());
            bdListView2 = this.cmM.mListView;
            bdListView2.invalidate();
        }
    }
}
