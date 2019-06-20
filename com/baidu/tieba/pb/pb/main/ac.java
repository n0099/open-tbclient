package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private TextView bNm;
    private NavigationBarCoverTip fNv;
    private int fNw;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.fNv = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.bNm = new TextView(this.mContext.getPageActivity());
        this.bNm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bNm.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.bNm.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.bNm.setGravity(19);
        this.bNm.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.bNm.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void Bm(String str) {
        if (this.fNv != null) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str) || this.fNw > 0) {
                onDestory();
                this.fNv.setVisibility(8);
                return;
            }
            this.fNv.setVisibility(0);
            this.fNw++;
            this.bNm.setText(str);
            com.baidu.tbadk.core.util.al.j(this.bNm, R.color.cp_btn_a);
            this.fNv.removeAllViews();
            this.fNv.addView(this.bNm);
            this.fNv.i(this.mContext.getPageActivity(), UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.fNv != null) {
            this.fNv.onDestroy();
        }
    }
}
