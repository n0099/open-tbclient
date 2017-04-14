package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.base.f {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        FeedBackTopListView feedBackTopListView;
        View view;
        FeedBackTopListView feedBackTopListView2;
        View view2;
        FeedBackTopListView feedBackTopListView3;
        this.fSq.hideProgressBar();
        if (obj == null || !(obj instanceof FeedBackModel)) {
            feedBackTopListView = this.fSq.fRi;
            feedBackTopListView.setVisibility(8);
            view = this.fSq.fRj;
            view.setVisibility(8);
            this.fSq.showToast(w.l.neterror);
            return;
        }
        FeedBackModel feedBackModel = (FeedBackModel) obj;
        if (feedBackModel.getErrCode() != 0) {
            feedBackTopListView2 = this.fSq.fRi;
            feedBackTopListView2.setVisibility(8);
            view2 = this.fSq.fRj;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.bi> boT = feedBackModel.boT();
        feedBackTopListView3 = this.fSq.fRi;
        feedBackTopListView3.a(boT, this.fSq.getPageContext());
    }
}
