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
    private TextView ceW;
    private TextView hti;
    private ImageView htj;
    private View htk;
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
        this.ceW = (TextView) findViewById(d.g.prefix_text);
        this.hti = (TextView) findViewById(d.g.prefix_no_tip);
        this.htj = (ImageView) findViewById(d.g.prefix_checked);
        this.htk = findViewById(d.g.prefix_item_divider);
        this.ceW.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        am.h(this.hti, d.C0140d.cp_cont_d);
        this.htj.setBackgroundDrawable(am.getDrawable(d.f.icon_set_list_ok_s));
        am.j(this.htk, d.C0140d.cp_bg_line_c);
        am.i(this, d.f.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.ceW.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.ceW.setTextColor(i);
    }

    public void nq(boolean z) {
        this.hti.setVisibility(z ? 0 : 8);
    }

    public void nr(boolean z) {
        if (z) {
            this.htj.setVisibility(0);
        } else {
            this.htj.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.htk.getLayoutParams()).setMargins(l.f(this.mContext, d.e.ds30), 0, l.f(this.mContext, d.e.ds30), 0);
        }
    }
}
