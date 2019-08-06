package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private TextView bOs;
    private NavigationBarCoverTip fTi;
    private int fTj;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.fTi = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.bOs = new TextView(this.mContext.getPageActivity());
        this.bOs.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bOs.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.bOs.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.bOs.setGravity(19);
        this.bOs.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.bOs.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void BZ(String str) {
        if (this.fTi != null) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str) || this.fTj > 0) {
                onDestory();
                this.fTi.setVisibility(8);
                return;
            }
            this.fTi.setVisibility(0);
            this.fTj++;
            this.bOs.setText(str);
            com.baidu.tbadk.core.util.am.j(this.bOs, R.color.cp_btn_a);
            this.fTi.removeAllViews();
            this.fTi.addView(this.bOs);
            this.fTi.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.fTi != null) {
            this.fTi.onDestroy();
        }
    }
}
