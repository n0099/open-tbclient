package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.dqn = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        textView = this.dqn.dqi;
        textView.setVisibility(8);
        view2 = this.dqn.bOc;
        view2.setVisibility(8);
        view3 = this.dqn.bOb;
        view3.setVisibility(0);
        this.dqn.bIr.requestFocus();
    }
}
