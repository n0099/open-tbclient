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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WritePrefixItemLayout extends LinearLayout {
    private TextView gyp;
    private Context mContext;
    private TextView nXO;
    private ImageView nXP;
    private View nXQ;

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
        this.gyp = (TextView) findViewById(R.id.prefix_text);
        this.nXO = (TextView) findViewById(R.id.prefix_no_tip);
        this.nXP = (ImageView) findViewById(R.id.prefix_checked);
        this.nXQ = findViewById(R.id.prefix_item_divider);
        this.gyp.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.nXO).pC(R.color.CAM_X0109);
        this.nXP.setImageDrawable(WebPManager.a(R.drawable.icon_pure_set_list_ok16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        ao.setBackgroundColor(this.nXQ, R.color.CAM_X0204);
        ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.gyp.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.gyp.setTextColor(i);
    }

    public void zg(boolean z) {
        this.nXO.setVisibility(z ? 0 : 8);
    }

    public void zh(boolean z) {
        if (z) {
            this.nXP.setVisibility(0);
        } else {
            this.nXP.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.nXQ.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
