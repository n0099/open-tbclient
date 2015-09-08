package com.baidu.tieba.mention;

import com.baidu.tieba.mention.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements ae.a {
    final /* synthetic */ ak bXb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.bXb = akVar;
    }

    @Override // com.baidu.tieba.mention.ae.a
    public void d(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.c.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.c.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.c.n nVar3;
        FeedData feedData3;
        this.bXb.mForumId = String.valueOf(j);
        this.bXb.bWX = j2;
        this.bXb.bWY = j3;
        nVar = this.bXb.bWV;
        if (nVar != null) {
            feedData = this.bXb.bWW;
            if (feedData.getIsFloor()) {
                feedData2 = this.bXb.bWW;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.bXb.bWV;
                    feedData3 = this.bXb.bWW;
                    nVar3.eZ(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.bXb.bWV;
            nVar2.eZ(null);
        }
    }
}
