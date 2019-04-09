package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private TextView bFL;
    private NavigationBarCoverTip bss;
    private int fwC;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.bss = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.bFL = new TextView(this.mContext.getPageActivity());
        this.bFL.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bFL.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.bFL.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.bFL.setGravity(19);
        this.bFL.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.bFL.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void zU(String str) {
        if (this.bss != null) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str) || this.fwC > 0) {
                onDestory();
                this.bss.setVisibility(8);
                return;
            }
            this.bss.setVisibility(0);
            this.fwC++;
            this.bFL.setText(str);
            com.baidu.tbadk.core.util.al.j(this.bFL, d.C0277d.cp_btn_a);
            this.bss.removeAllViews();
            this.bss.addView(this.bFL);
            this.bss.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.bss != null) {
            this.bss.onDestroy();
        }
    }
}
