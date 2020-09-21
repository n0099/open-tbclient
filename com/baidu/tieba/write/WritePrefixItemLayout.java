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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView fFc;
    private Context mContext;
    private TextView mWS;
    private ImageView mWT;
    private View mWU;

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
        this.fFc = (TextView) findViewById(R.id.prefix_text);
        this.mWS = (TextView) findViewById(R.id.prefix_no_tip);
        this.mWT = (ImageView) findViewById(R.id.prefix_checked);
        this.mWU = findViewById(R.id.prefix_item_divider);
        this.fFc.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ap.setViewTextColor(this.mWS, R.color.cp_cont_d);
        this.mWT.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_set_list_ok_s));
        ap.setBackgroundColor(this.mWU, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.fFc.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fFc.setTextColor(i);
    }

    public void xm(boolean z) {
        this.mWS.setVisibility(z ? 0 : 8);
    }

    public void xn(boolean z) {
        if (z) {
            this.mWT.setVisibility(0);
        } else {
            this.mWT.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.mWU.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
