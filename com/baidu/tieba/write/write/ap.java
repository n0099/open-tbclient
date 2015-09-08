package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
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
        this.ddQ.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.ddQ.ddb;
            feedBackTopListView.setVisibility(8);
            view = this.ddQ.ddc;
            view.setVisibility(8);
            this.ddQ.showToast(i.h.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.ddQ.ddb;
            feedBackTopListView2.setVisibility(8);
            view2 = this.ddQ.ddc;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.x> azh = oVar.azh();
        feedBackTopListView3 = this.ddQ.ddb;
        feedBackTopListView3.a(azh, this.ddQ.getPageContext());
    }
}
