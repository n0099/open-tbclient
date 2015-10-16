package com.baidu.tieba.mention;

import com.baidu.tieba.mention.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements af.a {
    final /* synthetic */ al caZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.caZ = alVar;
    }

    @Override // com.baidu.tieba.mention.af.a
    public void d(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.c.n nVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.c.n nVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.c.n nVar3;
        FeedData feedData3;
        this.caZ.mForumId = String.valueOf(j);
        this.caZ.caW = j2;
        this.caZ.caX = j3;
        nVar = this.caZ.caU;
        if (nVar != null) {
            feedData = this.caZ.caV;
            if (feedData.getIsFloor()) {
                feedData2 = this.caZ.caV;
                if (feedData2.getReplyer() != null) {
                    nVar3 = this.caZ.caU;
                    feedData3 = this.caZ.caV;
                    nVar3.fe(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            nVar2 = this.caZ.caU;
            nVar2.fe(null);
        }
    }
}
