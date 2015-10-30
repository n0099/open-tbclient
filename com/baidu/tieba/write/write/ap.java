package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.dqi = writeActivity;
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
        this.dqi.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.dqi.dpu;
            feedBackTopListView.setVisibility(8);
            view = this.dqi.dpv;
            view.setVisibility(8);
            this.dqi.showToast(i.h.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.dqi.dpu;
            feedBackTopListView2.setVisibility(8);
            view2 = this.dqi.dpv;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.w> aCT = oVar.aCT();
        feedBackTopListView3 = this.dqi.dpu;
        feedBackTopListView3.a(aCT, this.dqi.getPageContext());
    }
}
