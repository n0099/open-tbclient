package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements as.a {
    final /* synthetic */ az dhD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.dhD = azVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.as.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.d.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.d.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.d.p pVar3;
        FeedData feedData3;
        this.dhD.mForumId = String.valueOf(j);
        this.dhD.dhy = j2;
        this.dhD.dhz = j3;
        pVar = this.dhD.dhw;
        if (pVar != null) {
            feedData = this.dhD.dhx;
            if (feedData.getIsFloor()) {
                feedData2 = this.dhD.dhx;
                if (feedData2.getReplyer() != null) {
                    if (this.dhD.dgz != null) {
                        this.dhD.dgz.auu();
                    }
                    pVar3 = this.dhD.dhw;
                    feedData3 = this.dhD.dhx;
                    pVar3.fG(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.dhD.dgz != null) {
                this.dhD.dgz.auu();
            }
            pVar2 = this.dhD.dhw;
            pVar2.fG(null);
        }
    }
}
