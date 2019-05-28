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
    private TextView dXS;
    private TextView jFk;
    private ImageView jFl;
    private View jFm;
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
        this.dXS = (TextView) findViewById(R.id.prefix_text);
        this.jFk = (TextView) findViewById(R.id.prefix_no_tip);
        this.jFl = (ImageView) findViewById(R.id.prefix_checked);
        this.jFm = findViewById(R.id.prefix_item_divider);
        this.dXS.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        al.j(this.jFk, R.color.cp_cont_d);
        this.jFl.setBackgroundDrawable(al.getDrawable(R.drawable.icon_set_list_ok_s));
        al.l(this.jFm, R.color.cp_bg_line_c);
        al.k(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.dXS.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.dXS.setTextColor(i);
    }

    public void rM(boolean z) {
        this.jFk.setVisibility(z ? 0 : 8);
    }

    public void rN(boolean z) {
        if (z) {
            this.jFl.setVisibility(0);
        } else {
            this.jFl.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.jFm.getLayoutParams()).setMargins(l.g(this.mContext, R.dimen.ds30), 0, l.g(this.mContext, R.dimen.ds30), 0);
        }
    }
}
