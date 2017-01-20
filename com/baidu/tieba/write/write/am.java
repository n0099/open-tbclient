package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.adp.base.f {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.fMl = writeActivity;
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
        this.fMl.hideProgressBar();
        if (obj == null || !(obj instanceof FeedBackModel)) {
            feedBackTopListView = this.fMl.fLf;
            feedBackTopListView.setVisibility(8);
            view = this.fMl.fLg;
            view.setVisibility(8);
            this.fMl.showToast(r.l.neterror);
            return;
        }
        FeedBackModel feedBackModel = (FeedBackModel) obj;
        if (feedBackModel.getErrCode() != 0) {
            feedBackTopListView2 = this.fMl.fLf;
            feedBackTopListView2.setVisibility(8);
            view2 = this.fMl.fLg;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.bh> box = feedBackModel.box();
        feedBackTopListView3 = this.fMl.fLf;
        feedBackTopListView3.a(box, this.fMl.getPageContext());
    }
}
