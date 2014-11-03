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
    private LinearLayout Pg;
    private TextView Ph;
    private ImageView Pl;
    private HeadImageView bsQ;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        qk();
        c(attributeSet);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        qk();
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    public void cu(int i) {
        com.baidu.tbadk.core.util.aw.b(this.Ph, com.baidu.tieba.s.about_tip_color, 1);
        com.baidu.tbadk.core.util.aw.c(this.Pl, com.baidu.tieba.u.icon_arrow_right);
        this.bsQ.invalidate();
    }

    public void Vw() {
        if (this.bsQ != null) {
            this.bsQ.setVisibility(8);
        }
    }

    public void Vx() {
        if (this.bsQ != null) {
            this.bsQ.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.Ph.setText(str);
    }

    public void x(String str, boolean z) {
        if (z) {
            this.bsQ.c(str, 26, false);
        } else {
            this.bsQ.c(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void qk() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.setting_text_image_view, this, true);
        this.Pg = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.Ph = (TextView) findViewById(com.baidu.tieba.v.text);
        this.bsQ = (HeadImageView) findViewById(com.baidu.tieba.v.icon);
        this.Pl = (ImageView) findViewById(com.baidu.tieba.v.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.Ph.setText(string);
        }
        if (color > -1) {
            this.Ph.setTextColor(color);
        }
        this.Pg.setClickable(false);
        this.Pg.setFocusable(false);
    }
}
