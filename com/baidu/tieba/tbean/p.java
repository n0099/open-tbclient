package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.HorizontalListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ j bOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(j jVar) {
        this.bOm = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        HorizontalListView horizontalListView;
        int i2;
        int i3 = 0;
        i = this.bOm.aUv;
        if (i > 0) {
            i2 = this.bOm.aUv;
            i3 = i2 - 1;
        }
        horizontalListView = this.bOm.bNV;
        horizontalListView.setSelection(i3);
    }
}
