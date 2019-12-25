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
    private TextView fgl;
    private TextView kHW;
    private ImageView kHX;
    private View kHY;
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
        this.fgl = (TextView) findViewById(R.id.prefix_text);
        this.kHW = (TextView) findViewById(R.id.prefix_no_tip);
        this.kHX = (ImageView) findViewById(R.id.prefix_checked);
        this.kHY = findViewById(R.id.prefix_item_divider);
        this.fgl.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        am.setViewTextColor(this.kHW, (int) R.color.cp_cont_d);
        this.kHX.setBackgroundDrawable(am.getDrawable(R.drawable.icon_set_list_ok_s));
        am.setBackgroundColor(this.kHY, R.color.cp_bg_line_c);
        am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.fgl.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fgl.setTextColor(i);
    }

    public void tt(boolean z) {
        this.kHW.setVisibility(z ? 0 : 8);
    }

    public void tu(boolean z) {
        if (z) {
            this.kHX.setVisibility(0);
        } else {
            this.kHX.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.kHY.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
