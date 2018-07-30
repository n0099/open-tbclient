package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
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
        am.i(this, d.f.btn_home_neg_feedback_reason_selector);
        am.c(this, d.f.text_home_neg_feedback_reason_selector, 4);
        int f = l.f(context, d.e.ds32);
        setPadding(f, 0, f, 0);
        setGravity(17);
        setButtonDrawable((Drawable) null);
    }
}
