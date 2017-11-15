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
    private TextView bBo;
    private ImageView gQZ;
    private View gRa;
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
        this.bBo = (TextView) findViewById(d.g.prefix_text);
        this.gQZ = (ImageView) findViewById(d.g.prefix_checked);
        this.gRa = findViewById(d.g.prefix_item_divider);
        this.bBo.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        aj.j(this.bBo, d.C0080d.cp_bg_line_d);
        this.gQZ.setBackgroundDrawable(aj.getDrawable(d.f.icon_set_list_ok_s));
        aj.j(this.gRa, d.C0080d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.bBo.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.bBo.setTextColor(i);
    }

    public void nt(boolean z) {
        if (z) {
            this.gQZ.setVisibility(0);
        } else {
            this.gQZ.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.gRa.getLayoutParams()).setMargins(l.f(this.mContext, d.e.ds30), 0, l.f(this.mContext, d.e.ds30), 0);
        }
    }
}
