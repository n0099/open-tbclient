package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fCf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fCf = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fCf.dbb;
        if (view2 != null) {
            view3 = this.fCf.dbb;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.fCf.getPageContext().getPageActivity(), this.fCf.cXt);
                view4 = this.fCf.dbb;
                view4.setVisibility(8);
                textView = this.fCf.fCb;
                textView.setVisibility(0);
                view5 = this.fCf.dbc;
                view5.setVisibility(0);
                this.fCf.cXt.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.fCf.getPageContext().getPageActivity(), this.fCf.cXt);
        this.fCf.finish();
    }
}
