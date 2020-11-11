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
    private TextView ggb;
    private Context mContext;
    private TextView nEL;
    private ImageView nEM;
    private View nEN;

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
        this.ggb = (TextView) findViewById(R.id.prefix_text);
        this.nEL = (TextView) findViewById(R.id.prefix_no_tip);
        this.nEM = (ImageView) findViewById(R.id.prefix_checked);
        this.nEN = findViewById(R.id.prefix_item_divider);
        this.ggb.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ap.setViewTextColor(this.nEL, R.color.cp_cont_d);
        this.nEM.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_set_list_ok_s));
        ap.setBackgroundColor(this.nEN, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.ggb.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.ggb.setTextColor(i);
    }

    public void yt(boolean z) {
        this.nEL.setVisibility(z ? 0 : 8);
    }

    public void yu(boolean z) {
        if (z) {
            this.nEM.setVisibility(0);
        } else {
            this.nEM.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.nEN.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
