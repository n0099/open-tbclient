package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class l extends com.baidu.tbadk.k.c {
    private static final int mgQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    private static final int mgR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        initView();
    }

    private void initView() {
        if (this.fsE != null && (this.fsE.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsE.getLayoutParams();
            layoutParams.width = mgQ;
            layoutParams.height = mgQ;
            layoutParams.topMargin = mgR;
            this.fsE.setLayoutParams(layoutParams);
        }
    }
}
