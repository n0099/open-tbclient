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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private TextView dVI;
    private ImageView dVJ;
    private View dVK;
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
        LayoutInflater.from(this.mContext).inflate(n.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.dVI = (TextView) findViewById(n.g.prefix_text);
        this.dVJ = (ImageView) findViewById(n.g.prefix_checked);
        this.dVK = findViewById(n.g.prefix_item_divider);
        this.dVI.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        as.i((View) this.dVI, n.d.cp_bg_line_d);
        this.dVJ.setBackgroundDrawable(as.getDrawable(n.f.icon_set_list_ok_s));
        as.i(this.dVK, n.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.dVI.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.dVI.setTextColor(i);
    }

    public void hR(boolean z) {
        if (z) {
            this.dVJ.setVisibility(0);
        } else {
            this.dVJ.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.dVK.getLayoutParams()).setMargins(k.d(this.mContext, n.e.ds30), 0, k.d(this.mContext, n.e.ds30), 0);
        }
    }
}
