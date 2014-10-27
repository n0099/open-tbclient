package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.HorizontalListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ j bNX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(j jVar) {
        this.bNX = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        HorizontalListView horizontalListView;
        int i2;
        int i3 = 0;
        i = this.bNX.aUh;
        if (i > 0) {
            i2 = this.bNX.aUh;
            i3 = i2 - 1;
        }
        horizontalListView = this.bNX.bNG;
        horizontalListView.setSelection(i3);
    }
}
