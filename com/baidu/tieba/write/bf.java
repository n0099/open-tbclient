package com.baidu.tieba.write;

import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.a.g {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        FeedBackTopListView feedBackTopListView;
        FeedBackTopListView feedBackTopListView2;
        FeedBackTopListView feedBackTopListView3;
        this.a.hideProgressBar();
        if (obj == null || !(obj instanceof s)) {
            feedBackTopListView = this.a.m;
            feedBackTopListView.setVisibility(8);
            this.a.showToast(R.string.neterror);
            return;
        }
        s sVar = (s) obj;
        if (sVar.b() != 0) {
            feedBackTopListView2 = this.a.m;
            feedBackTopListView2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tieba.data.az> a = sVar.a();
        feedBackTopListView3 = this.a.m;
        feedBackTopListView3.setData(a);
    }
}
