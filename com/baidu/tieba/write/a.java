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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private TextView fxK;
    private ImageView fxL;
    private View fxM;
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
        this.fxK = (TextView) findViewById(r.g.prefix_text);
        this.fxL = (ImageView) findViewById(r.g.prefix_checked);
        this.fxM = findViewById(r.g.prefix_item_divider);
        this.fxK.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ar.k(this.fxK, r.d.cp_bg_line_d);
        this.fxL.setBackgroundDrawable(ar.getDrawable(r.f.icon_set_list_ok_s));
        ar.k(this.fxM, r.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.fxK.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fxK.setTextColor(i);
    }

    public void lu(boolean z) {
        if (z) {
            this.fxL.setVisibility(0);
        } else {
            this.fxL.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.fxM.getLayoutParams()).setMargins(k.e(this.mContext, r.e.ds30), 0, k.e(this.mContext, r.e.ds30), 0);
        }
    }
}
