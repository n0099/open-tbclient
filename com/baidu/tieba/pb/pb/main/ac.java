package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private TextView bOn;
    private NavigationBarCoverTip fSs;
    private int fSt;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.fSs = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.bOn = new TextView(this.mContext.getPageActivity());
        this.bOn.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bOn.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.bOn.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.bOn.setGravity(19);
        this.bOn.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.bOn.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void BY(String str) {
        if (this.fSs != null) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str) || this.fSt > 0) {
                onDestory();
                this.fSs.setVisibility(8);
                return;
            }
            this.fSs.setVisibility(0);
            this.fSt++;
            this.bOn.setText(str);
            com.baidu.tbadk.core.util.am.j(this.bOn, R.color.cp_btn_a);
            this.fSs.removeAllViews();
            this.fSs.addView(this.bOn);
            this.fSs.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.fSs != null) {
            this.fSs.onDestroy();
        }
    }
}
