package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.HorizontalListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ j ccp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(j jVar) {
        this.ccp = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        HorizontalListView horizontalListView;
        int i2;
        int i3 = 0;
        i = this.ccp.aXm;
        if (i > 0) {
            i2 = this.ccp.aXm;
            i3 = i2 - 1;
        }
        horizontalListView = this.ccp.cbY;
        horizontalListView.setSelection(i3);
    }
}
