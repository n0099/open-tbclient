package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ad {
    final /* synthetic */ ai bGE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.bGE = aiVar;
    }

    @Override // com.baidu.tieba.mention.ad
    public void a(long j, long j2, long j3) {
        FeedData feedData;
        this.bGE.mForumId = String.valueOf(j);
        this.bGE.bGz = j2;
        this.bGE.bGA = j3;
        ai aiVar = this.bGE;
        feedData = this.bGE.bGy;
        aiVar.c(feedData);
    }
}
