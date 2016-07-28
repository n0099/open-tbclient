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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private TextView fPw;
    private ImageView fPx;
    private View fPy;
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
        LayoutInflater.from(this.mContext).inflate(u.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.fPw = (TextView) findViewById(u.g.prefix_text);
        this.fPx = (ImageView) findViewById(u.g.prefix_checked);
        this.fPy = findViewById(u.g.prefix_item_divider);
        this.fPw.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        av.k(this.fPw, u.d.cp_bg_line_d);
        this.fPx.setBackgroundDrawable(av.getDrawable(u.f.icon_set_list_ok_s));
        av.k(this.fPy, u.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.fPw.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fPw.setTextColor(i);
    }

    public void lp(boolean z) {
        if (z) {
            this.fPx.setVisibility(0);
        } else {
            this.fPx.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.fPy.getLayoutParams()).setMargins(k.c(this.mContext, u.e.ds30), 0, k.c(this.mContext, u.e.ds30), 0);
        }
    }
}
