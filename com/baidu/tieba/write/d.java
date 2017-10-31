package com.baidu.tieba.write;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private TextView bBc;
    private ImageView gPR;
    private View gPS;
    private Context mContext;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.bBc = (TextView) findViewById(d.g.prefix_text);
        this.gPR = (ImageView) findViewById(d.g.prefix_checked);
        this.gPS = findViewById(d.g.prefix_item_divider);
        this.bBc.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aj.j(this.bBc, d.C0080d.cp_bg_line_d);
        this.gPR.setBackgroundDrawable(aj.getDrawable(d.f.icon_set_list_ok_s));
        aj.j(this.gPS, d.C0080d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.bBc.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.bBc.setTextColor(i);
    }

    public void nl(boolean z) {
        if (z) {
            this.gPR.setVisibility(0);
        } else {
            this.gPR.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.gPS.getLayoutParams()).setMargins(l.f(this.mContext, d.e.ds30), 0, l.f(this.mContext, d.e.ds30), 0);
        }
    }
}
