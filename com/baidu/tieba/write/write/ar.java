package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.dRf = writeActivity;
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
        this.dRf.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.dRf.dQn;
            feedBackTopListView.setVisibility(8);
            view = this.dRf.dQo;
            view.setVisibility(8);
            this.dRf.showToast(n.i.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.dRf.dQn;
            feedBackTopListView2.setVisibility(8);
            view2 = this.dRf.dQo;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.z> aJi = oVar.aJi();
        feedBackTopListView3 = this.dRf.dQn;
        feedBackTopListView3.a(aJi, this.dRf.getPageContext());
    }
}
