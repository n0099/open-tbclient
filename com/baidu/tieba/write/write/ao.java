package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.ghD = writeActivity;
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
        this.ghD.hideProgressBar();
        if (obj == null || !(obj instanceof p)) {
            feedBackTopListView = this.ghD.ggD;
            feedBackTopListView.setVisibility(8);
            view = this.ghD.ggE;
            view.setVisibility(8);
            this.ghD.showToast(r.j.neterror);
            return;
        }
        p pVar = (p) obj;
        if (pVar.getErrCode() != 0) {
            feedBackTopListView2 = this.ghD.ggD;
            feedBackTopListView2.setVisibility(8);
            view2 = this.ghD.ggE;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.bi> btG = pVar.btG();
        feedBackTopListView3 = this.ghD.ggD;
        feedBackTopListView3.a(btG, this.ghD.getPageContext());
    }
}
