package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ AtListActivity fCf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtListActivity atListActivity) {
        this.fCf = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        textView = this.fCf.fCb;
        textView.setVisibility(8);
        view2 = this.fCf.dbc;
        view2.setVisibility(8);
        view3 = this.fCf.dbb;
        view3.setVisibility(0);
        this.fCf.cXt.requestFocus();
    }
}
