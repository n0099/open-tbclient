package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements BdListView.f {
    final /* synthetic */ bb ddm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bb bbVar) {
        this.ddm = bbVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void t(BdListView bdListView) {
        ReplyMessageActivity replyMessageActivity;
        replyMessageActivity = this.ddm.dcV;
        replyMessageActivity.IV();
    }
}
