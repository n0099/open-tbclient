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
    private TextView cto;
    private TextView hIr;
    private ImageView hIs;
    private View hIt;
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
        this.cto = (TextView) findViewById(e.g.prefix_text);
        this.hIr = (TextView) findViewById(e.g.prefix_no_tip);
        this.hIs = (ImageView) findViewById(e.g.prefix_checked);
        this.hIt = findViewById(e.g.prefix_item_divider);
        this.cto.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        al.h(this.hIr, e.d.cp_cont_d);
        this.hIs.setBackgroundDrawable(al.getDrawable(e.f.icon_set_list_ok_s));
        al.j(this.hIt, e.d.cp_bg_line_c);
        al.i(this, e.f.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.cto.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cto.setTextColor(i);
    }

    public void od(boolean z) {
        this.hIr.setVisibility(z ? 0 : 8);
    }

    public void oe(boolean z) {
        if (z) {
            this.hIs.setVisibility(0);
        } else {
            this.hIs.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.hIt.getLayoutParams()).setMargins(l.h(this.mContext, e.C0175e.ds30), 0, l.h(this.mContext, e.C0175e.ds30), 0);
        }
    }
}
