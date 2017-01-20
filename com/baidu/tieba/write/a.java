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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private TextView fGq;
    private ImageView fGr;
    private View fGs;
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
        LayoutInflater.from(this.mContext).inflate(r.j.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.fGq = (TextView) findViewById(r.h.prefix_text);
        this.fGr = (ImageView) findViewById(r.h.prefix_checked);
        this.fGs = findViewById(r.h.prefix_item_divider);
        this.fGq.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ap.j((View) this.fGq, r.e.cp_bg_line_d);
        this.fGr.setBackgroundDrawable(ap.getDrawable(r.g.icon_set_list_ok_s));
        ap.j(this.fGs, r.e.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.fGq.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fGq.setTextColor(i);
    }

    public void lF(boolean z) {
        if (z) {
            this.fGr.setVisibility(0);
        } else {
            this.fGr.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.fGs.getLayoutParams()).setMargins(k.e(this.mContext, r.f.ds30), 0, k.e(this.mContext, r.f.ds30), 0);
        }
    }
}
