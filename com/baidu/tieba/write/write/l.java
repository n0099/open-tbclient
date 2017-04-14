package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fQD = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fQD.djf;
        if (view2 != null) {
            view3 = this.fQD.djf;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.fQD.getPageContext().getPageActivity(), this.fQD.dfv);
                view4 = this.fQD.djf;
                view4.setVisibility(8);
                textView = this.fQD.fQz;
                textView.setVisibility(0);
                view5 = this.fQD.djg;
                view5.setVisibility(0);
                this.fQD.dfv.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.fQD.getPageContext().getPageActivity(), this.fQD.dfv);
        this.fQD.finish();
    }
}
