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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private TextView fZB;
    private ImageView fZC;
    private View fZD;
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
        this.fZB = (TextView) findViewById(t.g.prefix_text);
        this.fZC = (ImageView) findViewById(t.g.prefix_checked);
        this.fZD = findViewById(t.g.prefix_item_divider);
        this.fZB.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        av.k(this.fZB, t.d.cp_bg_line_d);
        this.fZC.setBackgroundDrawable(av.getDrawable(t.f.icon_set_list_ok_s));
        av.k(this.fZD, t.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.fZB.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fZB.setTextColor(i);
    }

    public void lF(boolean z) {
        if (z) {
            this.fZC.setVisibility(0);
        } else {
            this.fZC.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.fZD.getLayoutParams()).setMargins(k.e(this.mContext, t.e.ds30), 0, k.e(this.mContext, t.e.ds30), 0);
        }
    }
}
