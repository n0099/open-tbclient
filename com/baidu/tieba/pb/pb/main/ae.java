package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ae {
    private NavigationBarCoverTip jMu;
    private int jMv;
    private com.baidu.adp.base.f mContext;
    private TextView mTipView;

    public ae(com.baidu.adp.base.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = fVar;
        this.jMu = navigationBarCoverTip;
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

    public void PF(String str) {
        if (this.jMu != null) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str) || this.jMv > 0) {
                onDestory();
                this.jMu.setVisibility(8);
                return;
            }
            this.jMu.setVisibility(0);
            this.jMv++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTipView, R.color.CAM_X0101);
            this.jMu.removeAllViews();
            this.jMu.addView(this.mTipView);
            this.jMu.i(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.jMu != null) {
            this.jMu.onDestroy();
        }
    }
}
