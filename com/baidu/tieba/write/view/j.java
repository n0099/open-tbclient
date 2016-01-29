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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private TextView eqB;
    private ImageView eqC;
    private View eqD;
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
        this.eqB = (TextView) findViewById(t.g.prefix_text);
        this.eqC = (ImageView) findViewById(t.g.prefix_checked);
        this.eqD = findViewById(t.g.prefix_item_divider);
        this.eqB.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ar.k(this.eqB, t.d.cp_bg_line_d);
        this.eqC.setBackgroundDrawable(ar.getDrawable(t.f.icon_set_list_ok_s));
        ar.k(this.eqD, t.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.eqB.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.eqB.setTextColor(i);
    }

    public void iC(boolean z) {
        if (z) {
            this.eqC.setVisibility(0);
        } else {
            this.eqC.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.eqD.getLayoutParams()).setMargins(k.c(this.mContext, t.e.ds30), 0, k.c(this.mContext, t.e.ds30), 0);
        }
    }
}
