package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity gdO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.gdO = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.gdO.dra;
        if (view2 != null) {
            view3 = this.gdO.dra;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.gdO.getPageContext().getPageActivity(), this.gdO.dlt);
                view4 = this.gdO.dra;
                view4.setVisibility(8);
                textView = this.gdO.gdK;
                textView.setVisibility(0);
                view5 = this.gdO.drb;
                view5.setVisibility(0);
                this.gdO.dlt.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.gdO.getPageContext().getPageActivity(), this.gdO.dlt);
        this.gdO.finish();
    }
}
