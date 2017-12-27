package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ac {
    private TextView aQI;
    private NavigationBarCoverTip dNM;
    private int dNN;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dNM = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.aQI = new TextView(this.mContext.getPageActivity());
        this.aQI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.aQI.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.aQI.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.aQI.setGravity(19);
        this.aQI.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.aQI.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void qd(String str) {
        if (this.dNM != null) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str) || this.dNN > 0) {
                onDestory();
                this.dNM.setVisibility(8);
                return;
            }
            this.dNM.setVisibility(0);
            this.dNN++;
            this.aQI.setText(str);
            com.baidu.tbadk.core.util.aj.r(this.aQI, d.C0108d.cp_cont_i);
            this.dNM.removeAllViews();
            this.dNM.addView(this.aQI);
            this.dNM.j(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dNM != null) {
            this.dNM.onDestroy();
        }
    }
}
