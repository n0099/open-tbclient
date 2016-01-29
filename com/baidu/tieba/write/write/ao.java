package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.ets = writeActivity;
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
        this.ets.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.ets.esE;
            feedBackTopListView.setVisibility(8);
            view = this.ets.esF;
            view.setVisibility(8);
            this.ets.showToast(t.j.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.ets.esE;
            feedBackTopListView2.setVisibility(8);
            view2 = this.ets.esF;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.ah> aUy = oVar.aUy();
        feedBackTopListView3 = this.ets.esE;
        feedBackTopListView3.a(aUy, this.ets.getPageContext());
    }
}
