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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private TextView gzB;
    private ImageView gzC;
    private View gzD;
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
        this.gzB = (TextView) findViewById(d.h.prefix_text);
        this.gzC = (ImageView) findViewById(d.h.prefix_checked);
        this.gzD = findViewById(d.h.prefix_item_divider);
        this.gzB.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ai.j(this.gzB, d.e.cp_bg_line_d);
        this.gzC.setBackgroundDrawable(ai.getDrawable(d.g.icon_set_list_ok_s));
        ai.j(this.gzD, d.e.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.gzB.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.gzB.setTextColor(i);
    }

    public void mZ(boolean z) {
        if (z) {
            this.gzC.setVisibility(0);
        } else {
            this.gzC.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.gzD.getLayoutParams()).setMargins(k.g(this.mContext, d.f.ds30), 0, k.g(this.mContext, d.f.ds30), 0);
        }
    }
}
