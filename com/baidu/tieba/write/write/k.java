package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity erI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.erI = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.erI.clG;
        if (view2 != null) {
            view3 = this.erI.clG;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.c(this.erI.getPageContext().getPageActivity(), this.erI.cfX);
                view4 = this.erI.clG;
                view4.setVisibility(8);
                textView = this.erI.erD;
                textView.setVisibility(0);
                view5 = this.erI.clH;
                view5.setVisibility(0);
                this.erI.cfX.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.c(this.erI.getPageContext().getPageActivity(), this.erI.cfX);
        this.erI.finish();
    }
}
