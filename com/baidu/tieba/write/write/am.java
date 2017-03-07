package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.adp.base.f {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.fQG = writeActivity;
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
        this.fQG.hideProgressBar();
        if (obj == null || !(obj instanceof FeedBackModel)) {
            feedBackTopListView = this.fQG.fPy;
            feedBackTopListView.setVisibility(8);
            view = this.fQG.fPz;
            view.setVisibility(8);
            this.fQG.showToast(w.l.neterror);
            return;
        }
        FeedBackModel feedBackModel = (FeedBackModel) obj;
        if (feedBackModel.getErrCode() != 0) {
            feedBackTopListView2 = this.fQG.fPy;
            feedBackTopListView2.setVisibility(8);
            view2 = this.fQG.fPz;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.bj> bok = feedBackModel.bok();
        feedBackTopListView3 = this.fQG.fPy;
        feedBackTopListView3.a(bok, this.fQG.getPageContext());
    }
}
