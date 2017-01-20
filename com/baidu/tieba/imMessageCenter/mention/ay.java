package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements BdListView.f {
    final /* synthetic */ au dky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(au auVar) {
        this.dky = auVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        ReplyMessageActivity replyMessageActivity;
        replyMessageActivity = this.dky.dkg;
        replyMessageActivity.Jj();
    }
}
