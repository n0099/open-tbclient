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
    private ImageView aHB;
    private LinearLayout aHv;
    private TextView aHw;
    private HeadImageView gwm;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FC();
        c(attributeSet);
        eu(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        FC();
        eu(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eu(int i) {
        al.c(this.aHw, d.C0141d.common_color_10039, 1);
        al.b(this.aHB, d.f.icon_arrow_gray_right_n, i);
        this.gwm.invalidate();
    }

    public void bsd() {
        if (this.gwm != null) {
            this.gwm.setVisibility(8);
        }
    }

    public void bse() {
        if (this.gwm != null) {
            this.gwm.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aHw.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gwm.startLoad(str, 26, false);
        } else {
            this.gwm.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void FC() {
        LayoutInflater.from(this.mContext).inflate(d.i.setting_text_image_view, (ViewGroup) this, true);
        this.aHv = (LinearLayout) findViewById(d.g.container);
        this.aHw = (TextView) findViewById(d.g.text);
        this.gwm = (HeadImageView) findViewById(d.g.icon);
        this.aHB = (ImageView) findViewById(d.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aHw.setText(string);
        }
        if (color > -1) {
            this.aHw.setTextColor(color);
        }
        this.aHv.setClickable(false);
        this.aHv.setFocusable(false);
    }
}
