package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class l extends com.baidu.tbadk.k.c {
    private static final int jrO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    private static final int jrP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        initView();
    }

    private void initView() {
        if (this.dAW != null && (this.dAW.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dAW.getLayoutParams();
            layoutParams.width = jrO;
            layoutParams.height = jrO;
            layoutParams.topMargin = jrP;
            this.dAW.setLayoutParams(layoutParams);
        }
    }
}
