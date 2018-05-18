package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ab {
    private TextView adw;
    private NavigationBarCoverTip dsc;
    private int dsd;
    private com.baidu.adp.base.e mContext;

    public ab(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dsc = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.adw = new TextView(this.mContext.getPageActivity());
        this.adw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.adw.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.adw.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.adw.setGravity(19);
        this.adw.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.adw.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void qE(String str) {
        if (this.dsc != null) {
            if (com.baidu.tbadk.core.util.an.isEmpty(str) || this.dsd > 0) {
                onDestory();
                this.dsc.setVisibility(8);
                return;
            }
            this.dsc.setVisibility(0);
            this.dsd++;
            this.adw.setText(str);
            com.baidu.tbadk.core.util.ak.h(this.adw, d.C0126d.cp_cont_i);
            this.dsc.removeAllViews();
            this.dsc.addView(this.adw);
            this.dsc.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dsc != null) {
            this.dsc.onDestroy();
        }
    }
}
