package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements as.a {
    final /* synthetic */ az dti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.dti = azVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.as.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.d.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.d.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.d.p pVar3;
        FeedData feedData3;
        this.dti.mForumId = String.valueOf(j);
        this.dti.dte = j2;
        this.dti.dtf = j3;
        pVar = this.dti.dtc;
        if (pVar != null) {
            feedData = this.dti.dtd;
            if (feedData.getIsFloor()) {
                feedData2 = this.dti.dtd;
                if (feedData2.getReplyer() != null) {
                    if (this.dti.dsf != null) {
                        this.dti.dsf.azh();
                    }
                    pVar3 = this.dti.dtc;
                    feedData3 = this.dti.dtd;
                    pVar3.fJ(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.dti.dsf != null) {
                this.dti.dsf.azh();
            }
            pVar2 = this.dti.dtc;
            pVar2.fJ(null);
        }
    }
}
