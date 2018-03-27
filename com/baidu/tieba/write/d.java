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
    private TextView cCi;
    private ImageView hEs;
    private View hEt;
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
        this.cCi = (TextView) findViewById(d.g.prefix_text);
        this.hEs = (ImageView) findViewById(d.g.prefix_checked);
        this.hEt = findViewById(d.g.prefix_item_divider);
        this.cCi.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aj.s(this.cCi, d.C0141d.cp_bg_line_d);
        this.hEs.setBackgroundDrawable(aj.getDrawable(d.f.icon_set_list_ok_s));
        aj.s(this.hEt, d.C0141d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.cCi.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cCi.setTextColor(i);
    }

    public void nI(boolean z) {
        if (z) {
            this.hEs.setVisibility(0);
        } else {
            this.hEs.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hEt.getLayoutParams()).setMargins(l.t(this.mContext, d.e.ds30), 0, l.t(this.mContext, d.e.ds30), 0);
        }
    }
}
