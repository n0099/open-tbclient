package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i implements BdListView.f {
    final /* synthetic */ g duc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.duc = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        AtMessageActivity atMessageActivity;
        atMessageActivity = this.duc.dtS;
        atMessageActivity.Nu();
    }
}
