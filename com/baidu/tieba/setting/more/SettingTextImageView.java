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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout aIq;
    private TextView aIr;
    private ImageView aIv;
    private HeadImageView gBq;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FQ();
        c(attributeSet);
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        FQ();
        ex(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ex(int i) {
        am.c(this.aIr, f.d.common_color_10039, 1);
        am.b(this.aIv, f.C0146f.icon_arrow_gray_right_n, i);
        this.gBq.invalidate();
    }

    public void bri() {
        if (this.gBq != null) {
            this.gBq.setVisibility(8);
        }
    }

    public void brj() {
        if (this.gBq != null) {
            this.gBq.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aIr.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gBq.startLoad(str, 26, false);
        } else {
            this.gBq.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void FQ() {
        LayoutInflater.from(this.mContext).inflate(f.h.setting_text_image_view, (ViewGroup) this, true);
        this.aIq = (LinearLayout) findViewById(f.g.container);
        this.aIr = (TextView) findViewById(f.g.text);
        this.gBq = (HeadImageView) findViewById(f.g.icon);
        this.aIv = (ImageView) findViewById(f.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, f.l.TbSettingView);
        String string = obtainStyledAttributes.getString(f.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(f.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aIr.setText(string);
        }
        if (color > -1) {
            this.aIr.setTextColor(color);
        }
        this.aIq.setClickable(false);
        this.aIq.setFocusable(false);
    }
}
