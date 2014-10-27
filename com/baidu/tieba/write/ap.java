package com.baidu.tieba.write;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.h {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        FeedBackTopListView feedBackTopListView;
        FeedBackTopListView feedBackTopListView2;
        FeedBackTopListView feedBackTopListView3;
        this.bTX.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.bTX.bTx;
            feedBackTopListView.setVisibility(8);
            this.bTX.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.bTX.bTx;
            feedBackTopListView2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.q> afc = oVar.afc();
        feedBackTopListView3 = this.bTX.bTx;
        feedBackTopListView3.setData(afc);
    }
}
