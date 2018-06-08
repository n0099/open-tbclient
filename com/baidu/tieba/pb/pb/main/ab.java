package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ab {
    private TextView alu;
    private NavigationBarCoverTip dBp;
    private int dBq;
    private com.baidu.adp.base.e mContext;

    public ab(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dBp = navigationBarCoverTip;
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

    public void rs(String str) {
        if (this.dBp != null) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str) || this.dBq > 0) {
                onDestory();
                this.dBp.setVisibility(8);
                return;
            }
            this.dBp.setVisibility(0);
            this.dBq++;
            this.alu.setText(str);
            com.baidu.tbadk.core.util.al.h(this.alu, d.C0141d.cp_cont_i);
            this.dBp.removeAllViews();
            this.dBp.addView(this.alu);
            this.dBp.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dBp != null) {
            this.dBp.onDestroy();
        }
    }
}
