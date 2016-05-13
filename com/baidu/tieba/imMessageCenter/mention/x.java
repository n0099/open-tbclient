package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.f {
    final /* synthetic */ w cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.cyx = wVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void t(BdListView bdListView) {
        if (this.cyx instanceof j) {
            this.cyx.cyh.alB().KO();
        } else {
            this.cyx.cyh.alA().KO();
        }
    }
}
