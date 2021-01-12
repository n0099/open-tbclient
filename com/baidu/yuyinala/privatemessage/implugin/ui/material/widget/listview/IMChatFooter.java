package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes10.dex */
public class IMChatFooter extends LinearLayout {
    private View oUD;

    public IMChatFooter(Context context) {
        super(context);
        initView(context);
    }

    public IMChatFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        this.oUD = new TextView(context);
        this.oUD.setLayoutParams(new LinearLayout.LayoutParams(-1, 80));
        addView(this.oUD);
    }

    public void setFooterHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oUD.getLayoutParams();
        layoutParams.height = i;
        this.oUD.setLayoutParams(layoutParams);
    }
}
