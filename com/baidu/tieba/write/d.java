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
    private TextView cyb;
    private ImageView hMJ;
    private View hMK;
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
        this.cyb = (TextView) findViewById(d.g.prefix_text);
        this.hMJ = (ImageView) findViewById(d.g.prefix_checked);
        this.hMK = findViewById(d.g.prefix_item_divider);
        this.cyb.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aj.s(this.cyb, d.C0108d.cp_bg_line_d);
        this.hMJ.setBackgroundDrawable(aj.getDrawable(d.f.icon_set_list_ok_s));
        aj.s(this.hMK, d.C0108d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.cyb.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cyb.setTextColor(i);
    }

    public void oq(boolean z) {
        if (z) {
            this.hMJ.setVisibility(0);
        } else {
            this.hMJ.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hMK.getLayoutParams()).setMargins(l.s(this.mContext, d.e.ds30), 0, l.s(this.mContext, d.e.ds30), 0);
        }
    }
}
