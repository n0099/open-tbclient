package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fcq = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fcq.cxg;
        if (view2 != null) {
            view3 = this.fcq.cxg;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.a(this.fcq.getPageContext().getPageActivity(), this.fcq.crz);
                view4 = this.fcq.cxg;
                view4.setVisibility(8);
                textView = this.fcq.fcl;
                textView.setVisibility(0);
                view5 = this.fcq.cxh;
                view5.setVisibility(0);
                this.fcq.crz.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.a(this.fcq.getPageContext().getPageActivity(), this.fcq.crz);
        this.fcq.finish();
    }
}
