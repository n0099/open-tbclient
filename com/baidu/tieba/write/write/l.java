package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity gjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.gjY = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.gjY.dsQ;
        if (view2 != null) {
            view3 = this.gjY.dsQ;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.gjY.getPageContext().getPageActivity(), this.gjY.dpg);
                view4 = this.gjY.dsQ;
                view4.setVisibility(8);
                textView = this.gjY.gjU;
                textView.setVisibility(0);
                view5 = this.gjY.dsR;
                view5.setVisibility(0);
                this.gjY.dpg.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.gjY.getPageContext().getPageActivity(), this.gjY.dpg);
        this.gjY.finish();
    }
}
