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
    private LinearLayout aUx;
    private ImageView ahQ;
    private TextView aiY;
    private HeadImageView gYr;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Kx();
        c(attributeSet);
        fu(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        Kx();
        fu(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fu(int i) {
        al.c(this.aiY, e.d.common_color_10039, 1);
        al.b(this.ahQ, e.f.icon_arrow_gray_right_n, i);
        this.gYr.invalidate();
    }

    public void byp() {
        if (this.gYr != null) {
            this.gYr.setVisibility(8);
        }
    }

    public void byq() {
        if (this.gYr != null) {
            this.gYr.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aiY.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gYr.startLoad(str, 26, false);
        } else {
            this.gYr.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void Kx() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_image_view, (ViewGroup) this, true);
        this.aUx = (LinearLayout) findViewById(e.g.container);
        this.aiY = (TextView) findViewById(e.g.text);
        this.gYr = (HeadImageView) findViewById(e.g.icon);
        this.ahQ = (ImageView) findViewById(e.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aiY.setText(string);
        }
        if (color > -1) {
            this.aiY.setTextColor(color);
        }
        this.aUx.setClickable(false);
        this.aUx.setFocusable(false);
    }
}
