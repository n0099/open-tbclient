package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ac {
    private TextView alt;
    private NavigationBarCoverTip dHm;
    private int dHn;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dHm = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.alt = new TextView(this.mContext.getPageActivity());
        this.alt.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.alt.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds112));
        this.alt.setPadding(this.mContext.getResources().getDimensionPixelSize(f.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(f.e.ds34), 0);
        this.alt.setGravity(19);
        this.alt.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(f.e.tbfontsize42));
        this.alt.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(f.e.ds2), 1.0f);
    }

    public void ro(String str) {
        if (this.dHm != null) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str) || this.dHn > 0) {
                onDestory();
                this.dHm.setVisibility(8);
                return;
            }
            this.dHm.setVisibility(0);
            this.dHn++;
            this.alt.setText(str);
            com.baidu.tbadk.core.util.am.h(this.alt, f.d.cp_cont_i);
            this.dHm.removeAllViews();
            this.dHm.addView(this.alt);
            this.dHm.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dHm != null) {
            this.dHm.onDestroy();
        }
    }
}
