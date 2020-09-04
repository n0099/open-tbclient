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
    private TextView fBQ;
    private Context mContext;
    private TextView mMV;
    private ImageView mMW;
    private View mMX;

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
        this.fBQ = (TextView) findViewById(R.id.prefix_text);
        this.mMV = (TextView) findViewById(R.id.prefix_no_tip);
        this.mMW = (ImageView) findViewById(R.id.prefix_checked);
        this.mMX = findViewById(R.id.prefix_item_divider);
        this.fBQ.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ap.setViewTextColor(this.mMV, R.color.cp_cont_d);
        this.mMW.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_set_list_ok_s));
        ap.setBackgroundColor(this.mMX, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.fBQ.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fBQ.setTextColor(i);
    }

    public void xd(boolean z) {
        this.mMV.setVisibility(z ? 0 : 8);
    }

    public void xe(boolean z) {
        if (z) {
            this.mMW.setVisibility(0);
        } else {
            this.mMW.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.mMX.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
