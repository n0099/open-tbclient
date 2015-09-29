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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class g extends LinearLayout {
    private TextView dmR;
    private ImageView dmS;
    private View dmT;
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
        this.dmR = (TextView) findViewById(i.f.prefix_text);
        this.dmS = (ImageView) findViewById(i.f.prefix_checked);
        this.dmT = findViewById(i.f.prefix_item_divider);
        this.dmR.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        am.i((View) this.dmR, i.c.cp_bg_line_d);
        this.dmS.setBackgroundDrawable(am.getDrawable(i.e.icon_set_list_ok_s));
        am.i(this.dmT, i.c.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.dmR.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.dmR.setTextColor(i);
    }

    public void gX(boolean z) {
        if (z) {
            this.dmS.setVisibility(0);
        } else {
            this.dmS.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.dmT.getLayoutParams()).setMargins(k.d(this.mContext, i.d.ds30), 0, k.d(this.mContext, i.d.ds30), 0);
        }
    }
}
