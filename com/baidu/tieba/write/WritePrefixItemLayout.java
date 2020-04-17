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
    private TextView eNq;
    private TextView lxw;
    private ImageView lxx;
    private View lxy;
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
        this.eNq = (TextView) findViewById(R.id.prefix_text);
        this.lxw = (TextView) findViewById(R.id.prefix_no_tip);
        this.lxx = (ImageView) findViewById(R.id.prefix_checked);
        this.lxy = findViewById(R.id.prefix_item_divider);
        this.eNq.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        am.setViewTextColor(this.lxw, (int) R.color.cp_cont_d);
        this.lxx.setBackgroundDrawable(am.getDrawable(R.drawable.icon_set_list_ok_s));
        am.setBackgroundColor(this.lxy, R.color.cp_bg_line_c);
        am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.eNq.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.eNq.setTextColor(i);
    }

    public void uQ(boolean z) {
        this.lxw.setVisibility(z ? 0 : 8);
    }

    public void uR(boolean z) {
        if (z) {
            this.lxx.setVisibility(0);
        } else {
            this.lxx.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.lxy.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
