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
    private TextView bSn;
    private TextView haW;
    private ImageView haX;
    private View haY;
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
        this.bSn = (TextView) findViewById(d.g.prefix_text);
        this.haW = (TextView) findViewById(d.g.prefix_no_tip);
        this.haX = (ImageView) findViewById(d.g.prefix_checked);
        this.haY = findViewById(d.g.prefix_item_divider);
        this.bSn.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ak.h(this.haW, d.C0126d.cp_cont_d);
        this.haX.setBackgroundDrawable(ak.getDrawable(d.f.icon_set_list_ok_s));
        ak.i(this.haY, d.C0126d.cp_bg_line_c);
        ak.i(this, d.f.wtire_prefix_item_color_bg);
    }

    public void setPrefixText(String str) {
        this.bSn.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.bSn.setTextColor(i);
    }

    public void nl(boolean z) {
        this.haW.setVisibility(z ? 0 : 8);
    }

    public void nm(boolean z) {
        if (z) {
            this.haX.setVisibility(0);
        } else {
            this.haX.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.haY.getLayoutParams()).setMargins(l.e(this.mContext, d.e.ds30), 0, l.e(this.mContext, d.e.ds30), 0);
        }
    }
}
