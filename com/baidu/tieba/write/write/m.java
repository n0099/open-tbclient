package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ AtListActivity fcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtListActivity atListActivity) {
        this.fcp = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        textView = this.fcp.fck;
        textView.setVisibility(8);
        view2 = this.fcp.cxh;
        view2.setVisibility(8);
        view3 = this.fcp.cxg;
        view3.setVisibility(0);
        this.fcp.crz.requestFocus();
    }
}
