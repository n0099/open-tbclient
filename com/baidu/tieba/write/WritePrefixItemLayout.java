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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView fqq;
    private Context mContext;
    private TextView mup;
    private ImageView muq;
    private View mur;

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
        this.fqq = (TextView) findViewById(R.id.prefix_text);
        this.mup = (TextView) findViewById(R.id.prefix_no_tip);
        this.muq = (ImageView) findViewById(R.id.prefix_checked);
        this.mur = findViewById(R.id.prefix_item_divider);
        this.fqq.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ao.setViewTextColor(this.mup, R.color.cp_cont_d);
        this.muq.setBackgroundDrawable(ao.getDrawable(R.drawable.icon_set_list_ok_s));
        ao.setBackgroundColor(this.mur, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.fqq.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fqq.setTextColor(i);
    }

    public void wm(boolean z) {
        this.mup.setVisibility(z ? 0 : 8);
    }

    public void wn(boolean z) {
        if (z) {
            this.muq.setVisibility(0);
        } else {
            this.muq.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.mur.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
