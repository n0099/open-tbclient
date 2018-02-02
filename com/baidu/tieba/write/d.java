package com.baidu.tieba.write;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private TextView cyx;
    private ImageView hCK;
    private View hCL;
    private Context mContext;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.cyx = (TextView) findViewById(d.g.prefix_text);
        this.hCK = (ImageView) findViewById(d.g.prefix_checked);
        this.hCL = findViewById(d.g.prefix_item_divider);
        this.cyx.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aj.s(this.cyx, d.C0108d.cp_bg_line_d);
        this.hCK.setBackgroundDrawable(aj.getDrawable(d.f.icon_set_list_ok_s));
        aj.s(this.hCL, d.C0108d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.cyx.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cyx.setTextColor(i);
    }

    public void nw(boolean z) {
        if (z) {
            this.hCK.setVisibility(0);
        } else {
            this.hCK.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hCL.getLayoutParams()).setMargins(l.s(this.mContext, d.e.ds30), 0, l.s(this.mContext, d.e.ds30), 0);
        }
    }
}
