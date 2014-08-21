package com.baidu.tieba.mention;

import com.baidu.tieba.data.FeedData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements av {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.a = alVar;
    }

    @Override // com.baidu.tieba.mention.av
    public void a(String str) {
        FeedData feedData;
        this.a.m = str;
        al alVar = this.a;
        feedData = this.a.k;
        alVar.a(feedData);
    }
}
