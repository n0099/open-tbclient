package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements as.a {
    final /* synthetic */ az dAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.dAk = azVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.as.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.e.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.e.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.e.p pVar3;
        FeedData feedData3;
        this.dAk.mForumId = String.valueOf(j);
        this.dAk.dAg = j2;
        this.dAk.dAh = j3;
        pVar = this.dAk.dAe;
        if (pVar != null) {
            feedData = this.dAk.dAf;
            if (feedData.getIsFloor()) {
                feedData2 = this.dAk.dAf;
                if (feedData2.getReplyer() != null) {
                    if (this.dAk.dzh != null) {
                        this.dAk.dzh.aBB();
                    }
                    pVar3 = this.dAk.dAe;
                    feedData3 = this.dAk.dAf;
                    pVar3.fQ(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.dAk.dzh != null) {
                this.dAk.dzh.aBB();
            }
            pVar2 = this.dAk.dAe;
            pVar2.fQ(null);
        }
    }
}
