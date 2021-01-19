package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes10.dex */
public class IMChatFooter extends LinearLayout {
    private View oUE;

    public IMChatFooter(Context context) {
        super(context);
        initView(context);
    }

    public IMChatFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        this.oUE = new TextView(context);
        this.oUE.setLayoutParams(new LinearLayout.LayoutParams(-1, 80));
        addView(this.oUE);
    }

    public void setFooterHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oUE.getLayoutParams();
        layoutParams.height = i;
        this.oUE.setLayoutParams(layoutParams);
    }
}
