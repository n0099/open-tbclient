package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class l extends com.baidu.tbadk.k.c {
    private static final int lzg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    private static final int lzh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        initView();
    }

    private void initView() {
        if (this.eSe != null && (this.eSe.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSe.getLayoutParams();
            layoutParams.width = lzg;
            layoutParams.height = lzg;
            layoutParams.topMargin = lzh;
            this.eSe.setLayoutParams(layoutParams);
        }
    }
}
