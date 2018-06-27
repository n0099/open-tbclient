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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView cdp;
    private TextView hsb;
    private ImageView hsc;
    private View hsd;
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
        LayoutInflater.from(this.mContext).inflate(d.i.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.cdp = (TextView) findViewById(d.g.prefix_text);
        this.hsb = (TextView) findViewById(d.g.prefix_no_tip);
        this.hsc = (ImageView) findViewById(d.g.prefix_checked);
        this.hsd = findViewById(d.g.prefix_item_divider);
        this.cdp.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        am.h(this.hsb, d.C0142d.cp_cont_d);
        this.hsc.setBackgroundDrawable(am.getDrawable(d.f.icon_set_list_ok_s));
        am.j(this.hsd, d.C0142d.cp_bg_line_c);
        am.i(this, d.f.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.cdp.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cdp.setTextColor(i);
    }

    public void nC(boolean z) {
        this.hsb.setVisibility(z ? 0 : 8);
    }

    public void nD(boolean z) {
        if (z) {
            this.hsc.setVisibility(0);
        } else {
            this.hsc.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hsd.getLayoutParams()).setMargins(l.e(this.mContext, d.e.ds30), 0, l.e(this.mContext, d.e.ds30), 0);
        }
    }
}
