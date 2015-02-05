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
    private LinearLayout Vu;
    private TextView Vv;
    private ImageView Vz;
    private HeadImageView bxX;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        tO();
        c(attributeSet);
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        tO();
        da(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void da(int i) {
        com.baidu.tbadk.core.util.bc.b(this.Vv, com.baidu.tieba.t.about_tip_color, 1);
        com.baidu.tbadk.core.util.bc.c(this.Vz, com.baidu.tieba.v.icon_arrow_right);
        this.bxX.invalidate();
    }

    public void Wn() {
        if (this.bxX != null) {
            this.bxX.setVisibility(8);
        }
    }

    public void Wo() {
        if (this.bxX != null) {
            this.bxX.setVisibility(0);
        }
    }

    public void v(String str, boolean z) {
        if (z) {
            this.bxX.d(str, 26, false);
        } else {
            this.bxX.d(str, 12, false);
        }
    }

    private void tO() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.setting_text_image_view, this, true);
        this.Vu = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.Vv = (TextView) findViewById(com.baidu.tieba.w.text);
        this.bxX = (HeadImageView) findViewById(com.baidu.tieba.w.icon);
        this.Vz = (ImageView) findViewById(com.baidu.tieba.w.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.Vv.setText(string);
        }
        if (color > -1) {
            this.Vv.setTextColor(color);
        }
        this.Vu.setClickable(false);
        this.Vu.setFocusable(false);
    }
}
