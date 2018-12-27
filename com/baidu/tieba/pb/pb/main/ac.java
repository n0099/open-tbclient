package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes6.dex */
public class ac {
    private NavigationBarCoverTip alo;
    private TextView axe;
    private int ehb;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.alo = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.axe = new TextView(this.mContext.getPageActivity());
        this.axe.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.axe.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds112));
        this.axe.setPadding(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
        this.axe.setGravity(19);
        this.axe.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbfontsize42));
        this.axe.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds2), 1.0f);
    }

    public void tc(String str) {
        if (this.alo != null) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str) || this.ehb > 0) {
                onDestory();
                this.alo.setVisibility(8);
                return;
            }
            this.alo.setVisibility(0);
            this.ehb++;
            this.axe.setText(str);
            com.baidu.tbadk.core.util.al.h(this.axe, e.d.cp_cont_i);
            this.alo.removeAllViews();
            this.alo.addView(this.axe);
            this.alo.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.alo != null) {
            this.alo.onDestroy();
        }
    }
}
