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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView cyy;
    private View hUA;
    private TextView hUy;
    private ImageView hUz;
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
        LayoutInflater.from(this.mContext).inflate(e.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.cyy = (TextView) findViewById(e.g.prefix_text);
        this.hUy = (TextView) findViewById(e.g.prefix_no_tip);
        this.hUz = (ImageView) findViewById(e.g.prefix_checked);
        this.hUA = findViewById(e.g.prefix_item_divider);
        this.cyy.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        al.h(this.hUy, e.d.cp_cont_d);
        this.hUz.setBackgroundDrawable(al.getDrawable(e.f.icon_set_list_ok_s));
        al.j(this.hUA, e.d.cp_bg_line_c);
        al.i(this, e.f.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.cyy.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cyy.setTextColor(i);
    }

    public void ow(boolean z) {
        this.hUy.setVisibility(z ? 0 : 8);
    }

    public void ox(boolean z) {
        if (z) {
            this.hUz.setVisibility(0);
        } else {
            this.hUz.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hUA.getLayoutParams()).setMargins(l.h(this.mContext, e.C0210e.ds30), 0, l.h(this.mContext, e.C0210e.ds30), 0);
        }
    }
}
