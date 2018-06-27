package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ac {
    private TextView alU;
    private NavigationBarCoverTip dED;
    private int dEE;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dED = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.alU = new TextView(this.mContext.getPageActivity());
        this.alU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.alU.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.alU.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.alU.setGravity(19);
        this.alU.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.alU.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void rr(String str) {
        if (this.dED != null) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str) || this.dEE > 0) {
                onDestory();
                this.dED.setVisibility(8);
                return;
            }
            this.dED.setVisibility(0);
            this.dEE++;
            this.alU.setText(str);
            com.baidu.tbadk.core.util.am.h(this.alU, d.C0142d.cp_cont_i);
            this.dED.removeAllViews();
            this.dED.addView(this.alU);
            this.dED.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dED != null) {
            this.dED.onDestroy();
        }
    }
}
