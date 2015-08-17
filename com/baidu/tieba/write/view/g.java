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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class g extends LinearLayout {
    private TextView cST;
    private ImageView cSU;
    private View cSV;
    private Context mContext;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(i.g.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.cST = (TextView) findViewById(i.f.prefix_text);
        this.cSU = (ImageView) findViewById(i.f.prefix_checked);
        this.cSV = findViewById(i.f.prefix_item_divider);
        this.cST.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        al.i((View) this.cST, i.c.cp_bg_line_d);
        this.cSU.setBackgroundDrawable(al.getDrawable(i.e.icon_set_list_ok_s));
        al.i(this.cSV, i.c.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.cST.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cST.setTextColor(i);
    }

    public void fX(boolean z) {
        if (z) {
            this.cSU.setVisibility(0);
        } else {
            this.cSU.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.cSV.getLayoutParams()).setMargins(k.d(this.mContext, i.d.ds30), 0, k.d(this.mContext, i.d.ds30), 0);
        }
    }
}
