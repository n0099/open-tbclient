package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.feb = writeActivity;
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
        this.feb.hideProgressBar();
        if (obj == null || !(obj instanceof p)) {
            feedBackTopListView = this.feb.fdd;
            feedBackTopListView.setVisibility(8);
            view = this.feb.fde;
            view.setVisibility(8);
            this.feb.showToast(t.j.neterror);
            return;
        }
        p pVar = (p) obj;
        if (pVar.getErrCode() != 0) {
            feedBackTopListView2 = this.feb.fdd;
            feedBackTopListView2.setVisibility(8);
            view2 = this.feb.fde;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.ax> bdn = pVar.bdn();
        feedBackTopListView3 = this.feb.fdd;
        feedBackTopListView3.a(bdn, this.feb.getPageContext());
    }
}
