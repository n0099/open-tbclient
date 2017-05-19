package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fRd = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fRd.dfA;
        if (view2 != null) {
            view3 = this.fRd.dfA;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.fRd.getPageContext().getPageActivity(), this.fRd.dbN);
                view4 = this.fRd.dfA;
                view4.setVisibility(8);
                textView = this.fRd.fQZ;
                textView.setVisibility(0);
                view5 = this.fRd.dfB;
                view5.setVisibility(0);
                this.fRd.dbN.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.fRd.getPageContext().getPageActivity(), this.fRd.dbN);
        this.fRd.finish();
    }
}
