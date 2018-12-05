package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
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
        al.i(this, e.f.btn_focus_border_bg);
        al.c(this, e.d.btn_forum_focus_color, 1);
        int h = l.h(getContext(), e.C0210e.ds144);
        int h2 = l.h(getContext(), e.C0210e.ds50);
        setWidth(h);
        setHeight(h2);
        setGravity(17);
        setTextSize(0, l.h(getContext(), e.C0210e.fontsize24));
    }
}
