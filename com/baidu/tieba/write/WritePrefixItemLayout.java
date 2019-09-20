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
    private TextView edA;
    private TextView jPT;
    private ImageView jPU;
    private View jPV;
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
        this.edA = (TextView) findViewById(R.id.prefix_text);
        this.jPT = (TextView) findViewById(R.id.prefix_no_tip);
        this.jPU = (ImageView) findViewById(R.id.prefix_checked);
        this.jPV = findViewById(R.id.prefix_item_divider);
        this.edA.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        am.j(this.jPT, R.color.cp_cont_d);
        this.jPU.setBackgroundDrawable(am.getDrawable(R.drawable.icon_set_list_ok_s));
        am.l(this.jPV, R.color.cp_bg_line_c);
        am.k(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.edA.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.edA.setTextColor(i);
    }

    public void sg(boolean z) {
        this.jPT.setVisibility(z ? 0 : 8);
    }

    public void sh(boolean z) {
        if (z) {
            this.jPU.setVisibility(0);
        } else {
            this.jPU.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.jPV.getLayoutParams()).setMargins(l.g(this.mContext, R.dimen.ds30), 0, l.g(this.mContext, R.dimen.ds30), 0);
        }
    }
}
