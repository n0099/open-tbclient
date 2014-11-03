package com.baidu.tieba.write;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.h {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        FeedBackTopListView feedBackTopListView;
        FeedBackTopListView feedBackTopListView2;
        FeedBackTopListView feedBackTopListView3;
        this.bUm.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.bUm.bTM;
            feedBackTopListView.setVisibility(8);
            this.bUm.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.bUm.bTM;
            feedBackTopListView2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.q> aff = oVar.aff();
        feedBackTopListView3 = this.bUm.bTM;
        feedBackTopListView3.setData(aff);
    }
}
