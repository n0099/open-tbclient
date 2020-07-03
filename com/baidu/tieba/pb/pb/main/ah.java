package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes9.dex */
public class ah {
    private int ibA;
    private NavigationBarCoverTip ibz;
    private com.baidu.adp.base.e mContext;
    private TextView mTipView;

    public ah(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.ibz = navigationBarCoverTip;
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

    public void JZ(String str) {
        if (this.ibz != null) {
            if (com.baidu.tbadk.core.util.ar.isEmpty(str) || this.ibA > 0) {
                onDestory();
                this.ibz.setVisibility(8);
                return;
            }
            this.ibz.setVisibility(0);
            this.ibA++;
            this.mTipView.setText(str);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.mTipView, (int) R.color.cp_cont_a);
            this.ibz.removeAllViews();
            this.ibz.addView(this.mTipView);
            this.ibz.i(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.ibz != null) {
            this.ibz.onDestroy();
        }
    }
}
