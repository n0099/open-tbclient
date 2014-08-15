package com.baidu.tieba.mention;

import com.baidu.tieba.data.FeedData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements ay {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(an anVar) {
        this.a = anVar;
    }

    @Override // com.baidu.tieba.mention.ay
    public void a(String str) {
        FeedData feedData;
        this.a.m = str;
        an anVar = this.a;
        feedData = this.a.k;
        anVar.a(feedData);
    }
}
