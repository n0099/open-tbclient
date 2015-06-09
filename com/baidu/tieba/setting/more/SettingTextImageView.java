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
    private LinearLayout agF;
    private TextView agG;
    private ImageView agK;
    private HeadImageView cgO;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        yc();
        c(attributeSet);
        dl(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        yc();
        dl(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dl(int i) {
        com.baidu.tbadk.core.util.ay.b(this.agG, com.baidu.tieba.n.about_tip_color, 1);
        com.baidu.tbadk.core.util.ay.c(this.agK, com.baidu.tieba.p.icon_arrow_right);
        this.cgO.invalidate();
    }

    public void ajS() {
        if (this.cgO != null) {
            this.cgO.setVisibility(8);
        }
    }

    public void ajT() {
        if (this.cgO != null) {
            this.cgO.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.agG.setText(str);
    }

    public void C(String str, boolean z) {
        if (z) {
            this.cgO.c(str, 26, false);
        } else {
            this.cgO.c(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void yc() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.setting_text_image_view, this, true);
        this.agF = (LinearLayout) findViewById(com.baidu.tieba.q.container);
        this.agG = (TextView) findViewById(com.baidu.tieba.q.text);
        this.cgO = (HeadImageView) findViewById(com.baidu.tieba.q.icon);
        this.agK = (ImageView) findViewById(com.baidu.tieba.q.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.v.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.agG.setText(string);
        }
        if (color > -1) {
            this.agG.setTextColor(color);
        }
        this.agF.setClickable(false);
        this.agF.setFocusable(false);
    }
}
