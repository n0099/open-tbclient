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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView ceT;
    private TextView htk;
    private ImageView htl;
    private View htm;
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
        LayoutInflater.from(this.mContext).inflate(f.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.ceT = (TextView) findViewById(f.g.prefix_text);
        this.htk = (TextView) findViewById(f.g.prefix_no_tip);
        this.htl = (ImageView) findViewById(f.g.prefix_checked);
        this.htm = findViewById(f.g.prefix_item_divider);
        this.ceT.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        am.h(this.htk, f.d.cp_cont_d);
        this.htl.setBackgroundDrawable(am.getDrawable(f.C0146f.icon_set_list_ok_s));
        am.j(this.htm, f.d.cp_bg_line_c);
        am.i(this, f.C0146f.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.ceT.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.ceT.setTextColor(i);
    }

    public void nq(boolean z) {
        this.htk.setVisibility(z ? 0 : 8);
    }

    public void nr(boolean z) {
        if (z) {
            this.htl.setVisibility(0);
        } else {
            this.htl.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.htm.getLayoutParams()).setMargins(l.f(this.mContext, f.e.ds30), 0, l.f(this.mContext, f.e.ds30), 0);
        }
    }
}
