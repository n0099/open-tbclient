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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView dXR;
    private TextView jFj;
    private ImageView jFk;
    private View jFl;
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
        this.dXR = (TextView) findViewById(R.id.prefix_text);
        this.jFj = (TextView) findViewById(R.id.prefix_no_tip);
        this.jFk = (ImageView) findViewById(R.id.prefix_checked);
        this.jFl = findViewById(R.id.prefix_item_divider);
        this.dXR.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        al.j(this.jFj, R.color.cp_cont_d);
        this.jFk.setBackgroundDrawable(al.getDrawable(R.drawable.icon_set_list_ok_s));
        al.l(this.jFl, R.color.cp_bg_line_c);
        al.k(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.dXR.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.dXR.setTextColor(i);
    }

    public void rM(boolean z) {
        this.jFj.setVisibility(z ? 0 : 8);
    }

    public void rN(boolean z) {
        if (z) {
            this.jFk.setVisibility(0);
        } else {
            this.jFk.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.jFl.getLayoutParams()).setMargins(l.g(this.mContext, R.dimen.ds30), 0, l.g(this.mContext, R.dimen.ds30), 0);
        }
    }
}
