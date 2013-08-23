package com.baidu.tieba.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class ay extends TbImageView {
    public ay(Context context) {
        super(context);
        d();
    }

    private void d() {
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.a(getContext()) > layoutParams.width * 10 && layoutParams.height > 600) {
            layoutParams.height = 600;
        }
        super.setLayoutParams(layoutParams);
    }
}
