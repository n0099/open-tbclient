package com.baidu.tieba.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout Pc;
    private TextView Pd;
    private ImageView Ph;
    private HeadImageView bsC;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        qi();
        c(attributeSet);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        qi();
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public void cu(int i) {
        com.baidu.tbadk.core.util.aw.b(this.Pd, com.baidu.tieba.s.about_tip_color, 1);
        com.baidu.tbadk.core.util.aw.c(this.Ph, com.baidu.tieba.u.icon_arrow_right);
        this.bsC.invalidate();
    }

    public void Vt() {
        if (this.bsC != null) {
            this.bsC.setVisibility(8);
        }
    }

    public void Vu() {
        if (this.bsC != null) {
            this.bsC.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.Pd.setText(str);
    }

    public void x(String str, boolean z) {
        if (z) {
            this.bsC.c(str, 26, false);
        } else {
            this.bsC.c(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void qi() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.setting_text_image_view, this, true);
        this.Pc = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.Pd = (TextView) findViewById(com.baidu.tieba.v.text);
        this.bsC = (HeadImageView) findViewById(com.baidu.tieba.v.icon);
        this.Ph = (ImageView) findViewById(com.baidu.tieba.v.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.Pd.setText(string);
        }
        if (color > -1) {
            this.Pd.setTextColor(color);
        }
        this.Pc.setClickable(false);
        this.Pc.setFocusable(false);
    }
}
