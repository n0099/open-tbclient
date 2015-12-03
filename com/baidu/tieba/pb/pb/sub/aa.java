package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ w cHA;
    private final /* synthetic */ int val$position;
    private final /* synthetic */ View yM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, View view, int i) {
        this.cHA = wVar;
        this.yM = view;
        this.val$position = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.yM != null) {
            int[] iArr = new int[2];
            pVar = this.cHA.ceY;
            pVar.Bu().getLocationInWindow(iArr);
            bdListView = this.cHA.mListView;
            bdListView.setSelectionFromTop(this.val$position + 1, iArr[1] - this.yM.getHeight());
            bdListView2 = this.cHA.mListView;
            bdListView2.invalidate();
        }
    }
}
