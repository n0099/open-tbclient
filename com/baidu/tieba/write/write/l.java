package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity fYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.fYZ = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.fYZ.dkU;
        if (view2 != null) {
            view3 = this.fYZ.dkU;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.b(this.fYZ.getPageContext().getPageActivity(), this.fYZ.dhk);
                view4 = this.fYZ.dkU;
                view4.setVisibility(8);
                textView = this.fYZ.fYV;
                textView.setVisibility(0);
                view5 = this.fYZ.dkV;
                view5.setVisibility(0);
                this.fYZ.dhk.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.b(this.fYZ.getPageContext().getPageActivity(), this.fYZ.dhk);
        this.fYZ.finish();
    }
}
