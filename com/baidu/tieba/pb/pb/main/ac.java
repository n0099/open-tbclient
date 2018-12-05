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
    private TextView axd;
    private int eek;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.alo = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.axd = new TextView(this.mContext.getPageActivity());
        this.axd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.axd.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds112));
        this.axd.setPadding(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
        this.axd.setGravity(19);
        this.axd.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbfontsize42));
        this.axd.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds2), 1.0f);
    }

    public void sZ(String str) {
        if (this.alo != null) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str) || this.eek > 0) {
                onDestory();
                this.alo.setVisibility(8);
                return;
            }
            this.alo.setVisibility(0);
            this.eek++;
            this.axd.setText(str);
            com.baidu.tbadk.core.util.al.h(this.axd, e.d.cp_cont_i);
            this.alo.removeAllViews();
            this.alo.addView(this.axd);
            this.alo.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.alo != null) {
            this.alo.onDestroy();
        }
    }
}
