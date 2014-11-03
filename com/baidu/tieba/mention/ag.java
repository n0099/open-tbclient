package com.baidu.tieba.mention;

import com.baidu.tieba.data.FeedData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements ao {
    final /* synthetic */ ae bog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.bog = aeVar;
    }

    @Override // com.baidu.tieba.mention.ao
    public void gP(String str) {
        FeedData feedData;
        this.bog.mForumId = str;
        ae aeVar = this.bog;
        feedData = this.bog.bod;
        aeVar.d(feedData);
    }
}
