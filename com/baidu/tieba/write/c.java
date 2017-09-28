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
public class c extends LinearLayout {
    private TextView bvH;
    private ImageView gGj;
    private View gGk;
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
        this.bvH = (TextView) findViewById(d.h.prefix_text);
        this.gGj = (ImageView) findViewById(d.h.prefix_checked);
        this.gGk = findViewById(d.h.prefix_item_divider);
        this.bvH.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aj.j(this.bvH, d.e.cp_bg_line_d);
        this.gGj.setBackgroundDrawable(aj.getDrawable(d.g.icon_set_list_ok_s));
        aj.j(this.gGk, d.e.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.bvH.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.bvH.setTextColor(i);
    }

    public void no(boolean z) {
        if (z) {
            this.gGj.setVisibility(0);
        } else {
            this.gGj.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.gGk.getLayoutParams()).setMargins(l.f(this.mContext, d.f.ds30), 0, l.f(this.mContext, d.f.ds30), 0);
        }
    }
}
