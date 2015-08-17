package com.baidu.tieba.mention;

import com.baidu.tieba.mention.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements ae.a {
    final /* synthetic */ ak bWv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.bWv = akVar;
    }

    @Override // com.baidu.tieba.mention.ae.a
    public void d(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.c.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.c.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.c.n nVar3;
        FeedData feedData3;
        this.bWv.mForumId = String.valueOf(j);
        this.bWv.bWr = j2;
        this.bWv.bWs = j3;
        nVar = this.bWv.bWp;
        if (nVar != null) {
            feedData = this.bWv.bWq;
            if (feedData.getIsFloor()) {
                feedData2 = this.bWv.bWq;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.bWv.bWp;
                    feedData3 = this.bWv.bWq;
                    nVar3.eR(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.bWv.bWp;
            nVar2.eR(null);
        }
    }
}
