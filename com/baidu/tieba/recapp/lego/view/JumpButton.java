package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
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
        al.i(this, d.f.btn_focus_border_bg);
        al.c(this, d.C0141d.btn_forum_focus_color, 1);
        int e = l.e(getContext(), d.e.ds144);
        int e2 = l.e(getContext(), d.e.ds50);
        setWidth(e);
        setHeight(e2);
        setGravity(17);
        setTextSize(0, l.e(getContext(), d.e.fontsize24));
    }
}
