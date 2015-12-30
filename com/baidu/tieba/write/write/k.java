package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.dWP = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.dWP.che;
        if (view2 != null) {
            view3 = this.dWP.che;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.c(this.dWP.getPageContext().getPageActivity(), this.dWP.cbx);
                view4 = this.dWP.che;
                view4.setVisibility(8);
                textView = this.dWP.dWK;
                textView.setVisibility(0);
                view5 = this.dWP.chf;
                view5.setVisibility(0);
                this.dWP.cbx.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.c(this.dWP.getPageContext().getPageActivity(), this.dWP.cbx);
        this.dWP.finish();
    }
}
