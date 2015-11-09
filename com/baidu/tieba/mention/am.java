package com.baidu.tieba.mention;

import com.baidu.tieba.mention.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements af.a {
    final /* synthetic */ al cbA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.cbA = alVar;
    }

    @Override // com.baidu.tieba.mention.af.a
    public void d(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.c.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.c.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.c.p pVar3;
        FeedData feedData3;
        this.cbA.mForumId = String.valueOf(j);
        this.cbA.cbx = j2;
        this.cbA.cby = j3;
        pVar = this.cbA.cbv;
        if (pVar != null) {
            feedData = this.cbA.cbw;
            if (feedData.getIsFloor()) {
                feedData2 = this.cbA.cbw;
                if (feedData2.getReplyer() != null) {
                    pVar3 = this.cbA.cbv;
                    feedData3 = this.cbA.cbw;
                    pVar3.fg(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            pVar2 = this.cbA.cbv;
            pVar2.fg(null);
        }
    }
}
