package com.baidu.tieba.write;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.i {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.WriteActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        FeedBackTopListView feedBackTopListView;
        FeedBackTopListView feedBackTopListView2;
        FeedBackTopListView feedBackTopListView3;
        this.cgS.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.cgS.cgs;
            feedBackTopListView.setVisibility(8);
            this.cgS.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.cgS.cgs;
            feedBackTopListView2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.x> akg = oVar.akg();
        feedBackTopListView3 = this.cgS.cgs;
        feedBackTopListView3.a(akg, this.cgS.getPageContext());
    }
}
