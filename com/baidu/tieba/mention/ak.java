package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ad {
    final /* synthetic */ ai bGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.bGF = aiVar;
    }

    @Override // com.baidu.tieba.mention.ad
    public void a(long j, long j2, long j3) {
        FeedData feedData;
        this.bGF.mForumId = String.valueOf(j);
        this.bGF.bGA = j2;
        this.bGF.bGB = j3;
        ai aiVar = this.bGF;
        feedData = this.bGF.bGz;
        aiVar.c(feedData);
    }
}
