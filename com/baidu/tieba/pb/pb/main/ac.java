package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes6.dex */
public class ac {
    private TextView asQ;
    private NavigationBarCoverTip dWu;
    private int dWv;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dWu = navigationBarCoverTip;
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
        if (this.dWu != null) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str) || this.dWv > 0) {
                onDestory();
                this.dWu.setVisibility(8);
                return;
            }
            this.dWu.setVisibility(0);
            this.dWv++;
            this.asQ.setText(str);
            com.baidu.tbadk.core.util.al.h(this.asQ, e.d.cp_cont_i);
            this.dWu.removeAllViews();
            this.dWu.addView(this.asQ);
            this.dWu.i(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dWu != null) {
            this.dWu.onDestroy();
        }
    }
}
