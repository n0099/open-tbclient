package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes10.dex */
public class IMChatFooter extends LinearLayout {
    private View phw;

    public IMChatFooter(Context context) {
        super(context);
        initView(context);
    }

    public IMChatFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        this.phw = new TextView(context);
        this.phw.setLayoutParams(new LinearLayout.LayoutParams(-1, 80));
        addView(this.phw);
    }

    public void setFooterHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.phw.getLayoutParams();
        layoutParams.height = i;
        this.phw.setLayoutParams(layoutParams);
    }
}
