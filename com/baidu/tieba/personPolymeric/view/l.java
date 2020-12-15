package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class l extends com.baidu.tbadk.l.c {
    private static final int mvr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    private static final int mvs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        initView();
    }

    private void initView() {
        if (this.fzA != null && (this.fzA.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzA.getLayoutParams();
            layoutParams.width = mvr;
            layoutParams.height = mvr;
            layoutParams.topMargin = mvs;
            this.fzA.setLayoutParams(layoutParams);
        }
    }
}
