package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ab {
    private TextView adw;
    private NavigationBarCoverTip dqU;
    private int dqV;
    private com.baidu.adp.base.e mContext;

    public ab(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dqU = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.adw = new TextView(this.mContext.getPageActivity());
        this.adw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.adw.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.adw.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.adw.setGravity(19);
        this.adw.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.adw.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void qB(String str) {
        if (this.dqU != null) {
            if (com.baidu.tbadk.core.util.an.isEmpty(str) || this.dqV > 0) {
                onDestory();
                this.dqU.setVisibility(8);
                return;
            }
            this.dqU.setVisibility(0);
            this.dqV++;
            this.adw.setText(str);
            com.baidu.tbadk.core.util.ak.h(this.adw, d.C0126d.cp_cont_i);
            this.dqU.removeAllViews();
            this.dqU.addView(this.adw);
            this.dqU.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dqU != null) {
            this.dqU.onDestroy();
        }
    }
}
