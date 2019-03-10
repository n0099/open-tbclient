package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private TextView bFG;
    private NavigationBarCoverTip bsn;
    private int fwQ;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.bsn = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.bFG = new TextView(this.mContext.getPageActivity());
        this.bFG.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bFG.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.bFG.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.bFG.setGravity(19);
        this.bFG.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.bFG.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void zX(String str) {
        if (this.bsn != null) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str) || this.fwQ > 0) {
                onDestory();
                this.bsn.setVisibility(8);
                return;
            }
            this.bsn.setVisibility(0);
            this.fwQ++;
            this.bFG.setText(str);
            com.baidu.tbadk.core.util.al.j(this.bFG, d.C0236d.cp_btn_a);
            this.bsn.removeAllViews();
            this.bsn.addView(this.bFG);
            this.bsn.i(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.bsn != null) {
            this.bsn.onDestroy();
        }
    }
}
