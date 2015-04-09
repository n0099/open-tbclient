package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ad {
    final /* synthetic */ ai bDJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.bDJ = aiVar;
    }

    @Override // com.baidu.tieba.mention.ad
    public void a(long j, long j2, long j3) {
        FeedData feedData;
        this.bDJ.mForumId = String.valueOf(j);
        this.bDJ.bDE = j2;
        this.bDJ.bDF = j3;
        ai aiVar = this.bDJ;
        feedData = this.bDJ.bDD;
        aiVar.c(feedData);
    }
}
