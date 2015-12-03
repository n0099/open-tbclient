package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements ap.a {
    final /* synthetic */ aw cfd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar) {
        this.cfd = awVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.ap.a
    public void c(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.d.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.d.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.d.p pVar3;
        FeedData feedData3;
        this.cfd.mForumId = String.valueOf(j);
        this.cfd.cfa = j2;
        this.cfd.cfb = j3;
        pVar = this.cfd.ceY;
        if (pVar != null) {
            feedData = this.cfd.ceZ;
            if (feedData.getIsFloor()) {
                feedData2 = this.cfd.ceZ;
                if (feedData2.getReplyer() != null) {
                    if (this.cfd.ceg != null) {
                        this.cfd.ceg.adB();
                    }
                    pVar3 = this.cfd.ceY;
                    feedData3 = this.cfd.ceZ;
                    pVar3.fv(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.cfd.ceg != null) {
                this.cfd.ceg.adB();
            }
            pVar2 = this.cfd.ceY;
            pVar2.fv(null);
        }
    }
}
