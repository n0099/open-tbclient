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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout ayZ;
    private TextView aza;
    private ImageView azf;
    private HeadImageView gjL;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Cb();
        c(attributeSet);
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        Cb();
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eq(int i) {
        ak.c(this.aza, d.C0126d.common_color_10039, 1);
        ak.b(this.azf, d.f.icon_arrow_gray_right_n, i);
        this.gjL.invalidate();
    }

    public void bnf() {
        if (this.gjL != null) {
            this.gjL.setVisibility(8);
        }
    }

    public void bng() {
        if (this.gjL != null) {
            this.gjL.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aza.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gjL.startLoad(str, 26, false);
        } else {
            this.gjL.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void Cb() {
        LayoutInflater.from(this.mContext).inflate(d.i.setting_text_image_view, (ViewGroup) this, true);
        this.ayZ = (LinearLayout) findViewById(d.g.container);
        this.aza = (TextView) findViewById(d.g.text);
        this.gjL = (HeadImageView) findViewById(d.g.icon);
        this.azf = (ImageView) findViewById(d.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aza.setText(string);
        }
        if (color > -1) {
            this.aza.setTextColor(color);
        }
        this.ayZ.setClickable(false);
        this.ayZ.setFocusable(false);
    }
}
