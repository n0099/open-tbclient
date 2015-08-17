package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity cTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.cTk = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        textView = this.cTk.cTf;
        textView.setVisibility(8);
        view2 = this.cTk.bJK;
        view2.setVisibility(8);
        view3 = this.cTk.bJJ;
        view3.setVisibility(0);
        this.cTk.bEb.requestFocus();
    }
}
