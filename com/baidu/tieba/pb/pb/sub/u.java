package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    private final /* synthetic */ int RY;
    final /* synthetic */ s bPU;
    private final /* synthetic */ View yH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar, View view, int i) {
        this.bPU = sVar;
        this.yH = view;
        this.RY = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbEditor pbEditor;
        BdListView bdListView;
        BdListView bdListView2;
        if (this.yH != null) {
            int[] iArr = new int[2];
            pbEditor = this.bPU.aKP;
            pbEditor.getLocationInWindow(iArr);
            bdListView = this.bPU.mListView;
            bdListView.setSelectionFromTop(this.RY + 1, iArr[1] - this.yH.getHeight());
            bdListView2 = this.bPU.mListView;
            bdListView2.invalidate();
        }
    }
}
