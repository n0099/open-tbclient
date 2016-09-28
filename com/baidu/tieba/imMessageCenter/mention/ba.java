package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements as.a {
    final /* synthetic */ az duF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.duF = azVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.as.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.e.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.e.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.e.p pVar3;
        FeedData feedData3;
        this.duF.mForumId = String.valueOf(j);
        this.duF.duB = j2;
        this.duF.duC = j3;
        pVar = this.duF.duz;
        if (pVar != null) {
            feedData = this.duF.duA;
            if (feedData.getIsFloor()) {
                feedData2 = this.duF.duA;
                if (feedData2.getReplyer() != null) {
                    if (this.duF.dtC != null) {
                        this.duF.dtC.azF();
                    }
                    pVar3 = this.duF.duz;
                    feedData3 = this.duF.duA;
                    pVar3.fN(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.duF.dtC != null) {
                this.duF.dtC.azF();
            }
            pVar2 = this.duF.duz;
            pVar2.fN(null);
        }
    }
}
