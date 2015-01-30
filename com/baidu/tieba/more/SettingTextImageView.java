package com.baidu.tieba.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView VC;
    private LinearLayout Vx;
    private TextView Vy;
    private HeadImageView bxY;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        tU();
        c(attributeSet);
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        tU();
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void da(int i) {
        com.baidu.tbadk.core.util.bc.b(this.Vy, com.baidu.tieba.t.about_tip_color, 1);
        com.baidu.tbadk.core.util.bc.c(this.VC, com.baidu.tieba.v.icon_arrow_right);
        this.bxY.invalidate();
    }

    public void Ws() {
        if (this.bxY != null) {
            this.bxY.setVisibility(8);
        }
    }

    public void Wt() {
        if (this.bxY != null) {
            this.bxY.setVisibility(0);
        }
    }

    public void v(String str, boolean z) {
        if (z) {
            this.bxY.d(str, 26, false);
        } else {
            this.bxY.d(str, 12, false);
        }
    }

    private void tU() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.setting_text_image_view, this, true);
        this.Vx = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.Vy = (TextView) findViewById(com.baidu.tieba.w.text);
        this.bxY = (HeadImageView) findViewById(com.baidu.tieba.w.icon);
        this.VC = (ImageView) findViewById(com.baidu.tieba.w.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.Vy.setText(string);
        }
        if (color > -1) {
            this.Vy.setTextColor(color);
        }
        this.Vx.setClickable(false);
        this.Vx.setFocusable(false);
    }
}
