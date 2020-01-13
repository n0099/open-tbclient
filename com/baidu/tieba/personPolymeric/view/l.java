package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class l extends com.baidu.tbadk.k.c {
    private static final int jqO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    private static final int jqP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        initView();
    }

    private void initView() {
        if (this.dwQ != null && (this.dwQ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dwQ.getLayoutParams();
            layoutParams.width = jqO;
            layoutParams.height = jqO;
            layoutParams.topMargin = jqP;
            this.dwQ.setLayoutParams(layoutParams);
        }
    }
}
