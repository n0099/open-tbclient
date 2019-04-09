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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView dNs;
    private TextView jmf;
    private ImageView jmg;
    private View jmh;
    private Context mContext;

    public WritePrefixItemLayout(Context context) {
        this(context, null);
    }

    public WritePrefixItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.dNs = (TextView) findViewById(d.g.prefix_text);
        this.jmf = (TextView) findViewById(d.g.prefix_no_tip);
        this.jmg = (ImageView) findViewById(d.g.prefix_checked);
        this.jmh = findViewById(d.g.prefix_item_divider);
        this.dNs.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        al.j(this.jmf, d.C0277d.cp_cont_d);
        this.jmg.setBackgroundDrawable(al.getDrawable(d.f.icon_set_list_ok_s));
        al.l(this.jmh, d.C0277d.cp_bg_line_c);
        al.k(this, d.f.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.dNs.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.dNs.setTextColor(i);
    }

    public void qX(boolean z) {
        this.jmf.setVisibility(z ? 0 : 8);
    }

    public void qY(boolean z) {
        if (z) {
            this.jmg.setVisibility(0);
        } else {
            this.jmg.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.jmh.getLayoutParams()).setMargins(l.h(this.mContext, d.e.ds30), 0, l.h(this.mContext, d.e.ds30), 0);
        }
    }
}
