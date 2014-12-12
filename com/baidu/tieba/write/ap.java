package com.baidu.tieba.write;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.i {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.WriteActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        FeedBackTopListView feedBackTopListView;
        FeedBackTopListView feedBackTopListView2;
        FeedBackTopListView feedBackTopListView3;
        this.cft.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.cft.ceT;
            feedBackTopListView.setVisibility(8);
            this.cft.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.cft.ceT;
            feedBackTopListView2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.w> ajJ = oVar.ajJ();
        feedBackTopListView3 = this.cft.ceT;
        feedBackTopListView3.a(ajJ, this.cft.getPageContext());
    }
}
