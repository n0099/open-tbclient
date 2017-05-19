package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ AtListActivity fRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtListActivity atListActivity) {
        this.fRd = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        textView = this.fRd.fQZ;
        textView.setVisibility(8);
        view2 = this.fRd.dfB;
        view2.setVisibility(8);
        view3 = this.fRd.dfA;
        view3.setVisibility(0);
        this.fRd.dbN.requestFocus();
    }
}
