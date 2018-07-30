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
    private HeadImageView gBn;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FQ();
        c(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        FQ();
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ey(int i) {
        am.c(this.aIt, d.C0140d.common_color_10039, 1);
        am.b(this.aIy, d.f.icon_arrow_gray_right_n, i);
        this.gBn.invalidate();
    }

    public void brh() {
        if (this.gBn != null) {
            this.gBn.setVisibility(8);
        }
    }

    public void bri() {
        if (this.gBn != null) {
            this.gBn.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aIt.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gBn.startLoad(str, 26, false);
        } else {
            this.gBn.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void FQ() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_image_view, (ViewGroup) this, true);
        this.aIs = (LinearLayout) findViewById(d.g.container);
        this.aIt = (TextView) findViewById(d.g.text);
        this.gBn = (HeadImageView) findViewById(d.g.icon);
        this.aIy = (ImageView) findViewById(d.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
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
