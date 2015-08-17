package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity cTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.cTk = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.cTk.bJJ;
        if (view2 != null) {
            view3 = this.cTk.bJJ;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.c(this.cTk.getPageContext().getPageActivity(), this.cTk.bEb);
                view4 = this.cTk.bJJ;
                view4.setVisibility(8);
                textView = this.cTk.cTf;
                textView.setVisibility(0);
                view5 = this.cTk.bJK;
                view5.setVisibility(0);
                this.cTk.bEb.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.c(this.cTk.getPageContext().getPageActivity(), this.cTk.bEb);
        this.cTk.finish();
    }
}
