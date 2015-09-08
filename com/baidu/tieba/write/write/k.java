package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity dch;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.dch = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.dch.bKq;
        if (view2 != null) {
            view3 = this.dch.bKq;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.c(this.dch.getPageContext().getPageActivity(), this.dch.bEI);
                view4 = this.dch.bKq;
                view4.setVisibility(8);
                textView = this.dch.dcc;
                textView.setVisibility(0);
                view5 = this.dch.bKr;
                view5.setVisibility(0);
                this.dch.bEI.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.c(this.dch.getPageContext().getPageActivity(), this.dch.bEI);
        this.dch.finish();
    }
}
