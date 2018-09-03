package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
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
        am.i(this, f.C0146f.btn_focus_border_bg);
        am.c(this, f.d.btn_forum_focus_color, 1);
        int f = l.f(getContext(), f.e.ds144);
        int f2 = l.f(getContext(), f.e.ds50);
        setWidth(f);
        setHeight(f2);
        setGravity(17);
        setTextSize(0, l.f(getContext(), f.e.fontsize24));
    }
}
