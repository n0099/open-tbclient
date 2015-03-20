package com.baidu.tieba.write.write;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.i {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        FeedBackTopListView feedBackTopListView;
        FeedBackTopListView feedBackTopListView2;
        FeedBackTopListView feedBackTopListView3;
        this.cyc.hideProgressBar();
        if (obj == null || !(obj instanceof s)) {
            feedBackTopListView = this.cyc.cxC;
            feedBackTopListView.setVisibility(8);
            this.cyc.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        s sVar = (s) obj;
        if (sVar.getErrCode() != 0) {
            feedBackTopListView2 = this.cyc.cxC;
            feedBackTopListView2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.w> aqM = sVar.aqM();
        feedBackTopListView3 = this.cyc.cxC;
        feedBackTopListView3.a(aqM, this.cyc.getPageContext());
    }
}
