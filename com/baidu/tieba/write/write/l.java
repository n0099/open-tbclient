package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fSZ = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fSZ.dlw;
        if (view2 != null) {
            view3 = this.fSZ.dlw;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.fSZ.getPageContext().getPageActivity(), this.fSZ.dhM);
                view4 = this.fSZ.dlw;
                view4.setVisibility(8);
                textView = this.fSZ.fSV;
                textView.setVisibility(0);
                view5 = this.fSZ.dlx;
                view5.setVisibility(0);
                this.fSZ.dhM.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.fSZ.getPageContext().getPageActivity(), this.fSZ.dhM);
        this.fSZ.finish();
    }
}
