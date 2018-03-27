package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ab {
    private TextView aSa;
    private NavigationBarCoverTip dVW;
    private int dVX;
    private com.baidu.adp.base.e mContext;

    public ab(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dVW = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.aSa = new TextView(this.mContext.getPageActivity());
        this.aSa.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.aSa.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.aSa.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.aSa.setGravity(19);
        this.aSa.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.aSa.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void qv(String str) {
        if (this.dVW != null) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str) || this.dVX > 0) {
                onDestory();
                this.dVW.setVisibility(8);
                return;
            }
            this.dVW.setVisibility(0);
            this.dVX++;
            this.aSa.setText(str);
            com.baidu.tbadk.core.util.aj.r(this.aSa, d.C0141d.cp_cont_i);
            this.dVW.removeAllViews();
            this.dVW.addView(this.aSa);
            this.dVW.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dVW != null) {
            this.dVW.onDestroy();
        }
    }
}
