package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private NavigationBarCoverTip fUt;
    private int fUu;
    private com.baidu.adp.base.e mContext;
    private TextView mTipView;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.fUt = navigationBarCoverTip;
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

    public void AR(String str) {
        if (this.fUt != null) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str) || this.fUu > 0) {
                onDestory();
                this.fUt.setVisibility(8);
                return;
            }
            this.fUt.setVisibility(0);
            this.fUu++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_a);
            this.fUt.removeAllViews();
            this.fUt.addView(this.mTipView);
            this.fUt.g(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.fUt != null) {
            this.fUt.onDestroy();
        }
    }
}
