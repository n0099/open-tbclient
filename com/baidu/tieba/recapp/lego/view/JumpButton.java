package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class JumpButton extends TextView {
    public JumpButton(Context context) {
        super(context);
        init();
    }

    private void init() {
        aj.s(this, d.f.btn_focus_border_bg);
        aj.e(this, d.C0141d.btn_forum_focus_color, 1);
        int t = l.t(getContext(), d.e.ds144);
        int t2 = l.t(getContext(), d.e.ds50);
        setWidth(t);
        setHeight(t2);
        setGravity(17);
        setTextSize(0, l.t(getContext(), d.e.fontsize24));
    }
}
