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
    private TextView eXs;
    private ImageView eXt;
    private View eXu;
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
        this.eXs = (TextView) findViewById(t.g.prefix_text);
        this.eXt = (ImageView) findViewById(t.g.prefix_checked);
        this.eXu = findViewById(t.g.prefix_item_divider);
        this.eXs.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        at.k(this.eXs, t.d.cp_bg_line_d);
        this.eXt.setBackgroundDrawable(at.getDrawable(t.f.icon_set_list_ok_s));
        at.k(this.eXu, t.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.eXs.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.eXs.setTextColor(i);
    }

    public void kr(boolean z) {
        if (z) {
            this.eXt.setVisibility(0);
        } else {
            this.eXt.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.eXu.getLayoutParams()).setMargins(k.c(this.mContext, t.e.ds30), 0, k.c(this.mContext, t.e.ds30), 0);
        }
    }
}
