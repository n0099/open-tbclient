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
    private TextView fRl;
    private Context mContext;
    private TextView nmq;
    private ImageView nmr;
    private View nms;

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
        this.fRl = (TextView) findViewById(R.id.prefix_text);
        this.nmq = (TextView) findViewById(R.id.prefix_no_tip);
        this.nmr = (ImageView) findViewById(R.id.prefix_checked);
        this.nms = findViewById(R.id.prefix_item_divider);
        this.fRl.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ap.setViewTextColor(this.nmq, R.color.cp_cont_d);
        this.nmr.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_set_list_ok_s));
        ap.setBackgroundColor(this.nms, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.fRl.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fRl.setTextColor(i);
    }

    public void xT(boolean z) {
        this.nmq.setVisibility(z ? 0 : 8);
    }

    public void xU(boolean z) {
        if (z) {
            this.nmr.setVisibility(0);
        } else {
            this.nmr.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.nms.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
