package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.HorizontalListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ j ccq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(j jVar) {
        this.ccq = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        HorizontalListView horizontalListView;
        int i2;
        int i3 = 0;
        i = this.ccq.aXn;
        if (i > 0) {
            i2 = this.ccq.aXn;
            i3 = i2 - 1;
        }
        horizontalListView = this.ccq.cbZ;
        horizontalListView.setSelection(i3);
    }
}
