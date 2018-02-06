package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ab {
    private TextView aSj;
    private NavigationBarCoverTip dWc;
    private int dWd;
    private com.baidu.adp.base.e mContext;

    public ab(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dWc = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.aSj = new TextView(this.mContext.getPageActivity());
        this.aSj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.aSj.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.aSj.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.aSj.setGravity(19);
        this.aSj.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.aSj.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void qv(String str) {
        if (this.dWc != null) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str) || this.dWd > 0) {
                onDestory();
                this.dWc.setVisibility(8);
                return;
            }
            this.dWc.setVisibility(0);
            this.dWd++;
            this.aSj.setText(str);
            com.baidu.tbadk.core.util.aj.r(this.aSj, d.C0140d.cp_cont_i);
            this.dWc.removeAllViews();
            this.dWc.addView(this.aSj);
            this.dWc.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dWc != null) {
            this.dWc.onDestroy();
        }
    }
}
