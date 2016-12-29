package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements BdListView.f {
    final /* synthetic */ j dck;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.dck = jVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void t(BdListView bdListView) {
        AtMessageActivity atMessageActivity;
        atMessageActivity = this.dck.dcb;
        atMessageActivity.IV();
    }
}
