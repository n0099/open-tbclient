package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ t cgt;
    private final /* synthetic */ int val$position;
    private final /* synthetic */ View yH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, View view, int i) {
        this.cgt = tVar;
        this.yH = view;
        this.val$position = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.c.n nVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.yH != null) {
            int[] iArr = new int[2];
            nVar = this.cgt.bWp;
            nVar.Ay().getLocationInWindow(iArr);
            bdListView = this.cgt.mListView;
            bdListView.setSelectionFromTop(this.val$position + 1, iArr[1] - this.yH.getHeight());
            bdListView2 = this.cgt.mListView;
            bdListView2.invalidate();
        }
    }
}
