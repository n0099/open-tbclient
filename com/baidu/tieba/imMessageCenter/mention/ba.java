package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements as.a {
    final /* synthetic */ az czi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.czi = azVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.as.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.d.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.d.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.d.p pVar3;
        FeedData feedData3;
        this.czi.mForumId = String.valueOf(j);
        this.czi.czf = j2;
        this.czi.czg = j3;
        pVar = this.czi.czd;
        if (pVar != null) {
            feedData = this.czi.cze;
            if (feedData.getIsFloor()) {
                feedData2 = this.czi.cze;
                if (feedData2.getReplyer() != null) {
                    if (this.czi.cyh != null) {
                        this.czi.cyh.alv();
                    }
                    pVar3 = this.czi.czd;
                    feedData3 = this.czi.cze;
                    pVar3.fC(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.czi.cyh != null) {
                this.czi.cyh.alv();
            }
            pVar2 = this.czi.czd;
            pVar2.fC(null);
        }
    }
}
