package com.baidu.tieba.write.write;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.base.i {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        FeedBackTopListView feedBackTopListView;
        FeedBackTopListView feedBackTopListView2;
        FeedBackTopListView feedBackTopListView3;
        this.cCQ.hideProgressBar();
        if (obj == null || !(obj instanceof t)) {
            feedBackTopListView = this.cCQ.cCo;
            feedBackTopListView.setVisibility(8);
            this.cCQ.showToast(com.baidu.tieba.t.neterror);
            return;
        }
        t tVar = (t) obj;
        if (tVar.getErrCode() != 0) {
            feedBackTopListView2 = this.cCQ.cCo;
            feedBackTopListView2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.w> asS = tVar.asS();
        feedBackTopListView3 = this.cCQ.cCo;
        feedBackTopListView3.a(asS, this.cCQ.getPageContext());
    }
}
