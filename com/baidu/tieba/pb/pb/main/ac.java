package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private TextView bNl;
    private NavigationBarCoverTip fNt;
    private int fNu;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.fNt = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.bNl = new TextView(this.mContext.getPageActivity());
        this.bNl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bNl.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.bNl.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.bNl.setGravity(19);
        this.bNl.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.bNl.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void Bk(String str) {
        if (this.fNt != null) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str) || this.fNu > 0) {
                onDestory();
                this.fNt.setVisibility(8);
                return;
            }
            this.fNt.setVisibility(0);
            this.fNu++;
            this.bNl.setText(str);
            com.baidu.tbadk.core.util.al.j(this.bNl, R.color.cp_btn_a);
            this.fNt.removeAllViews();
            this.fNt.addView(this.bNl);
            this.fNt.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.fNt != null) {
            this.fNt.onDestroy();
        }
    }
}
