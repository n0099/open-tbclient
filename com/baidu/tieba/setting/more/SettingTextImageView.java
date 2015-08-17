package com.baidu.tieba.setting.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SettingTextImageView extends FrameLayout {
    private TextView alM;
    private ImageView alQ;
    private LinearLayout container;
    private HeadImageView cyN;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zl();
        c(attributeSet);
        dw(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        zl();
        dw(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dw(int i) {
        com.baidu.tbadk.core.util.al.b(this.alM, i.c.about_tip_color, 1);
        com.baidu.tbadk.core.util.al.c(this.alQ, i.e.icon_arrow_right);
        this.cyN.invalidate();
    }

    public void amv() {
        if (this.cyN != null) {
            this.cyN.setVisibility(8);
        }
    }

    public void amw() {
        if (this.cyN != null) {
            this.cyN.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.alM.setText(str);
    }

    public void D(String str, boolean z) {
        if (z) {
            this.cyN.d(str, 26, false);
        } else {
            this.cyN.d(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void zl() {
        LayoutInflater.from(this.mContext).inflate(i.g.setting_text_image_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alM = (TextView) findViewById(i.f.text);
        this.cyN = (HeadImageView) findViewById(i.f.icon);
        this.alQ = (ImageView) findViewById(i.f.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.k.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.alM.setText(string);
        }
        if (color > -1) {
            this.alM.setTextColor(color);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }
}
