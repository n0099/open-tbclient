package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class SubUrlView extends LinearLayout {
    public SubUrlView(Context context) {
        super(context);
        initUI();
    }

    public SubUrlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public SubUrlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initUI();
    }

    private void initUI() {
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }
}
