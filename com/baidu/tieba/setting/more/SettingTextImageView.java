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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout aqr;
    private TextView aqs;
    private ImageView aqw;
    private HeadImageView eeu;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BN();
        d(attributeSet);
        em(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        BN();
        em(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void em(int i) {
        com.baidu.tbadk.core.util.at.b(this.aqs, t.d.about_tip_color, 1);
        com.baidu.tbadk.core.util.at.c(this.aqw, t.f.icon_arrow_right);
        this.eeu.invalidate();
    }

    public void aPi() {
        if (this.eeu != null) {
            this.eeu.setVisibility(8);
        }
    }

    public void aPj() {
        if (this.eeu != null) {
            this.eeu.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aqs.setText(str);
    }

    public void I(String str, boolean z) {
        if (z) {
            this.eeu.c(str, 26, false);
        } else {
            this.eeu.c(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void BN() {
        LayoutInflater.from(this.mContext).inflate(t.h.setting_text_image_view, (ViewGroup) this, true);
        this.aqr = (LinearLayout) findViewById(t.g.container);
        this.aqs = (TextView) findViewById(t.g.text);
        this.eeu = (HeadImageView) findViewById(t.g.icon);
        this.aqw = (ImageView) findViewById(t.g.arrow);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aqs.setText(string);
        }
        if (color > -1) {
            this.aqs.setTextColor(color);
        }
        this.aqr.setClickable(false);
        this.aqr.setFocusable(false);
    }
}
