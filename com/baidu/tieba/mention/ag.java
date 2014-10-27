package com.baidu.tieba.mention;

import com.baidu.tieba.data.FeedData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements ao {
    final /* synthetic */ ae bnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.bnS = aeVar;
    }

    @Override // com.baidu.tieba.mention.ao
    public void gP(String str) {
        FeedData feedData;
        this.bnS.mForumId = str;
        ae aeVar = this.bnS;
        feedData = this.bnS.bnP;
        aeVar.d(feedData);
    }
}
