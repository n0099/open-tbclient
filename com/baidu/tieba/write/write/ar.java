package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.dsa = writeActivity;
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
        this.dsa.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.dsa.dri;
            feedBackTopListView.setVisibility(8);
            view = this.dsa.drj;
            view.setVisibility(8);
            this.dsa.showToast(i.h.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.dsa.dri;
            feedBackTopListView2.setVisibility(8);
            view2 = this.dsa.drj;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.w> aDL = oVar.aDL();
        feedBackTopListView3 = this.dsa.dri;
        feedBackTopListView3.a(aDL, this.dsa.getPageContext());
    }
}
