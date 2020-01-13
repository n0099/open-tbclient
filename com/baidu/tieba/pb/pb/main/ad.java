package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes7.dex */
public class ad {
    private NavigationBarCoverTip gLo;
    private int gLp;
    private com.baidu.adp.base.e mContext;
    private TextView mTipView;

    public ad(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.gLo = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.mTipView = new TextView(this.mContext.getPageActivity());
        this.mTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mTipView.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.mTipView.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.mTipView.setGravity(19);
        this.mTipView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.mTipView.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void FL(String str) {
        if (this.gLo != null) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str) || this.gLp > 0) {
                onDestory();
                this.gLo.setVisibility(8);
                return;
            }
            this.gLo.setVisibility(0);
            this.gLp++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_a);
            this.gLo.removeAllViews();
            this.gLo.addView(this.mTipView);
            this.gLo.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.gLo != null) {
            this.gLo.onDestroy();
        }
    }
}
