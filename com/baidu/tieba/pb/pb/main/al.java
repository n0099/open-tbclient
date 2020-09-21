package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes21.dex */
public class al {
    private NavigationBarCoverTip iDk;
    private int iDl;
    private com.baidu.adp.base.e mContext;
    private TextView mTipView;

    public al(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.iDk = navigationBarCoverTip;
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

    public void Oh(String str) {
        if (this.iDk != null) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str) || this.iDl > 0) {
                onDestory();
                this.iDk.setVisibility(8);
                return;
            }
            this.iDk.setVisibility(0);
            this.iDl++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mTipView, R.color.cp_cont_a);
            this.iDk.removeAllViews();
            this.iDk.addView(this.mTipView);
            this.iDk.h(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.iDk != null) {
            this.iDk.onDestroy();
        }
    }
}
