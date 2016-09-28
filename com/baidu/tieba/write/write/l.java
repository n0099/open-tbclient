package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity gfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.gfY = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.gfY.dsx;
        if (view2 != null) {
            view3 = this.gfY.dsx;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.gfY.getPageContext().getPageActivity(), this.gfY.dmQ);
                view4 = this.gfY.dsx;
                view4.setVisibility(8);
                textView = this.gfY.gfU;
                textView.setVisibility(0);
                view5 = this.gfY.dsy;
                view5.setVisibility(0);
                this.gfY.dmQ.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.gfY.getPageContext().getPageActivity(), this.gfY.dmQ);
        this.gfY.finish();
    }
}
