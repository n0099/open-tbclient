package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class JumpButton extends TextView {
    public JumpButton(Context context) {
        super(context);
        init();
    }

    public JumpButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public JumpButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        ap.setBackgroundResource(this, R.drawable.ad_download_progress_button_bg);
        ap.setViewTextColor(this, R.color.CAM_X0302, 1);
        int dimens = l.getDimens(getContext(), R.dimen.ds144);
        int dimens2 = l.getDimens(getContext(), R.dimen.ds50);
        setWidth(dimens);
        setHeight(dimens2);
        setGravity(17);
        setTextSize(0, l.getDimens(getContext(), R.dimen.fontsize24));
    }
}
