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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private TextView gbK;
    private ImageView gbL;
    private View gbM;
    private Context mContext;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(r.h.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.gbK = (TextView) findViewById(r.g.prefix_text);
        this.gbL = (ImageView) findViewById(r.g.prefix_checked);
        this.gbM = findViewById(r.g.prefix_item_divider);
        this.gbK.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        av.k(this.gbK, r.d.cp_bg_line_d);
        this.gbL.setBackgroundDrawable(av.getDrawable(r.f.icon_set_list_ok_s));
        av.k(this.gbM, r.d.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.gbK.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.gbK.setTextColor(i);
    }

    public void lH(boolean z) {
        if (z) {
            this.gbL.setVisibility(0);
        } else {
            this.gbL.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.gbM.getLayoutParams()).setMargins(k.e(this.mContext, r.e.ds30), 0, k.e(this.mContext, r.e.ds30), 0);
        }
    }
}
