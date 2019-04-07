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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView agJ;
    private TextView ahN;
    private LinearLayout ceG;
    private HeadImageView itV;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        akn();
        c(attributeSet);
        jf(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        akn();
        jf(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jf(int i) {
        al.d(this.ahN, d.C0277d.common_color_10039, 1);
        al.b(this.agJ, d.f.icon_arrow_gray_right_n, i);
        this.itV.invalidate();
    }

    public void caB() {
        if (this.itV != null) {
            this.itV.setVisibility(8);
        }
    }

    public void caC() {
        if (this.itV != null) {
            this.itV.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.ahN.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.itV.startLoad(str, 26, false);
        } else {
            this.itV.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void akn() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_image_view, (ViewGroup) this, true);
        this.ceG = (LinearLayout) findViewById(d.g.container);
        this.ahN = (TextView) findViewById(d.g.text);
        this.itV = (HeadImageView) findViewById(d.g.icon);
        this.agJ = (ImageView) findViewById(d.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.ahN.setText(string);
        }
        if (color > -1) {
            this.ahN.setTextColor(color);
        }
        this.ceG.setClickable(false);
        this.ceG.setFocusable(false);
    }
}
