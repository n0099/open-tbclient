package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class IMChatFooter extends LinearLayout {
    private View osV;

    public IMChatFooter(Context context) {
        super(context);
        dQ(context);
    }

    public IMChatFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        dQ(context);
    }

    private void dQ(Context context) {
        this.osV = new TextView(context);
        this.osV.setLayoutParams(new LinearLayout.LayoutParams(-1, 80));
        addView(this.osV);
    }

    public void setFooterHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.osV.getLayoutParams();
        layoutParams.height = i;
        this.osV.setLayoutParams(layoutParams);
    }
}
