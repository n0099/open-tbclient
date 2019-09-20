package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class ac {
    private TextView bOT;
    private NavigationBarCoverTip fUZ;
    private int fVa;
    private com.baidu.adp.base.e mContext;

    public ac(com.baidu.adp.base.e eVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.mContext = eVar;
        this.fUZ = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.bOT = new TextView(this.mContext.getPageActivity());
        this.bOT.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bOT.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.bOT.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.bOT.setGravity(19);
        this.bOT.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.bOT.setLineSpacing(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void Cy(String str) {
        if (this.fUZ != null) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str) || this.fVa > 0) {
                onDestory();
                this.fUZ.setVisibility(8);
                return;
            }
            this.fUZ.setVisibility(0);
            this.fVa++;
            this.bOT.setText(str);
            com.baidu.tbadk.core.util.am.j(this.bOT, R.color.cp_cont_a);
            this.fUZ.removeAllViews();
            this.fUZ.addView(this.bOT);
            this.fUZ.j(this.mContext.getPageActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.fUZ != null) {
            this.fUZ.onDestroy();
        }
    }
}
