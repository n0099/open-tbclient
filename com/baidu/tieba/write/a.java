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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private TextView eXr;
    private ImageView eXs;
    private View eXt;
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
        LayoutInflater.from(this.mContext).inflate(t.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.eXr = (TextView) findViewById(t.g.prefix_text);
        this.eXs = (ImageView) findViewById(t.g.prefix_checked);
        this.eXt = findViewById(t.g.prefix_item_divider);
        this.eXr.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        at.k(this.eXr, t.d.cp_bg_line_d);
        this.eXs.setBackgroundDrawable(at.getDrawable(t.f.icon_set_list_ok_s));
        at.k(this.eXt, t.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.eXr.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.eXr.setTextColor(i);
    }

    public void kr(boolean z) {
        if (z) {
            this.eXs.setVisibility(0);
        } else {
            this.eXs.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.eXt.getLayoutParams()).setMargins(k.c(this.mContext, t.e.ds30), 0, k.c(this.mContext, t.e.ds30), 0);
        }
    }
}
