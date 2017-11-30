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
    private TextView bJn;
    private ImageView hbS;
    private View hbT;
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
        this.bJn = (TextView) findViewById(d.g.prefix_text);
        this.hbS = (ImageView) findViewById(d.g.prefix_checked);
        this.hbT = findViewById(d.g.prefix_item_divider);
        this.bJn.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aj.j(this.bJn, d.C0082d.cp_bg_line_d);
        this.hbS.setBackgroundDrawable(aj.getDrawable(d.f.icon_set_list_ok_s));
        aj.j(this.hbT, d.C0082d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.bJn.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.bJn.setTextColor(i);
    }

    public void nV(boolean z) {
        if (z) {
            this.hbS.setVisibility(0);
        } else {
            this.hbS.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hbT.getLayoutParams()).setMargins(l.f(this.mContext, d.e.ds30), 0, l.f(this.mContext, d.e.ds30), 0);
        }
    }
}
