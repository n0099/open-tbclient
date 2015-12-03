package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity dPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.dPq = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.dPq.cde;
        if (view2 != null) {
            view3 = this.dPq.cde;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.c(this.dPq.getPageContext().getPageActivity(), this.dPq.bXx);
                view4 = this.dPq.cde;
                view4.setVisibility(8);
                textView = this.dPq.dPl;
                textView.setVisibility(0);
                view5 = this.dPq.cdf;
                view5.setVisibility(0);
                this.dPq.bXx.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.c(this.dPq.getPageContext().getPageActivity(), this.dPq.bXx);
        this.dPq.finish();
    }
}
