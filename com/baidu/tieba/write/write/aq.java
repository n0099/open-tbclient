package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.f {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.fSV = writeActivity;
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
        this.fSV.hideProgressBar();
        if (obj == null || !(obj instanceof FeedBackModel)) {
            feedBackTopListView = this.fSV.fRI;
            feedBackTopListView.setVisibility(8);
            view = this.fSV.fRJ;
            view.setVisibility(8);
            this.fSV.showToast(w.l.neterror);
            return;
        }
        FeedBackModel feedBackModel = (FeedBackModel) obj;
        if (feedBackModel.getErrCode() != 0) {
            feedBackTopListView2 = this.fSV.fRI;
            feedBackTopListView2.setVisibility(8);
            view2 = this.fSV.fRJ;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.bk> bnW = feedBackModel.bnW();
        feedBackTopListView3 = this.fSV.fRI;
        feedBackTopListView3.a(bnW, this.fSV.getPageContext());
    }
}
