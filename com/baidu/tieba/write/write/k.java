package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity doy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.doy = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.doy.bNG;
        if (view2 != null) {
            view3 = this.doy.bNG;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.c(this.doy.getPageContext().getPageActivity(), this.doy.bHW);
                view4 = this.doy.bNG;
                view4.setVisibility(8);
                textView = this.doy.dot;
                textView.setVisibility(0);
                view5 = this.doy.bNH;
                view5.setVisibility(0);
                this.doy.bHW.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.c(this.doy.getPageContext().getPageActivity(), this.doy.bHW);
        this.doy.finish();
    }
}
