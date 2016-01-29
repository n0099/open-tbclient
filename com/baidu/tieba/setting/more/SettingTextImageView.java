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
    private LinearLayout aqa;
    private TextView aqb;
    private ImageView aqf;
    private HeadImageView dLU;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bk();
        d(attributeSet);
        ej(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        Bk();
        ej(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void ej(int i) {
        com.baidu.tbadk.core.util.ar.b(this.aqb, t.d.about_tip_color, 1);
        com.baidu.tbadk.core.util.ar.c(this.aqf, t.f.icon_arrow_right);
        this.dLU.invalidate();
    }

    public void aIt() {
        if (this.dLU != null) {
            this.dLU.setVisibility(8);
        }
    }

    public void aIu() {
        if (this.dLU != null) {
            this.dLU.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aqb.setText(str);
    }

    public void H(String str, boolean z) {
        if (z) {
            this.dLU.d(str, 26, false);
        } else {
            this.dLU.d(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void Bk() {
        LayoutInflater.from(this.mContext).inflate(t.h.setting_text_image_view, (ViewGroup) this, true);
        this.aqa = (LinearLayout) findViewById(t.g.container);
        this.aqb = (TextView) findViewById(t.g.text);
        this.dLU = (HeadImageView) findViewById(t.g.icon);
        this.aqf = (ImageView) findViewById(t.g.arrow);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aqb.setText(string);
        }
        if (color > -1) {
            this.aqb.setTextColor(color);
        }
        this.aqa.setClickable(false);
        this.aqa.setFocusable(false);
    }
}
