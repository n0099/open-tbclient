package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tieba.imMessageCenter.mention.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements ar.a {
    final /* synthetic */ ay cyj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.cyj = ayVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.ar.a
    public void b(long j, long j2, long j3) {
        com.baidu.tbadk.editortools.d.p pVar;
        FeedData feedData;
        com.baidu.tbadk.editortools.d.p pVar2;
        FeedData feedData2;
        com.baidu.tbadk.editortools.d.p pVar3;
        FeedData feedData3;
        this.cyj.mForumId = String.valueOf(j);
        this.cyj.cyg = j2;
        this.cyj.cyh = j3;
        pVar = this.cyj.cye;
        if (pVar != null) {
            feedData = this.cyj.cyf;
            if (feedData.getIsFloor()) {
                feedData2 = this.cyj.cyf;
                if (feedData2.getReplyer() != null) {
                    if (this.cyj.cxj != null) {
                        this.cyj.cxj.alm();
                    }
                    pVar3 = this.cyj.cye;
                    feedData3 = this.cyj.cyf;
                    pVar3.fF(feedData3.getReplyer().getUserName());
                    return;
                }
            }
            if (this.cyj.cxj != null) {
                this.cyj.cxj.alm();
            }
            pVar2 = this.cyj.cye;
            pVar2.fF(null);
        }
    }
}
