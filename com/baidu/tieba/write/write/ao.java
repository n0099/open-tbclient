package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.gfs = writeActivity;
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
        this.gfs.hideProgressBar();
        if (obj == null || !(obj instanceof p)) {
            feedBackTopListView = this.gfs.ges;
            feedBackTopListView.setVisibility(8);
            view = this.gfs.get;
            view.setVisibility(8);
            this.gfs.showToast(t.j.neterror);
            return;
        }
        p pVar = (p) obj;
        if (pVar.getErrCode() != 0) {
            feedBackTopListView2 = this.gfs.ges;
            feedBackTopListView2.setVisibility(8);
            view2 = this.gfs.get;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.bg> bta = pVar.bta();
        feedBackTopListView3 = this.gfs.ges;
        feedBackTopListView3.a(bta, this.gfs.getPageContext());
    }
}
