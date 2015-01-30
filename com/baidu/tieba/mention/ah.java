package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements aa {
    final /* synthetic */ af bub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.bub = afVar;
    }

    @Override // com.baidu.tieba.mention.aa
    public void a(long j, long j2, long j3) {
        FeedData feedData;
        this.bub.mForumId = String.valueOf(j);
        this.bub.btW = j2;
        this.bub.btX = j3;
        af afVar = this.bub;
        feedData = this.bub.btV;
        afVar.c(feedData);
    }
}
