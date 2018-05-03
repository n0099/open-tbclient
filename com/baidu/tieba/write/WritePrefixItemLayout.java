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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView bSm;
    private TextView haT;
    private ImageView haU;
    private View haV;
    private Context mContext;

    public WritePrefixItemLayout(Context context) {
        this(context, null);
    }

    public WritePrefixItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.i.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.bSm = (TextView) findViewById(d.g.prefix_text);
        this.haT = (TextView) findViewById(d.g.prefix_no_tip);
        this.haU = (ImageView) findViewById(d.g.prefix_checked);
        this.haV = findViewById(d.g.prefix_item_divider);
        this.bSm.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ak.h(this.haT, d.C0126d.cp_cont_d);
        this.haU.setBackgroundDrawable(ak.getDrawable(d.f.icon_set_list_ok_s));
        ak.i(this.haV, d.C0126d.cp_bg_line_c);
        ak.i(this, d.f.wtire_prefix_item_color_bg);
    }

    public void setPrefixText(String str) {
        this.bSm.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.bSm.setTextColor(i);
    }

    public void nl(boolean z) {
        this.haT.setVisibility(z ? 0 : 8);
    }

    public void nm(boolean z) {
        if (z) {
            this.haU.setVisibility(0);
        } else {
            this.haU.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.haV.getLayoutParams()).setMargins(l.e(this.mContext, d.e.ds30), 0, l.e(this.mContext, d.e.ds30), 0);
        }
    }
}
