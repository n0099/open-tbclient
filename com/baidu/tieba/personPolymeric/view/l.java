package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class l extends com.baidu.tbadk.k.c {
    private static final int lqc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    private static final int lqd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        initView();
    }

    private void initView() {
        if (this.ePj != null && (this.ePj.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ePj.getLayoutParams();
            layoutParams.width = lqc;
            layoutParams.height = lqc;
            layoutParams.topMargin = lqd;
            this.ePj.setLayoutParams(layoutParams);
        }
    }
}
