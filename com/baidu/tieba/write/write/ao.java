package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.fJw = writeActivity;
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
        this.fJw.hideProgressBar();
        if (obj == null || !(obj instanceof p)) {
            feedBackTopListView = this.fJw.fIw;
            feedBackTopListView.setVisibility(8);
            view = this.fJw.fIx;
            view.setVisibility(8);
            this.fJw.showToast(u.j.neterror);
            return;
        }
        p pVar = (p) obj;
        if (pVar.getErrCode() != 0) {
            feedBackTopListView2 = this.fJw.fIw;
            feedBackTopListView2.setVisibility(8);
            view2 = this.fJw.fIx;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.az> blQ = pVar.blQ();
        feedBackTopListView3 = this.fJw.fIw;
        feedBackTopListView3.a(blQ, this.fJw.getPageContext());
    }
}
