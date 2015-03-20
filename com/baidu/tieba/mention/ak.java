package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ad {
    final /* synthetic */ ai bDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.bDw = aiVar;
    }

    @Override // com.baidu.tieba.mention.ad
    public void a(long j, long j2, long j3) {
        FeedData feedData;
        this.bDw.mForumId = String.valueOf(j);
        this.bDw.bDr = j2;
        this.bDw.bDs = j3;
        ai aiVar = this.bDw;
        feedData = this.bDw.bDq;
        aiVar.c(feedData);
    }
}
