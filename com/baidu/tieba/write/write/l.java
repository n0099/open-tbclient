package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity gnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.gnC = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.gnC.dyc;
        if (view2 != null) {
            view3 = this.gnC.dyc;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.gnC.getPageContext().getPageActivity(), this.gnC.dsz);
                view4 = this.gnC.dyc;
                view4.setVisibility(8);
                textView = this.gnC.gny;
                textView.setVisibility(0);
                view5 = this.gnC.dyd;
                view5.setVisibility(0);
                this.gnC.dsz.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.gnC.getPageContext().getPageActivity(), this.gnC.dsz);
        this.gnC.finish();
    }
}
