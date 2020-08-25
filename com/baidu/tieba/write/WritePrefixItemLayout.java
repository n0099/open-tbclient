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
/* loaded from: classes2.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView fBM;
    private Context mContext;
    private TextView mMD;
    private ImageView mME;
    private View mMF;

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
        this.fBM = (TextView) findViewById(R.id.prefix_text);
        this.mMD = (TextView) findViewById(R.id.prefix_no_tip);
        this.mME = (ImageView) findViewById(R.id.prefix_checked);
        this.mMF = findViewById(R.id.prefix_item_divider);
        this.fBM.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ap.setViewTextColor(this.mMD, R.color.cp_cont_d);
        this.mME.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_set_list_ok_s));
        ap.setBackgroundColor(this.mMF, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.fBM.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.fBM.setTextColor(i);
    }

    public void xb(boolean z) {
        this.mMD.setVisibility(z ? 0 : 8);
    }

    public void xc(boolean z) {
        if (z) {
            this.mME.setVisibility(0);
        } else {
            this.mME.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.mMF.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
