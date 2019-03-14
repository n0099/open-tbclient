package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private TextView bFI;
    private NavigationBarCoverTip bso;
    private int fwP;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.bso = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.bFI = new TextView(this.mContext.getPageActivity());
        this.bFI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bFI.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.bFI.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.bFI.setGravity(19);
        this.bFI.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.bFI.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void zV(String str) {
        if (this.bso != null) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str) || this.fwP > 0) {
                onDestory();
                this.bso.setVisibility(8);
                return;
            }
            this.bso.setVisibility(0);
            this.fwP++;
            this.bFI.setText(str);
            com.baidu.tbadk.core.util.al.j(this.bFI, d.C0277d.cp_btn_a);
            this.bso.removeAllViews();
            this.bso.addView(this.bFI);
            this.bso.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.bso != null) {
            this.bso.onDestroy();
        }
    }
}
