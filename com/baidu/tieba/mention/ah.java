package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements aa {
    final /* synthetic */ af bsE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.bsE = afVar;
    }

    @Override // com.baidu.tieba.mention.aa
    public void b(long j, long j2, long j3) {
        FeedData feedData;
        this.bsE.mForumId = String.valueOf(j);
        this.bsE.bsz = j2;
        this.bsE.bsA = j3;
        af afVar = this.bsE;
        feedData = this.bsE.bsy;
        afVar.c(feedData);
    }
}
