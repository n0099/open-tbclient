package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ab {
    private TextView adw;
    private NavigationBarCoverTip dqX;
    private int dqY;
    private com.baidu.adp.base.e mContext;

    public ab(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.dqX = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.adw = new TextView(this.mContext.getPageActivity());
        this.adw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.adw.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112));
        this.adw.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), 0);
        this.adw.setGravity(19);
        this.adw.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.adw.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
    }

    public void qB(String str) {
        if (this.dqX != null) {
            if (com.baidu.tbadk.core.util.an.isEmpty(str) || this.dqY > 0) {
                onDestory();
                this.dqX.setVisibility(8);
                return;
            }
            this.dqX.setVisibility(0);
            this.dqY++;
            this.adw.setText(str);
            com.baidu.tbadk.core.util.ak.h(this.adw, d.C0126d.cp_cont_i);
            this.dqX.removeAllViews();
            this.dqX.addView(this.adw);
            this.dqX.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dqX != null) {
            this.dqX.onDestroy();
        }
    }
}
