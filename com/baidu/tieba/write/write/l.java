package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fKA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fKA = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fKA.dio;
        if (view2 != null) {
            view3 = this.fKA.dio;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.fKA.getPageContext().getPageActivity(), this.fKA.deH);
                view4 = this.fKA.dio;
                view4.setVisibility(8);
                textView = this.fKA.fKw;
                textView.setVisibility(0);
                view5 = this.fKA.dip;
                view5.setVisibility(0);
                this.fKA.deH.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.fKA.getPageContext().getPageActivity(), this.fKA.deH);
        this.fKA.finish();
    }
}
