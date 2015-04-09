package com.baidu.tieba.setting.more;

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
    private LinearLayout afE;
    private TextView afF;
    private ImageView afJ;
    private HeadImageView cck;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        xo();
        c(attributeSet);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        xo();
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dc(int i) {
        com.baidu.tbadk.core.util.ba.b(this.afF, com.baidu.tieba.s.about_tip_color, 1);
        com.baidu.tbadk.core.util.ba.c(this.afJ, com.baidu.tieba.u.icon_arrow_right);
        this.cck.invalidate();
    }

    public void aia() {
        if (this.cck != null) {
            this.cck.setVisibility(8);
        }
    }

    public void aib() {
        if (this.cck != null) {
            this.cck.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.afF.setText(str);
    }

    public void C(String str, boolean z) {
        if (z) {
            this.cck.c(str, 26, false);
        } else {
            this.cck.c(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void xo() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.setting_text_image_view, this, true);
        this.afE = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.afF = (TextView) findViewById(com.baidu.tieba.v.text);
        this.cck = (HeadImageView) findViewById(com.baidu.tieba.v.icon);
        this.afJ = (ImageView) findViewById(com.baidu.tieba.v.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.afF.setText(string);
        }
        if (color > -1) {
            this.afF.setTextColor(color);
        }
        this.afE.setClickable(false);
        this.afE.setFocusable(false);
    }
}
