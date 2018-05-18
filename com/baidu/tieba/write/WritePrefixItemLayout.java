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
    private TextView bTc;
    private TextView hbX;
    private ImageView hbY;
    private View hbZ;
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
        this.bTc = (TextView) findViewById(d.g.prefix_text);
        this.hbX = (TextView) findViewById(d.g.prefix_no_tip);
        this.hbY = (ImageView) findViewById(d.g.prefix_checked);
        this.hbZ = findViewById(d.g.prefix_item_divider);
        this.bTc.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ak.h(this.hbX, d.C0126d.cp_cont_d);
        this.hbY.setBackgroundDrawable(ak.getDrawable(d.f.icon_set_list_ok_s));
        ak.i(this.hbZ, d.C0126d.cp_bg_line_c);
        ak.i(this, d.f.wtire_prefix_item_color_bg);
    }

    public void setPrefixText(String str) {
        this.bTc.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.bTc.setTextColor(i);
    }

    public void nm(boolean z) {
        this.hbX.setVisibility(z ? 0 : 8);
    }

    public void nn(boolean z) {
        if (z) {
            this.hbY.setVisibility(0);
        } else {
            this.hbY.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hbZ.getLayoutParams()).setMargins(l.e(this.mContext, d.e.ds30), 0, l.e(this.mContext, d.e.ds30), 0);
        }
    }
}
