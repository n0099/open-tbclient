package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        FeedBackTopListView feedBackTopListView;
        View view;
        FeedBackTopListView feedBackTopListView2;
        View view2;
        FeedBackTopListView feedBackTopListView3;
        this.fea.hideProgressBar();
        if (obj == null || !(obj instanceof p)) {
            feedBackTopListView = this.fea.fdc;
            feedBackTopListView.setVisibility(8);
            view = this.fea.fdd;
            view.setVisibility(8);
            this.fea.showToast(t.j.neterror);
            return;
        }
        p pVar = (p) obj;
        if (pVar.getErrCode() != 0) {
            feedBackTopListView2 = this.fea.fdc;
            feedBackTopListView2.setVisibility(8);
            view2 = this.fea.fdd;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.ax> bdu = pVar.bdu();
        feedBackTopListView3 = this.fea.fdc;
        feedBackTopListView3.a(bdu, this.fea.getPageContext());
    }
}
