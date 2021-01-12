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
    private TextView gtI;
    private Context mContext;
    private TextView nTj;
    private ImageView nTk;
    private View nTl;

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
        this.gtI = (TextView) findViewById(R.id.prefix_text);
        this.nTj = (TextView) findViewById(R.id.prefix_no_tip);
        this.nTk = (ImageView) findViewById(R.id.prefix_checked);
        this.nTl = findViewById(R.id.prefix_item_divider);
        this.gtI.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.nTj).nV(R.color.CAM_X0109);
        this.nTk.setImageDrawable(WebPManager.a(R.drawable.icon_pure_set_list_ok16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        ao.setBackgroundColor(this.nTl, R.color.CAM_X0204);
        ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
    }

    public void setPrefixText(String str) {
        this.gtI.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.gtI.setTextColor(i);
    }

    public void zc(boolean z) {
        this.nTj.setVisibility(z ? 0 : 8);
    }

    public void zd(boolean z) {
        if (z) {
            this.nTk.setVisibility(0);
        } else {
            this.nTk.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.nTl.getLayoutParams()).setMargins(l.getDimens(this.mContext, R.dimen.ds30), 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
        }
    }
}
