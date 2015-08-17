package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.adp.base.g {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.cUM = writeActivity;
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
        this.cUM.hideProgressBar();
        if (obj == null || !(obj instanceof o)) {
            feedBackTopListView = this.cUM.cUe;
            feedBackTopListView.setVisibility(8);
            view = this.cUM.cUf;
            view.setVisibility(8);
            this.cUM.showToast(i.C0057i.neterror);
            return;
        }
        o oVar = (o) obj;
        if (oVar.getErrCode() != 0) {
            feedBackTopListView2 = this.cUM.cUe;
            feedBackTopListView2.setVisibility(8);
            view2 = this.cUM.cUf;
            view2.setVisibility(8);
            return;
        }
        ArrayList<com.baidu.tbadk.core.data.v> auJ = oVar.auJ();
        feedBackTopListView3 = this.cUM.cUe;
        feedBackTopListView3.a(auJ, this.cUM.getPageContext());
    }
}
