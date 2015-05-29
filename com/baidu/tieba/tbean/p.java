package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.HorizontalListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ j cvh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(j jVar) {
        this.cvh = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        HorizontalListView horizontalListView;
        int i2;
        int i3 = 0;
        i = this.cvh.beo;
        if (i > 0) {
            i2 = this.cvh.beo;
            i3 = i2 - 1;
        }
        horizontalListView = this.cvh.cuQ;
        horizontalListView.setSelection(i3);
    }
}
