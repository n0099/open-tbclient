package com.baidu.tieba.write;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private TextView fOP;
    private ImageView fOQ;
    private View fOR;
    private Context mContext;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.fOP = (TextView) findViewById(w.h.prefix_text);
        this.fOQ = (ImageView) findViewById(w.h.prefix_checked);
        this.fOR = findViewById(w.h.prefix_item_divider);
        this.fOP.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aq.j(this.fOP, w.e.cp_bg_line_d);
        this.fOQ.setBackgroundDrawable(aq.getDrawable(w.g.icon_set_list_ok_s));
        aq.j(this.fOR, w.e.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.fOP.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fOP.setTextColor(i);
    }

    public void lR(boolean z) {
        if (z) {
            this.fOQ.setVisibility(0);
        } else {
            this.fOQ.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.fOR.getLayoutParams()).setMargins(k.g(this.mContext, w.f.ds30), 0, k.g(this.mContext, w.f.ds30), 0);
        }
    }
}
