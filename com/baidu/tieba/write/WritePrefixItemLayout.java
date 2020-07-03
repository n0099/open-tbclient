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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView fli;
    private Context mContext;
    private TextView mmk;
    private ImageView mml;
    private View mmm;

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
        this.fli = (TextView) findViewById(R.id.prefix_text);
        this.mmk = (TextView) findViewById(R.id.prefix_no_tip);
        this.mml = (ImageView) findViewById(R.id.prefix_checked);
        this.mmm = findViewById(R.id.prefix_item_divider);
        this.fli.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        an.setViewTextColor(this.mmk, (int) R.color.cp_cont_d);
        this.mml.setBackgroundDrawable(an.getDrawable(R.drawable.icon_set_list_ok_s));
        an.setBackgroundColor(this.mmm, R.color.cp_bg_line_c);
        an.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.fli.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fli.setTextColor(i);
    }

    public void vI(boolean z) {
        this.mmk.setVisibility(z ? 0 : 8);
    }

    public void vJ(boolean z) {
        if (z) {
            this.mml.setVisibility(0);
        } else {
            this.mml.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.mmm.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
