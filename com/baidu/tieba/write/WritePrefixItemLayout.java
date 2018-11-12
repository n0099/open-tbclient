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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView ctA;
    private TextView hKc;
    private ImageView hKd;
    private View hKe;
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
        LayoutInflater.from(this.mContext).inflate(e.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.ctA = (TextView) findViewById(e.g.prefix_text);
        this.hKc = (TextView) findViewById(e.g.prefix_no_tip);
        this.hKd = (ImageView) findViewById(e.g.prefix_checked);
        this.hKe = findViewById(e.g.prefix_item_divider);
        this.ctA.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        al.h(this.hKc, e.d.cp_cont_d);
        this.hKd.setBackgroundDrawable(al.getDrawable(e.f.icon_set_list_ok_s));
        al.j(this.hKe, e.d.cp_bg_line_c);
        al.i(this, e.f.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.ctA.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.ctA.setTextColor(i);
    }

    public void or(boolean z) {
        this.hKc.setVisibility(z ? 0 : 8);
    }

    public void os(boolean z) {
        if (z) {
            this.hKd.setVisibility(0);
        } else {
            this.hKd.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hKe.getLayoutParams()).setMargins(l.h(this.mContext, e.C0200e.ds30), 0, l.h(this.mContext, e.C0200e.ds30), 0);
        }
    }
}
