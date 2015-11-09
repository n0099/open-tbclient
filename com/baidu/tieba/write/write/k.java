package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.dqn = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.dqn.bOb;
        if (view2 != null) {
            view3 = this.dqn.bOb;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.c(this.dqn.getPageContext().getPageActivity(), this.dqn.bIr);
                view4 = this.dqn.bOb;
                view4.setVisibility(8);
                textView = this.dqn.dqi;
                textView.setVisibility(0);
                view5 = this.dqn.bOc;
                view5.setVisibility(0);
                this.dqn.bIr.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.c(this.dqn.getPageContext().getPageActivity(), this.dqn.bIr);
        this.dqn.finish();
    }
}
