package com.baidu.tieba.write.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private TextView eKw;
    private ImageView eKx;
    private View eKy;
    private Context mContext;

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(t.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.eKw = (TextView) findViewById(t.g.prefix_text);
        this.eKx = (ImageView) findViewById(t.g.prefix_checked);
        this.eKy = findViewById(t.g.prefix_item_divider);
        this.eKw.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        at.k(this.eKw, t.d.cp_bg_line_d);
        this.eKx.setBackgroundDrawable(at.getDrawable(t.f.icon_set_list_ok_s));
        at.k(this.eKy, t.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.eKw.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.eKw.setTextColor(i);
    }

    public void js(boolean z) {
        if (z) {
            this.eKx.setVisibility(0);
        } else {
            this.eKx.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.eKy.getLayoutParams()).setMargins(k.c(this.mContext, t.e.ds30), 0, k.c(this.mContext, t.e.ds30), 0);
        }
    }
}
