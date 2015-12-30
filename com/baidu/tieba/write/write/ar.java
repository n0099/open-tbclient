package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.dYD = writeActivity;
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
        this.dYD.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.dYD.dXL;
            feedBackTopListView.setVisibility(8);
            view = this.dYD.dXM;
            view.setVisibility(8);
            this.dYD.showToast(n.j.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.dYD.dXL;
            feedBackTopListView2.setVisibility(8);
            view2 = this.dYD.dXM;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.z> aLD = oVar.aLD();
        feedBackTopListView3 = this.dYD.dXL;
        feedBackTopListView3.a(aLD, this.dYD.getPageContext());
    }
}
