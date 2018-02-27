package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ab {
    private TextView aRY;
    private NavigationBarCoverTip dVQ;
    private int dVR;
    private com.baidu.adp.base.e mContext;

    public ab(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dVQ = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.aRY = new TextView(this.mContext.getPageActivity());
        this.aRY.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.aRY.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.aRY.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.aRY.setGravity(19);
        this.aRY.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.aRY.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void qv(String str) {
        if (this.dVQ != null) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str) || this.dVR > 0) {
                onDestory();
                this.dVQ.setVisibility(8);
                return;
            }
            this.dVQ.setVisibility(0);
            this.dVR++;
            this.aRY.setText(str);
            com.baidu.tbadk.core.util.aj.r(this.aRY, d.C0141d.cp_cont_i);
            this.dVQ.removeAllViews();
            this.dVQ.addView(this.aRY);
            this.dVQ.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dVQ != null) {
            this.dVQ.onDestroy();
        }
    }
}
