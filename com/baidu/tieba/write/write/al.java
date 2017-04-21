package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.base.f {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        FeedBackTopListView feedBackTopListView;
        View view;
        FeedBackTopListView feedBackTopListView2;
        View view2;
        FeedBackTopListView feedBackTopListView3;
        this.fUM.hideProgressBar();
        if (obj == null || !(obj instanceof FeedBackModel)) {
            feedBackTopListView = this.fUM.fTE;
            feedBackTopListView.setVisibility(8);
            view = this.fUM.fTF;
            view.setVisibility(8);
            this.fUM.showToast(w.l.neterror);
            return;
        }
        FeedBackModel feedBackModel = (FeedBackModel) obj;
        if (feedBackModel.getErrCode() != 0) {
            feedBackTopListView2 = this.fUM.fTE;
            feedBackTopListView2.setVisibility(8);
            view2 = this.fUM.fTF;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.bi> bpU = feedBackModel.bpU();
        feedBackTopListView3 = this.fUM.fTE;
        feedBackTopListView3.a(bpU, this.fUM.getPageContext());
    }
}
