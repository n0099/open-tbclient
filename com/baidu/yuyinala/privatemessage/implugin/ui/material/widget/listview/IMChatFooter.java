package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes11.dex */
public class IMChatFooter extends LinearLayout {
    private View oZf;

    public IMChatFooter(Context context) {
        super(context);
        eO(context);
    }

    public IMChatFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        eO(context);
    }

    private void eO(Context context) {
        this.oZf = new TextView(context);
        this.oZf.setLayoutParams(new LinearLayout.LayoutParams(-1, 80));
        addView(this.oZf);
    }

    public void setFooterHeight(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oZf.getLayoutParams();
        layoutParams.height = i;
        this.oZf.setLayoutParams(layoutParams);
    }
}
