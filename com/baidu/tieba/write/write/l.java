package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity eLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.eLC = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.eLC.cwj;
        if (view2 != null) {
            view3 = this.eLC.cwj;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.c(this.eLC.getPageContext().getPageActivity(), this.eLC.cqC);
                view4 = this.eLC.cwj;
                view4.setVisibility(8);
                textView = this.eLC.eLx;
                textView.setVisibility(0);
                view5 = this.eLC.cwk;
                view5.setVisibility(0);
                this.eLC.cqC.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.c(this.eLC.getPageContext().getPageActivity(), this.eLC.cqC);
        this.eLC.finish();
    }
}
