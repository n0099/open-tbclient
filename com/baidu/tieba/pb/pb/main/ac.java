package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private TextView bFK;
    private NavigationBarCoverTip bsr;
    private int fwC;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.bsr = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.bFK = new TextView(this.mContext.getPageActivity());
        this.bFK.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bFK.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.bFK.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.bFK.setGravity(19);
        this.bFK.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.bFK.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void zU(String str) {
        if (this.bsr != null) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str) || this.fwC > 0) {
                onDestory();
                this.bsr.setVisibility(8);
                return;
            }
            this.bsr.setVisibility(0);
            this.fwC++;
            this.bFK.setText(str);
            com.baidu.tbadk.core.util.al.j(this.bFK, d.C0277d.cp_btn_a);
            this.bsr.removeAllViews();
            this.bsr.addView(this.bFK);
            this.bsr.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.bsr != null) {
            this.bsr.onDestroy();
        }
    }
}
