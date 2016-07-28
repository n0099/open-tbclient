package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.fVn = writeActivity;
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
        this.fVn.hideProgressBar();
        if (obj == null || !(obj instanceof p)) {
            feedBackTopListView = this.fVn.fUn;
            feedBackTopListView.setVisibility(8);
            view = this.fVn.fUo;
            view.setVisibility(8);
            this.fVn.showToast(u.j.neterror);
            return;
        }
        p pVar = (p) obj;
        if (pVar.getErrCode() != 0) {
            feedBackTopListView2 = this.fVn.fUn;
            feedBackTopListView2.setVisibility(8);
            view2 = this.fVn.fUo;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.be> boL = pVar.boL();
        feedBackTopListView3 = this.fVn.fUn;
        feedBackTopListView3.a(boL, this.fVn.getPageContext());
    }
}
