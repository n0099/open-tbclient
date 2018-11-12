package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes6.dex */
public class ac {
    private TextView atD;
    private NavigationBarCoverTip dXG;
    private int dXH;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dXG = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.atD = new TextView(this.mContext.getPageActivity());
        this.atD.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.atD.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds112));
        this.atD.setPadding(this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds34), 0);
        this.atD.setGravity(19);
        this.atD.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbfontsize42));
        this.atD.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds2), 1.0f);
    }

    public void sx(String str) {
        if (this.dXG != null) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str) || this.dXH > 0) {
                onDestory();
                this.dXG.setVisibility(8);
                return;
            }
            this.dXG.setVisibility(0);
            this.dXH++;
            this.atD.setText(str);
            com.baidu.tbadk.core.util.al.h(this.atD, e.d.cp_cont_i);
            this.dXG.removeAllViews();
            this.dXG.addView(this.atD);
            this.dXG.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.dXG != null) {
            this.dXG.onDestroy();
        }
    }
}
