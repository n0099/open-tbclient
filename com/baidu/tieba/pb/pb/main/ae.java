package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class ae {
    private NavigationBarCoverTip jLi;
    private int jLj;
    private com.baidu.adp.base.f mContext;
    private TextView mTipView;

    public ae(com.baidu.adp.base.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = fVar;
        this.jLi = navigationBarCoverTip;
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

    public void PV(String str) {
        if (this.jLi != null) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str) || this.jLj > 0) {
                onDestory();
                this.jLi.setVisibility(8);
                return;
            }
            this.jLi.setVisibility(0);
            this.jLj++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.mTipView, R.color.CAM_X0101);
            this.jLi.removeAllViews();
            this.jLi.addView(this.mTipView);
            this.jLi.i(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.jLi != null) {
            this.jLi.onDestroy();
        }
    }
}
