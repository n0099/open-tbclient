package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    final /* synthetic */ v coo;
    private final /* synthetic */ int val$position;
    private final /* synthetic */ View yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(v vVar, View view, int i) {
        this.coo = vVar;
        this.yG = view;
        this.val$position = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.c.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.yG != null) {
            int[] iArr = new int[2];
            pVar = this.coo.cbv;
            pVar.Az().getLocationInWindow(iArr);
            bdListView = this.coo.mListView;
            bdListView.setSelectionFromTop(this.val$position + 1, iArr[1] - this.yG.getHeight());
            bdListView2 = this.coo.mListView;
            bdListView2.invalidate();
        }
    }
}
