package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
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
        am.i(this, d.f.btn_focus_border_bg);
        am.c(this, d.C0140d.btn_forum_focus_color, 1);
        int f = l.f(getContext(), d.e.ds144);
        int f2 = l.f(getContext(), d.e.ds50);
        setWidth(f);
        setHeight(f2);
        setGravity(17);
        setTextSize(0, l.f(getContext(), d.e.fontsize24));
    }
}
