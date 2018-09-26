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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout aLG;
    private TextView aLH;
    private ImageView aLL;
    private HeadImageView gIG;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Hg();
        c(attributeSet);
        eJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        Hg();
        eJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eJ(int i) {
        al.c(this.aLH, e.d.common_color_10039, 1);
        al.b(this.aLL, e.f.icon_arrow_gray_right_n, i);
        this.gIG.invalidate();
    }

    public void btM() {
        if (this.gIG != null) {
            this.gIG.setVisibility(8);
        }
    }

    public void btN() {
        if (this.gIG != null) {
            this.gIG.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aLH.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gIG.startLoad(str, 26, false);
        } else {
            this.gIG.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void Hg() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_image_view, (ViewGroup) this, true);
        this.aLG = (LinearLayout) findViewById(e.g.container);
        this.aLH = (TextView) findViewById(e.g.text);
        this.gIG = (HeadImageView) findViewById(e.g.icon);
        this.aLL = (ImageView) findViewById(e.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aLH.setText(string);
        }
        if (color > -1) {
            this.aLH.setTextColor(color);
        }
        this.aLG.setClickable(false);
        this.aLG.setFocusable(false);
    }
}
