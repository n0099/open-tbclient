package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements aq.a {
    final /* synthetic */ ax cnH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.cnH = axVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.aq.a
    public void c(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.d.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.d.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.d.p pVar3;
        FeedData feedData3;
        this.cnH.mForumId = String.valueOf(j);
        this.cnH.cnE = j2;
        this.cnH.cnF = j3;
        pVar = this.cnH.cnC;
        if (pVar != null) {
            feedData = this.cnH.cnD;
            if (feedData.getIsFloor()) {
                feedData2 = this.cnH.cnD;
                if (feedData2.getReplyer() != null) {
                    if (this.cnH.cmH != null) {
                        this.cnH.cmH.ahS();
                    }
                    pVar3 = this.cnH.cnC;
                    feedData3 = this.cnH.cnD;
                    pVar3.fx(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.cnH.cmH != null) {
                this.cnH.cmH.ahS();
            }
            pVar2 = this.cnH.cnC;
            pVar2.fx(null);
        }
    }
}
