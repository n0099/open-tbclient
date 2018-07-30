package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ac {
    private TextView alu;
    private NavigationBarCoverTip dHq;
    private int dHr;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dHq = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.alu = new TextView(this.mContext.getPageActivity());
        this.alu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.alu.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.alu.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.alu.setGravity(19);
        this.alu.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.alu.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void rl(String str) {
        if (this.dHq != null) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str) || this.dHr > 0) {
                onDestory();
                this.dHq.setVisibility(8);
                return;
            }
            this.dHq.setVisibility(0);
            this.dHr++;
            this.alu.setText(str);
            com.baidu.tbadk.core.util.am.h(this.alu, d.C0140d.cp_cont_i);
            this.dHq.removeAllViews();
            this.dHq.addView(this.alu);
            this.dHq.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dHq != null) {
            this.dHq.onDestroy();
        }
    }
}
