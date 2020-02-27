package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes9.dex */
public class aa {
    private NavigationBarCoverTip gNn;
    private int gNo;
    private com.baidu.adp.base.e mContext;
    private TextView mTipView;

    public aa(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.gNn = navigationBarCoverTip;
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

    public void Ga(String str) {
        if (this.gNn != null) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str) || this.gNo > 0) {
                onDestory();
                this.gNn.setVisibility(8);
                return;
            }
            this.gNn.setVisibility(0);
            this.gNo++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_a);
            this.gNn.removeAllViews();
            this.gNn.addView(this.mTipView);
            this.gNn.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.gNn != null) {
            this.gNn.onDestroy();
        }
    }
}
