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
    private TextView dOj;
    private ImageView dOk;
    private View dOl;
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
        LayoutInflater.from(this.mContext).inflate(n.g.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.dOj = (TextView) findViewById(n.f.prefix_text);
        this.dOk = (ImageView) findViewById(n.f.prefix_checked);
        this.dOl = findViewById(n.f.prefix_item_divider);
        this.dOj.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        as.i((View) this.dOj, n.c.cp_bg_line_d);
        this.dOk.setBackgroundDrawable(as.getDrawable(n.e.icon_set_list_ok_s));
        as.i(this.dOl, n.c.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.dOj.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.dOj.setTextColor(i);
    }

    public void hI(boolean z) {
        if (z) {
            this.dOk.setVisibility(0);
        } else {
            this.dOk.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.dOl.getLayoutParams()).setMargins(k.d(this.mContext, n.d.ds30), 0, k.d(this.mContext, n.d.ds30), 0);
        }
    }
}
