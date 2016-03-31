package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.eNd = writeActivity;
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
        this.eNd.hideProgressBar();
        if (obj == null || !(obj instanceof p)) {
            feedBackTopListView = this.eNd.eMp;
            feedBackTopListView.setVisibility(8);
            view = this.eNd.eMq;
            view.setVisibility(8);
            this.eNd.showToast(t.j.neterror);
            return;
        }
        p pVar = (p) obj;
        if (pVar.getErrCode() != 0) {
            feedBackTopListView2 = this.eNd.eMp;
            feedBackTopListView2.setVisibility(8);
            view2 = this.eNd.eMq;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.as> bba = pVar.bba();
        feedBackTopListView3 = this.eNd.eMp;
        feedBackTopListView3.a(bba, this.eNd.getPageContext());
    }
}
