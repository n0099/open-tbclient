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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView gnQ;
    private Context mContext;
    private TextView nUs;
    private ImageView nUt;
    private View nUu;

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
        this.gnQ = (TextView) findViewById(R.id.prefix_text);
        this.nUs = (TextView) findViewById(R.id.prefix_no_tip);
        this.nUt = (ImageView) findViewById(R.id.prefix_checked);
        this.nUu = findViewById(R.id.prefix_item_divider);
        this.gnQ.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.nUs).ps(R.color.CAM_X0109);
        this.nUt.setImageDrawable(WebPManager.a(R.drawable.icon_pure_set_list_ok16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        ap.setBackgroundColor(this.nUu, R.color.CAM_X0204);
        ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.gnQ.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.gnQ.setTextColor(i);
    }

    public void zf(boolean z) {
        this.nUs.setVisibility(z ? 0 : 8);
    }

    public void zg(boolean z) {
        if (z) {
            this.nUt.setVisibility(0);
        } else {
            this.nUt.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.nUu.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
