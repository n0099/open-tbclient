package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes16.dex */
public class al {
    private NavigationBarCoverTip ihB;
    private int ihC;
    private com.baidu.adp.base.e mContext;
    private TextView mTipView;

    public al(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.ihB = navigationBarCoverTip;
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

    public void KM(String str) {
        if (this.ihB != null) {
            if (com.baidu.tbadk.core.util.as.isEmpty(str) || this.ihC > 0) {
                onDestory();
                this.ihB.setVisibility(8);
                return;
            }
            this.ihB.setVisibility(0);
            this.ihC++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.mTipView, R.color.cp_cont_a);
            this.ihB.removeAllViews();
            this.ihB.addView(this.mTipView);
            this.ihB.i(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.ihB != null) {
            this.ihB.onDestroy();
        }
    }
}
