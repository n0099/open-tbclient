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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private TextView gjp;
    private ImageView gjq;
    private View gjr;
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
        LayoutInflater.from(this.mContext).inflate(r.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.gjp = (TextView) findViewById(r.g.prefix_text);
        this.gjq = (ImageView) findViewById(r.g.prefix_checked);
        this.gjr = findViewById(r.g.prefix_item_divider);
        this.gjp.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        at.k(this.gjp, r.d.cp_bg_line_d);
        this.gjq.setBackgroundDrawable(at.getDrawable(r.f.icon_set_list_ok_s));
        at.k(this.gjr, r.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.gjp.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.gjp.setTextColor(i);
    }

    public void mg(boolean z) {
        if (z) {
            this.gjq.setVisibility(0);
        } else {
            this.gjq.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.gjr.getLayoutParams()).setMargins(k.e(this.mContext, r.e.ds30), 0, k.e(this.mContext, r.e.ds30), 0);
        }
    }
}
