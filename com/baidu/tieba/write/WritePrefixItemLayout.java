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
    private TextView cbe;
    private TextView hnS;
    private ImageView hnT;
    private View hnU;
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
        this.cbe = (TextView) findViewById(d.g.prefix_text);
        this.hnS = (TextView) findViewById(d.g.prefix_no_tip);
        this.hnT = (ImageView) findViewById(d.g.prefix_checked);
        this.hnU = findViewById(d.g.prefix_item_divider);
        this.cbe.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        al.h(this.hnS, d.C0141d.cp_cont_d);
        this.hnT.setBackgroundDrawable(al.getDrawable(d.f.icon_set_list_ok_s));
        al.j(this.hnU, d.C0141d.cp_bg_line_c);
        al.i(this, d.f.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.cbe.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cbe.setTextColor(i);
    }

    public void nu(boolean z) {
        this.hnS.setVisibility(z ? 0 : 8);
    }

    public void nv(boolean z) {
        if (z) {
            this.hnT.setVisibility(0);
        } else {
            this.hnT.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hnU.getLayoutParams()).setMargins(l.e(this.mContext, d.e.ds30), 0, l.e(this.mContext, d.e.ds30), 0);
        }
    }
}
