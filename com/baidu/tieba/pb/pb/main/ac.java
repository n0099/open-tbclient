package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ac {
    private TextView aQH;
    private NavigationBarCoverTip dSo;
    private int dSp;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dSo = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.aQH = new TextView(this.mContext.getPageActivity());
        this.aQH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.aQH.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.aQH.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.aQH.setGravity(19);
        this.aQH.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.aQH.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void qf(String str) {
        if (this.dSo != null) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str) || this.dSp > 0) {
                onDestory();
                this.dSo.setVisibility(8);
                return;
            }
            this.dSo.setVisibility(0);
            this.dSp++;
            this.aQH.setText(str);
            com.baidu.tbadk.core.util.aj.r(this.aQH, d.C0107d.cp_cont_i);
            this.dSo.removeAllViews();
            this.dSo.addView(this.aQH);
            this.dSo.j(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dSo != null) {
            this.dSo.onDestroy();
        }
    }
}
