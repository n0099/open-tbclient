package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    private final /* synthetic */ int YA;
    final /* synthetic */ w cUl;
    private final /* synthetic */ View yW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(w wVar, View view, int i) {
        this.cUl = wVar;
        this.yW = view;
        this.YA = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.yW != null) {
            int[] iArr = new int[2];
            pVar = this.cUl.cnC;
            pVar.Cz().getLocationInWindow(iArr);
            bdListView = this.cUl.IY;
            bdListView.setSelectionFromTop(this.YA + 1, iArr[1] - this.yW.getHeight());
            bdListView2 = this.cUl.IY;
            bdListView2.invalidate();
        }
    }
}
