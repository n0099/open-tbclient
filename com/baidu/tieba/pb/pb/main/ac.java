package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ac {
    private TextView aQK;
    private NavigationBarCoverTip dSJ;
    private int dSK;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dSJ = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.aQK = new TextView(this.mContext.getPageActivity());
        this.aQK.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.aQK.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.aQK.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.aQK.setGravity(19);
        this.aQK.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.aQK.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void qn(String str) {
        if (this.dSJ != null) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str) || this.dSK > 0) {
                onDestory();
                this.dSJ.setVisibility(8);
                return;
            }
            this.dSJ.setVisibility(0);
            this.dSK++;
            this.aQK.setText(str);
            com.baidu.tbadk.core.util.aj.r(this.aQK, d.C0108d.cp_cont_i);
            this.dSJ.removeAllViews();
            this.dSJ.addView(this.aQK);
            this.dSJ.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dSJ != null) {
            this.dSJ.onDestroy();
        }
    }
}
