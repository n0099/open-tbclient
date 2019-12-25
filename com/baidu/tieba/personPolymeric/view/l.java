package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class l extends com.baidu.tbadk.k.c {
    private static final int jnm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    private static final int jnn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        initView();
    }

    private void initView() {
        if (this.dwI != null && (this.dwI.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dwI.getLayoutParams();
            layoutParams.width = jnm;
            layoutParams.height = jnm;
            layoutParams.topMargin = jnn;
            this.dwI.setLayoutParams(layoutParams);
        }
    }
}
