package com.baidu.tieba.write;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private TextView gdT;
    private ImageView gdU;
    private View gdV;
    private Context mContext;

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(w.j.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.gdT = (TextView) findViewById(w.h.prefix_text);
        this.gdU = (ImageView) findViewById(w.h.prefix_checked);
        this.gdV = findViewById(w.h.prefix_item_divider);
        this.gdT.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        as.j(this.gdT, w.e.cp_bg_line_d);
        this.gdU.setBackgroundDrawable(as.getDrawable(w.g.icon_set_list_ok_s));
        as.j(this.gdV, w.e.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.gdT.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.gdT.setTextColor(i);
    }

    public void mt(boolean z) {
        if (z) {
            this.gdU.setVisibility(0);
        } else {
            this.gdU.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.gdV.getLayoutParams()).setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30), 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30), 0);
        }
    }
}
