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
    private TextView cCr;
    private ImageView hEh;
    private View hEi;
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
        this.cCr = (TextView) findViewById(d.g.prefix_text);
        this.hEh = (ImageView) findViewById(d.g.prefix_checked);
        this.hEi = findViewById(d.g.prefix_item_divider);
        this.cCr.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aj.s(this.cCr, d.C0140d.cp_bg_line_d);
        this.hEh.setBackgroundDrawable(aj.getDrawable(d.f.icon_set_list_ok_s));
        aj.s(this.hEi, d.C0140d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.cCr.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cCr.setTextColor(i);
    }

    public void nD(boolean z) {
        if (z) {
            this.hEh.setVisibility(0);
        } else {
            this.hEh.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hEi.getLayoutParams()).setMargins(l.t(this.mContext, d.e.ds30), 0, l.t(this.mContext, d.e.ds30), 0);
        }
    }
}
