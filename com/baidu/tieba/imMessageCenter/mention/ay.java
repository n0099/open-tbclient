package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements aq.a {
    final /* synthetic */ ax cjh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.cjh = axVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.aq.a
    public void c(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.d.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.d.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.d.p pVar3;
        FeedData feedData3;
        this.cjh.mForumId = String.valueOf(j);
        this.cjh.cje = j2;
        this.cjh.cjf = j3;
        pVar = this.cjh.cjc;
        if (pVar != null) {
            feedData = this.cjh.cjd;
            if (feedData.getIsFloor()) {
                feedData2 = this.cjh.cjd;
                if (feedData2.getReplyer() != null) {
                    if (this.cjh.cih != null) {
                        this.cjh.cih.aeJ();
                    }
                    pVar3 = this.cjh.cjc;
                    feedData3 = this.cjh.cjd;
                    pVar3.fz(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.cjh.cih != null) {
                this.cjh.cih.aeJ();
            }
            pVar2 = this.cjh.cjc;
            pVar2.fz(null);
        }
    }
}
