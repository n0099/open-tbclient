package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
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
        this.fDQ.hideProgressBar();
        if (obj == null || !(obj instanceof p)) {
            feedBackTopListView = this.fDQ.fCK;
            feedBackTopListView.setVisibility(8);
            view = this.fDQ.fCL;
            view.setVisibility(8);
            this.fDQ.showToast(r.j.neterror);
            return;
        }
        p pVar = (p) obj;
        if (pVar.getErrCode() != 0) {
            feedBackTopListView2 = this.fDQ.fCK;
            feedBackTopListView2.setVisibility(8);
            view2 = this.fDQ.fCL;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.bg> bmZ = pVar.bmZ();
        feedBackTopListView3 = this.fDQ.fCK;
        feedBackTopListView3.a(bmZ, this.fDQ.getPageContext());
    }
}
