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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView fad;
    private TextView lSb;
    private ImageView lSc;
    private View lSd;
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
        LayoutInflater.from(this.mContext).inflate(R.layout.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.fad = (TextView) findViewById(R.id.prefix_text);
        this.lSb = (TextView) findViewById(R.id.prefix_no_tip);
        this.lSc = (ImageView) findViewById(R.id.prefix_checked);
        this.lSd = findViewById(R.id.prefix_item_divider);
        this.fad.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        am.setViewTextColor(this.lSb, (int) R.color.cp_cont_d);
        this.lSc.setBackgroundDrawable(am.getDrawable(R.drawable.icon_set_list_ok_s));
        am.setBackgroundColor(this.lSd, R.color.cp_bg_line_c);
        am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.fad.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fad.setTextColor(i);
    }

    public void vq(boolean z) {
        this.lSb.setVisibility(z ? 0 : 8);
    }

    public void vr(boolean z) {
        if (z) {
            this.lSc.setVisibility(0);
        } else {
            this.lSc.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.lSd.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
