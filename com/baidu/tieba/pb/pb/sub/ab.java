package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ w cLC;
    private final /* synthetic */ int val$position;
    private final /* synthetic */ View yO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(w wVar, View view, int i) {
        this.cLC = wVar;
        this.yO = view;
        this.val$position = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.yO != null) {
            int[] iArr = new int[2];
            pVar = this.cLC.cjc;
            pVar.Bj().getLocationInWindow(iArr);
            bdListView = this.cLC.mListView;
            bdListView.setSelectionFromTop(this.val$position + 1, iArr[1] - this.yO.getHeight());
            bdListView2 = this.cLC.mListView;
            bdListView2.invalidate();
        }
    }
}
