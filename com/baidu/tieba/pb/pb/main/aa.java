package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes9.dex */
public class aa {
    private NavigationBarCoverTip gNB;
    private int gNC;
    private com.baidu.adp.base.e mContext;
    private TextView mTipView;

    public aa(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.gNB = navigationBarCoverTip;
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

    public void Gb(String str) {
        if (this.gNB != null) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str) || this.gNC > 0) {
                onDestory();
                this.gNB.setVisibility(8);
                return;
            }
            this.gNB.setVisibility(0);
            this.gNC++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_a);
            this.gNB.removeAllViews();
            this.gNB.addView(this.mTipView);
            this.gNB.l(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.gNB != null) {
            this.gNB.onDestroy();
        }
    }
}
