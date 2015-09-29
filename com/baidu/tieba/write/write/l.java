package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity dnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.dnY = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        textView = this.dnY.dnT;
        textView.setVisibility(8);
        view2 = this.dnY.bNw;
        view2.setVisibility(8);
        view3 = this.dnY.bNv;
        view3.setVisibility(0);
        this.dnY.bHL.requestFocus();
    }
}
