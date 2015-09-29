package com.baidu.tieba.mention;

import com.baidu.tieba.mention.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements af.a {
    final /* synthetic */ al caO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.caO = alVar;
    }

    @Override // com.baidu.tieba.mention.af.a
    public void d(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.c.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.c.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.c.n nVar3;
        FeedData feedData3;
        this.caO.mForumId = String.valueOf(j);
        this.caO.caL = j2;
        this.caO.caM = j3;
        nVar = this.caO.caJ;
        if (nVar != null) {
            feedData = this.caO.caK;
            if (feedData.getIsFloor()) {
                feedData2 = this.caO.caK;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.caO.caJ;
                    feedData3 = this.caO.caK;
                    nVar3.fe(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.caO.caJ;
            nVar2.fe(null);
        }
    }
}
