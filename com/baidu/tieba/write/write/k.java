package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ AtListActivity dnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.dnY = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        View view4;
        TextView textView;
        View view5;
        view2 = this.dnY.bNv;
        if (view2 != null) {
            view3 = this.dnY.bNv;
            if (view3.getVisibility() == 0) {
                com.baidu.adp.lib.util.k.c(this.dnY.getPageContext().getPageActivity(), this.dnY.bHL);
                view4 = this.dnY.bNv;
                view4.setVisibility(8);
                textView = this.dnY.dnT;
                textView.setVisibility(0);
                view5 = this.dnY.bNw;
                view5.setVisibility(0);
                this.dnY.bHL.getText().clear();
                return;
            }
        }
        com.baidu.adp.lib.util.k.c(this.dnY.getPageContext().getPageActivity(), this.dnY.bHL);
        this.dnY.finish();
    }
}
