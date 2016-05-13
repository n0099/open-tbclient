package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fcp = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fcp.cxg;
        if (view2 != null) {
            view3 = this.fcp.cxg;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.a(this.fcp.getPageContext().getPageActivity(), this.fcp.crz);
                view4 = this.fcp.cxg;
                view4.setVisibility(8);
                textView = this.fcp.fck;
                textView.setVisibility(0);
                view5 = this.fcp.cxh;
                view5.setVisibility(0);
                this.fcp.crz.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.a(this.fcp.getPageContext().getPageActivity(), this.fcp.crz);
        this.fcp.finish();
    }
}
