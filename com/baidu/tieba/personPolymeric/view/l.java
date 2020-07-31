package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class l extends com.baidu.tbadk.k.c {
    private static final int kZL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    private static final int kZM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        initView();
    }

    private void initView() {
        if (this.eEI != null && (this.eEI.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEI.getLayoutParams();
            layoutParams.width = kZL;
            layoutParams.height = kZL;
            layoutParams.topMargin = kZM;
            this.eEI.setLayoutParams(layoutParams);
        }
    }
}
