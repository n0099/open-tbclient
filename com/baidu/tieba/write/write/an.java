package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        FeedBackTopListView feedBackTopListView;
        View view;
        FeedBackTopListView feedBackTopListView2;
        View view2;
        FeedBackTopListView feedBackTopListView3;
        this.gpp.hideProgressBar();
        if (obj == null || !(obj instanceof p)) {
            feedBackTopListView = this.gpp.goi;
            feedBackTopListView.setVisibility(8);
            view = this.gpp.goj;
            view.setVisibility(8);
            this.gpp.showToast(r.j.neterror);
            return;
        }
        p pVar = (p) obj;
        if (pVar.getErrCode() != 0) {
            feedBackTopListView2 = this.gpp.goi;
            feedBackTopListView2.setVisibility(8);
            view2 = this.gpp.goj;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.bk> bwb = pVar.bwb();
        feedBackTopListView3 = this.gpp.goi;
        feedBackTopListView3.a(bwb, this.gpp.getPageContext());
    }
}
