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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private TextView btW;
    private ImageView gBb;
    private View gBc;
    private Context mContext;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.j.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.btW = (TextView) findViewById(d.h.prefix_text);
        this.gBb = (ImageView) findViewById(d.h.prefix_checked);
        this.gBc = findViewById(d.h.prefix_item_divider);
        this.btW.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aj.j(this.btW, d.e.cp_bg_line_d);
        this.gBb.setBackgroundDrawable(aj.getDrawable(d.g.icon_set_list_ok_s));
        aj.j(this.gBc, d.e.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.btW.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.btW.setTextColor(i);
    }

    public void nj(boolean z) {
        if (z) {
            this.gBb.setVisibility(0);
        } else {
            this.gBb.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.gBc.getLayoutParams()).setMargins(k.f(this.mContext, d.f.ds30), 0, k.f(this.mContext, d.f.ds30), 0);
        }
    }
}
