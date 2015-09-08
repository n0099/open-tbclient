package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity dch;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.dch = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        textView = this.dch.dcc;
        textView.setVisibility(8);
        view2 = this.dch.bKr;
        view2.setVisibility(8);
        view3 = this.dch.bKq;
        view3.setVisibility(0);
        this.dch.bEI.requestFocus();
    }
}
