package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class IMChatFooter extends LinearLayout {
    private View oCo;

    public IMChatFooter(Context context) {
        super(context);
        dQ(context);
    }

    public IMChatFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        dQ(context);
    }

    private void dQ(Context context) {
        this.oCo = new TextView(context);
        this.oCo.setLayoutParams(new LinearLayout.LayoutParams(-1, 80));
        addView(this.oCo);
    }

    public void setFooterHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oCo.getLayoutParams();
        layoutParams.height = i;
        this.oCo.setLayoutParams(layoutParams);
    }
}
