package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fHT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fHT = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fHT.dcw;
        if (view2 != null) {
            view3 = this.fHT.dcw;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.a(this.fHT.getPageContext().getPageActivity(), this.fHT.cWP);
                view4 = this.fHT.dcw;
                view4.setVisibility(8);
                textView = this.fHT.fHO;
                textView.setVisibility(0);
                view5 = this.fHT.dcx;
                view5.setVisibility(0);
                this.fHT.cWP.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.a(this.fHT.getPageContext().getPageActivity(), this.fHT.cWP);
        this.fHT.finish();
    }
}
