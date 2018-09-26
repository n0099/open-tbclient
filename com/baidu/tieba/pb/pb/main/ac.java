package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ac {
    private TextView anY;
    private NavigationBarCoverTip dOy;
    private int dOz;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dOy = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.anY = new TextView(this.mContext.getPageActivity());
        this.anY.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.anY.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds112));
        this.anY.setPadding(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds34), 0);
        this.anY.setGravity(19);
        this.anY.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbfontsize42));
        this.anY.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds2), 1.0f);
    }

    public void rV(String str) {
        if (this.dOy != null) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str) || this.dOz > 0) {
                onDestory();
                this.dOy.setVisibility(8);
                return;
            }
            this.dOy.setVisibility(0);
            this.dOz++;
            this.anY.setText(str);
            com.baidu.tbadk.core.util.al.h(this.anY, e.d.cp_cont_i);
            this.dOy.removeAllViews();
            this.dOy.addView(this.anY);
            this.dOy.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dOy != null) {
            this.dOy.onDestroy();
        }
    }
}
