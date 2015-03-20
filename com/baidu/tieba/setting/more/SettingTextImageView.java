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
    private ImageView afB;
    private LinearLayout afw;
    private TextView afx;
    private HeadImageView cbV;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        xi();
        c(attributeSet);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        xi();
        dc(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dc(int i) {
        com.baidu.tbadk.core.util.ba.b(this.afx, com.baidu.tieba.s.about_tip_color, 1);
        com.baidu.tbadk.core.util.ba.c(this.afB, com.baidu.tieba.u.icon_arrow_right);
        this.cbV.invalidate();
    }

    public void ahL() {
        if (this.cbV != null) {
            this.cbV.setVisibility(8);
        }
    }

    public void ahM() {
        if (this.cbV != null) {
            this.cbV.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.afx.setText(str);
    }

    public void C(String str, boolean z) {
        if (z) {
            this.cbV.c(str, 26, false);
        } else {
            this.cbV.c(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void xi() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.setting_text_image_view, this, true);
        this.afw = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.afx = (TextView) findViewById(com.baidu.tieba.v.text);
        this.cbV = (HeadImageView) findViewById(com.baidu.tieba.v.icon);
        this.afB = (ImageView) findViewById(com.baidu.tieba.v.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.afx.setText(string);
        }
        if (color > -1) {
            this.afx.setTextColor(color);
        }
        this.afw.setClickable(false);
        this.afw.setFocusable(false);
    }
}
