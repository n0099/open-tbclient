package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class AdCloseReasonCheckBox extends CheckBox {
    public AdCloseReasonCheckBox(Context context) {
        super(context);
        init(context);
    }

    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        ap.setBackgroundResource(this, R.drawable.btn_home_neg_feedback_reason_selector);
        ap.setViewTextColor(this, R.drawable.text_home_neg_feedback_reason_selector, 4);
        int dimens = l.getDimens(context, R.dimen.ds32);
        setPadding(dimens, 0, dimens, 0);
        setGravity(17);
        setButtonDrawable((Drawable) null);
    }
}
