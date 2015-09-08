package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ t chq;
    private final /* synthetic */ int val$position;
    private final /* synthetic */ View yF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, View view, int i) {
        this.chq = tVar;
        this.yF = view;
        this.val$position = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.c.n nVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.yF != null) {
            int[] iArr = new int[2];
            nVar = this.chq.bWV;
            nVar.AL().getLocationInWindow(iArr);
            bdListView = this.chq.mListView;
            bdListView.setSelectionFromTop(this.val$position + 1, iArr[1] - this.yF.getHeight());
            bdListView2 = this.chq.mListView;
            bdListView2.invalidate();
        }
    }
}
