package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes22.dex */
public class al {
    private NavigationBarCoverTip jyH;
    private int jyI;
    private com.baidu.adp.base.e mContext;
    private TextView mTipView;

    public al(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.jyH = navigationBarCoverTip;
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

    public void Qp(String str) {
        if (this.jyH != null) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str) || this.jyI > 0) {
                onDestory();
                this.jyH.setVisibility(8);
                return;
            }
            this.jyH.setVisibility(0);
            this.jyI++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTipView, R.color.CAM_X0101);
            this.jyH.removeAllViews();
            this.jyH.addView(this.mTipView);
            this.jyH.i(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.jyH != null) {
            this.jyH.onDestroy();
        }
    }
}
