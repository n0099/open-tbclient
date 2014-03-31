package com.baidu.tieba.write;

import java.util.ArrayList;
/* loaded from: classes.dex */
final class bc extends com.baidu.adp.a.h {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        FeedBackTopListView feedBackTopListView;
        FeedBackTopListView feedBackTopListView2;
        FeedBackTopListView feedBackTopListView3;
        this.a.hideProgressBar();
        if (obj == null || !(obj instanceof s)) {
            feedBackTopListView = this.a.k;
            feedBackTopListView.setVisibility(8);
            this.a.showToast(com.baidu.tieba.a.k.neterror);
            return;
        }
        s sVar = (s) obj;
        if (sVar.b() != 0) {
            feedBackTopListView2 = this.a.k;
            feedBackTopListView2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.o> a = sVar.a();
        feedBackTopListView3 = this.a.k;
        feedBackTopListView3.setData(a);
    }
}
