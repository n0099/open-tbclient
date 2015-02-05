package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements aa {
    final /* synthetic */ af bua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.bua = afVar;
    }

    @Override // com.baidu.tieba.mention.aa
    public void a(long j, long j2, long j3) {
        FeedData feedData;
        this.bua.mForumId = String.valueOf(j);
        this.bua.btV = j2;
        this.bua.btW = j3;
        af afVar = this.bua;
        feedData = this.bua.btU;
        afVar.c(feedData);
    }
}
