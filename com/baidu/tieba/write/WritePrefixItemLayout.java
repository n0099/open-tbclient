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
    private TextView fnd;
    private TextView kOf;
    private ImageView kOg;
    private View kOh;
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
        this.fnd = (TextView) findViewById(R.id.prefix_text);
        this.kOf = (TextView) findViewById(R.id.prefix_no_tip);
        this.kOg = (ImageView) findViewById(R.id.prefix_checked);
        this.kOh = findViewById(R.id.prefix_item_divider);
        this.fnd.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        am.setViewTextColor(this.kOf, (int) R.color.cp_cont_d);
        this.kOg.setBackgroundDrawable(am.getDrawable(R.drawable.icon_set_list_ok_s));
        am.setBackgroundColor(this.kOh, R.color.cp_bg_line_c);
        am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.fnd.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fnd.setTextColor(i);
    }

    public void tQ(boolean z) {
        this.kOf.setVisibility(z ? 0 : 8);
    }

    public void tR(boolean z) {
        if (z) {
            this.kOg.setVisibility(0);
        } else {
            this.kOg.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.kOh.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
