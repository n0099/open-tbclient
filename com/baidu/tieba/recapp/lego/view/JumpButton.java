package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
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
        am.k(this, R.drawable.btn_jump_border_bg);
        am.f(this, R.color.btn_forum_focus_color, 1);
        int g = l.g(getContext(), R.dimen.ds144);
        int g2 = l.g(getContext(), R.dimen.ds50);
        setWidth(g);
        setHeight(g2);
        setGravity(17);
        setTextSize(0, l.g(getContext(), R.dimen.fontsize24));
    }
}
