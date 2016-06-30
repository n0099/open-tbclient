package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements as.a {
    final /* synthetic */ az deF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.deF = azVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.as.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.d.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.d.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.d.p pVar3;
        FeedData feedData3;
        this.deF.mForumId = String.valueOf(j);
        this.deF.deC = j2;
        this.deF.deD = j3;
        pVar = this.deF.deA;
        if (pVar != null) {
            feedData = this.deF.deB;
            if (feedData.getIsFloor()) {
                feedData2 = this.deF.deB;
                if (feedData2.getReplyer() != null) {
                    if (this.deF.ddD != null) {
                        this.deF.ddD.atI();
                    }
                    pVar3 = this.deF.deA;
                    feedData3 = this.deF.deB;
                    pVar3.fI(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.deF.ddD != null) {
                this.deF.ddD.atI();
            }
            pVar2 = this.deF.deA;
            pVar2.fI(null);
        }
    }
}
