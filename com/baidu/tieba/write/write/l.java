package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fOT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fOT = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fOT.dkG;
        if (view2 != null) {
            view3 = this.fOT.dkG;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.fOT.getPageContext().getPageActivity(), this.fOT.dgY);
                view4 = this.fOT.dkG;
                view4.setVisibility(8);
                textView = this.fOT.fOP;
                textView.setVisibility(0);
                view5 = this.fOT.dkH;
                view5.setVisibility(0);
                this.fOT.dgY.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.fOT.getPageContext().getPageActivity(), this.fOT.dgY);
        this.fOT.finish();
    }
}
