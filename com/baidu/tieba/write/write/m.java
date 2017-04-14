package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ AtListActivity fQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtListActivity atListActivity) {
        this.fQD = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        textView = this.fQD.fQz;
        textView.setVisibility(8);
        view2 = this.fQD.djg;
        view2.setVisibility(8);
        view3 = this.fQD.djf;
        view3.setVisibility(0);
        this.fQD.dfv.requestFocus();
    }
}
