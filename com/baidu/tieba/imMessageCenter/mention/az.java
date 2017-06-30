package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class az implements BdListView.f {
    final /* synthetic */ av dve;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(av avVar) {
        this.dve = avVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        ReplyMessageActivity replyMessageActivity;
        replyMessageActivity = this.dve.duN;
        replyMessageActivity.Nu();
    }
}
