package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class l extends com.baidu.tbadk.k.c {
    private static final int kwS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    private static final int kwT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        initView();
    }

    private void initView() {
        if (this.epA != null && (this.epA.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epA.getLayoutParams();
            layoutParams.width = kwS;
            layoutParams.height = kwS;
            layoutParams.topMargin = kwT;
            this.epA.setLayoutParams(layoutParams);
        }
    }
}
