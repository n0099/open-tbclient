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
    private TextView gyq;
    private ImageView gyr;
    private View gys;
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
        this.gyq = (TextView) findViewById(d.h.prefix_text);
        this.gyr = (ImageView) findViewById(d.h.prefix_checked);
        this.gys = findViewById(d.h.prefix_item_divider);
        this.gyq.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ai.j(this.gyq, d.e.cp_bg_line_d);
        this.gyr.setBackgroundDrawable(ai.getDrawable(d.g.icon_set_list_ok_s));
        ai.j(this.gys, d.e.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.gyq.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.gyq.setTextColor(i);
    }

    public void mZ(boolean z) {
        if (z) {
            this.gyr.setVisibility(0);
        } else {
            this.gyr.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.gys.getLayoutParams()).setMargins(k.g(this.mContext, d.f.ds30), 0, k.g(this.mContext, d.f.ds30), 0);
        }
    }
}
