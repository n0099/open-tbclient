package com.baidu.tieba.write.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private TextView dpf;
    private ImageView dpg;
    private View dph;
    private Context mContext;

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(i.g.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.dpf = (TextView) findViewById(i.f.prefix_text);
        this.dpg = (ImageView) findViewById(i.f.prefix_checked);
        this.dph = findViewById(i.f.prefix_item_divider);
        this.dpf.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        an.i((View) this.dpf, i.c.cp_bg_line_d);
        this.dpg.setBackgroundDrawable(an.getDrawable(i.e.icon_set_list_ok_s));
        an.i(this.dph, i.c.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.dpf.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.dpf.setTextColor(i);
    }

    public void ha(boolean z) {
        if (z) {
            this.dpg.setVisibility(0);
        } else {
            this.dpg.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.dph.getLayoutParams()).setMargins(k.d(this.mContext, i.d.ds30), 0, k.d(this.mContext, i.d.ds30), 0);
        }
    }
}
