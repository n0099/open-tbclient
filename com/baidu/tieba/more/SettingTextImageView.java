package com.baidu.tieba.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout US;
    private TextView UT;
    private ImageView UX;
    private HeadImageView bwn;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        tD();
        c(attributeSet);
        cT(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        tD();
        cT(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void cT(int i) {
        ax.b(this.UT, com.baidu.tieba.t.about_tip_color, 1);
        ax.c(this.UX, com.baidu.tieba.v.icon_arrow_right);
        this.bwn.invalidate();
    }

    public void VL() {
        if (this.bwn != null) {
            this.bwn.setVisibility(8);
        }
    }

    public void VM() {
        if (this.bwn != null) {
            this.bwn.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.UT.setText(str);
    }

    public void v(String str, boolean z) {
        if (z) {
            this.bwn.d(str, 26, false);
        } else {
            this.bwn.d(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void tD() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.setting_text_image_view, this, true);
        this.US = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.UT = (TextView) findViewById(com.baidu.tieba.w.text);
        this.bwn = (HeadImageView) findViewById(com.baidu.tieba.w.icon);
        this.UX = (ImageView) findViewById(com.baidu.tieba.w.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.UT.setText(string);
        }
        if (color > -1) {
            this.UT.setTextColor(color);
        }
        this.US.setClickable(false);
        this.US.setFocusable(false);
    }
}
