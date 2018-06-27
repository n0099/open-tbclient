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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout aIs;
    private TextView aIt;
    private ImageView aIy;
    private HeadImageView gAf;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FU();
        c(attributeSet);
        ev(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        FU();
        ev(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ev(int i) {
        am.c(this.aIt, d.C0142d.common_color_10039, 1);
        am.b(this.aIy, d.f.icon_arrow_gray_right_n, i);
        this.gAf.invalidate();
    }

    public void bsE() {
        if (this.gAf != null) {
            this.gAf.setVisibility(8);
        }
    }

    public void bsF() {
        if (this.gAf != null) {
            this.gAf.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aIt.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gAf.startLoad(str, 26, false);
        } else {
            this.gAf.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void FU() {
        LayoutInflater.from(this.mContext).inflate(d.i.setting_text_image_view, (ViewGroup) this, true);
        this.aIs = (LinearLayout) findViewById(d.g.container);
        this.aIt = (TextView) findViewById(d.g.text);
        this.gAf = (HeadImageView) findViewById(d.g.icon);
        this.aIy = (ImageView) findViewById(d.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aIt.setText(string);
        }
        if (color > -1) {
            this.aIt.setTextColor(color);
        }
        this.aIs.setClickable(false);
        this.aIs.setFocusable(false);
    }
}
