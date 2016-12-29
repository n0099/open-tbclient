package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements au.a {
    final /* synthetic */ bb ddm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.ddm = bbVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.au.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.e.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.e.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.e.p pVar3;
        FeedData feedData3;
        this.ddm.mForumId = String.valueOf(j);
        this.ddm.ddi = j2;
        this.ddm.ddj = j3;
        pVar = this.ddm.ddg;
        if (pVar != null) {
            feedData = this.ddm.ddh;
            if (feedData.getIsFloor()) {
                feedData2 = this.ddm.ddh;
                if (feedData2.getReplyer() != null) {
                    pVar3 = this.ddm.ddg;
                    feedData3 = this.ddm.ddh;
                    pVar3.fM(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            pVar2 = this.ddm.ddg;
            pVar2.fM(null);
        }
    }
}
