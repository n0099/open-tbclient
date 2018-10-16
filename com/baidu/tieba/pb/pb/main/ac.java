package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes6.dex */
public class ac {
    private TextView asQ;
    private NavigationBarCoverTip dWt;
    private int dWu;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dWt = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.asQ = new TextView(this.mContext.getPageActivity());
        this.asQ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.asQ.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds112));
        this.asQ.setPadding(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds34), 0);
        this.asQ.setGravity(19);
        this.asQ.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbfontsize42));
        this.asQ.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds2), 1.0f);
    }

    public void sw(String str) {
        if (this.dWt != null) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str) || this.dWu > 0) {
                onDestory();
                this.dWt.setVisibility(8);
                return;
            }
            this.dWt.setVisibility(0);
            this.dWu++;
            this.asQ.setText(str);
            com.baidu.tbadk.core.util.al.h(this.asQ, e.d.cp_cont_i);
            this.dWt.removeAllViews();
            this.dWt.addView(this.asQ);
            this.dWt.i(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dWt != null) {
            this.dWt.onDestroy();
        }
    }
}
