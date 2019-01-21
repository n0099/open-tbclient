package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes6.dex */
public class ac {
    private NavigationBarCoverTip alI;
    private TextView axH;
    private int ehI;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.alI = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.axH = new TextView(this.mContext.getPageActivity());
        this.axH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.axH.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds112));
        this.axH.setPadding(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
        this.axH.setGravity(19);
        this.axH.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbfontsize42));
        this.axH.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds2), 1.0f);
    }

    public void ts(String str) {
        if (this.alI != null) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str) || this.ehI > 0) {
                onDestory();
                this.alI.setVisibility(8);
                return;
            }
            this.alI.setVisibility(0);
            this.ehI++;
            this.axH.setText(str);
            com.baidu.tbadk.core.util.al.h(this.axH, e.d.cp_cont_i);
            this.alI.removeAllViews();
            this.alI.addView(this.axH);
            this.alI.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.alI != null) {
            this.alI.onDestroy();
        }
    }
}
