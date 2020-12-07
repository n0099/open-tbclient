package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class IMChatFooter extends LinearLayout {
    private View oSY;

    public IMChatFooter(Context context) {
        super(context);
        ev(context);
    }

    public IMChatFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ev(context);
    }

    private void ev(Context context) {
        this.oSY = new TextView(context);
        this.oSY.setLayoutParams(new LinearLayout.LayoutParams(-1, 80));
        addView(this.oSY);
    }

    public void setFooterHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oSY.getLayoutParams();
        layoutParams.height = i;
        this.oSY.setLayoutParams(layoutParams);
    }
}
