package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes22.dex */
public class al {
    private NavigationBarCoverTip jku;
    private int jkv;
    private com.baidu.adp.base.e mContext;
    private TextView mTipView;

    public al(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.jku = navigationBarCoverTip;
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

    public void PL(String str) {
        if (this.jku != null) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str) || this.jkv > 0) {
                onDestory();
                this.jku.setVisibility(8);
                return;
            }
            this.jku.setVisibility(0);
            this.jkv++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTipView, R.color.cp_cont_a);
            this.jku.removeAllViews();
            this.jku.addView(this.mTipView);
            this.jku.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.jku != null) {
            this.jku.onDestroy();
        }
    }
}
