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
    private LinearLayout aVj;
    private ImageView ahZ;
    private TextView ajh;
    private HeadImageView hcB;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        KN();
        c(attributeSet);
        fv(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        KN();
        fv(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fv(int i) {
        al.c(this.ajh, e.d.common_color_10039, 1);
        al.b(this.ahZ, e.f.icon_arrow_gray_right_n, i);
        this.hcB.invalidate();
    }

    public void bzO() {
        if (this.hcB != null) {
            this.hcB.setVisibility(8);
        }
    }

    public void bzP() {
        if (this.hcB != null) {
            this.hcB.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.ajh.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.hcB.startLoad(str, 26, false);
        } else {
            this.hcB.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void KN() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_image_view, (ViewGroup) this, true);
        this.aVj = (LinearLayout) findViewById(e.g.container);
        this.ajh = (TextView) findViewById(e.g.text);
        this.hcB = (HeadImageView) findViewById(e.g.icon);
        this.ahZ = (ImageView) findViewById(e.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.ajh.setText(string);
        }
        if (color > -1) {
            this.ajh.setTextColor(color);
        }
        this.aVj.setClickable(false);
        this.aVj.setFocusable(false);
    }
}
